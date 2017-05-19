#Compatibility

## {{ book.must }} Don’t Break Backward Compatibility

Change APIs, but keep all consumers
running. Consumers usually have independent release lifecycles, focus on
stability, and avoid changes that do not provide additional value. APIs are
service contracts that cannot be broken via unilateral decisions.

There are two techniques to change APIs without breaking them:

- follow rules for compatible extensions
- introduce new API versions and still support older versions

We strongly encourage using compatible API extensions and discourage versioning.
With Postel’s Law in mind, here are some rules for providers and consumers that
allow us to make compatible changes without versioning:

## {{ book.must }} Prepare Clients for Compatible API Extensions (the Robustness Principle)

How to do this:

* Ignore new and unknown fields in the payload (see also Fowler’s
  “[TolerantReader](http://martinfowler.com/bliki/TolerantReader.html)” post)
* Be prepared for new enum values declared with
  [`x-extensible-enum`](#should-used-openended-list-of-values-xextensibleenum-instead-of-enumerations);
  provide default behavior for unknown values, if applicable
* Follow the redirect when the server returns an “HTTP 301 Moved Permanently” response code
* Be prepared to handle HTTP status codes not explicitly specified in endpoint definitions! Note also, that status codes are extensible -- default handling is how you would treat the corresponding x00 code (see [RFC7231  Section 6](https://tools.ietf.org/html/rfc7231#section-6))

## {{ book.must }} Always Return JSON Objects As Top-Level Data Structures To Support Extensibility

In a response body, you must always return a JSON objects (and not e.g. an array) as a top level data structure to support future extensibility. JSON objects support compatible extension by additional attributes. This allows you to easily extend your response and e.g. add pagination later, without breaking backwards compatibility.

## {{ book.must }} Treat Open API Definitions As Open For Extension By Default

The Open API 2.0 specification is not very specific on default extensibility 
of objects, and redefines JSON-Schema keywords related to extensibility, like 
`additionalProperties`. Following our overall compatibility guidelines, Open 
API object definitions are considered open for extension by default as per 
[Section 5.18 "additionalProperties"](http://json-schema.org/latest/json-schema-validation.html#rfc.section.5.18) of JSON-Schema. 

When it comes to Open API 2.0, this means an `additionalProperties` declaration 
is not required to make an object definition extensible:

- API clients consuming data must not assume that objects are closed for 
  extension in the absence of an `additionalProperties` declaration and must 
  ignore fields sent by the server they cannot process. This allows API servers 
  to evolve their data formats. 

- For API servers receiving unxpected data, the situation is slightly different. 
 Instead of ignoring fields, servers _may_ reject requests whose entities 
 contain undefined fields in order to signal to clients that those fields 
 would not be stored on behalf of the client. API designers must document 
 clearly how unexpected fields are handled for PUT, POST and PATCH requests. 

API formats must not declare `additionalProperties` to be false, as this 
prevents objects being extended in the future.

Note  that this guideline concentrates on default extensibility and does not 
exclude the use of `additionalProperties` with a schema as a value, which might 
be appropriate in some circumstances.

## {{ book.must }} Use Media Type Versioning

When API versioning is unavoidable, you have to design your multi-version
RESTful APIs using media type versioning (instead of URI versioning, see below).
Media type versioning is less tightly coupled since it supports content
negotiation and hence reduces complexity of release management.

Media type versioning: Here, version information and media type are provided
together via the HTTP Content-Type header — e.g.
application/x.zalando.cart+json;version=2. For incompatible changes, a new
media type version for the resource is created. To generate the new
representation version, consumer and producer can do content negotiation using
the HTTP Content-Type and Accept headers. Note: This versioning only applies to
the request and response content schema, not to URI or method semantics.

In this example, a client wants only the new version of the response:

    Accept: application/x.zalando.cart+json;version=2

A server responding to this, as well as a client sending a request with content should use the Content-Type header, declaring that one is sending the new version:

    Content-Type: application/x.zalando.cart+json;version=2


Using header versioning should:

* include versions in request and response headers to increase visibility
* include Content-Type in the Vary header to enable proxy caches to differ between versions

Hint: [OpenAPI currently doesn’t support content
negotiation](https://github.com/OAI/OpenAPI-Specification/issues/146), though [a comment in this
issue](https://github.com/OAI/OpenAPI-Specification/issues/146#issuecomment-117288707) mentions
a workaround (using a fragment identifier that gets stripped off).
Another way would be to document just the new version, but let the server accept the old
one (with the previous content-type).

Until an incompatible change is necessary, it is recommended to stay with the standard
`application/json` media type.

## {{ book.must }} Do Not Use URI Versioning

With URI versioning a (major) version number is included in the path, e.g.
/v1/customers. The consumer has to wait until the provider has been released
and deployed. If the consumer also supports hypermedia links — even in their
APIs — to drive workflows (HATEOAS), this quickly becomes complex. So does
coordinating version upgrades — especially with hyperlinked service
dependencies — when using URL versioning. To avoid this tighter coupling and
complexer release management we do not use URI versioning, and go instead with
media type versioning and content negotiation (see above).
