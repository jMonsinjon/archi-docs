#Deprecation

Sometimes it is necessary to phase out an API endpoint (or version). I.e. this
may be necessary if a field is no longer supported in the result or a whole
business functionality behind an endpoint has to be shut down. There are
many other reasons as well.


## {{ book.must }} Obtain Approval of Clients

Before shutting down an API (or version of an API) the producer must make
sure, that all clients have given their consent to shut down the
endpoint. Producers should help consumers to migrate to a potential new
endpoint (i.e. by providing a migration manual). After all clients are
migrated, the producer may shut down the deprecated API.

## {{ book.must }} External Partners Must Agree on Deprecation Timespan

If the API is consumed by any external partner, the producer must define a
reasonable timespan that the API will be maintained after the producer has
announced deprecation. The external partner (client) must agree to this
minimum after-deprecation-lifespan before he starts using the API. 

## {{ book.must }} Reflect Deprecation in API Definition

API deprecation must be part of the OpenAPI definition. If a method
on a path, a whole path or even a whole API endpoint (multiple paths) should
be deprecated, the producers must set `deprecated=true` on each method / path
element that will be deprecated (OpenAPI 2.0 only allows you to define
deprecation on this level). If deprecation should happen on a more fine grained 
level (i.e. query parameter, payload etc.), the producer should set
`deprecated=true` on the affected method / path element and add further
explanation to the `description` section. 

If `deprecated` is set to `true`, the producer must describe what clients
should use instead and when the API will be shut down in the `description`
section of the API definition. 

## {{ book.must }} Monitor Usage of Deprecated APIs

Owners of APIs used in production must monitor usage of deprecated APIs until the API can be shut down in order to align deprecation and avoid uncontrolled breaking effects. See also the [general rule on API usage monitoring](../api-operation/ApiOperation.md)

## {{ book.must }} Not Start Using Deprecated APIs

Clients must not start using deprecated parts of an API.
