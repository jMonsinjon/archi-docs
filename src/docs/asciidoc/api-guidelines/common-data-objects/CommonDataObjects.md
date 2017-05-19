# Common Data Objects

Definitions of data objects that are good candidates for wider usage:

## {{ book.must }} Use Problem JSON

[RFC 7807](http://tools.ietf.org/html/rfc7807) defines the media type `application/problem+json`.
Operations should return that (together with a suitable status code) when any problem
occurred during processing and you can give more details than the status code itself
can supply, whether it be caused by the client or the server (i.e. both for 4xx or 5xx errors).

A previous version of this guideline (before the publication of that RFC and the
registration of the media type) told to return `application/x.problem+json` in these
cases (with the same contents).
Servers for APIs defined before this change should pay attention to the `Accept` header sent
by the client and set the `Content-Type` header of the problem response correspondingly.
Clients of such APIs should accept both media types.

APIs may define custom problems types with extension properties, according to their specific needs.

The Open API schema definition can be found [on github](https://zalando.github.io/problem/schema.yaml).
You can reference it by using:

```yaml
responses:
  503:
    description: Service Unavailable
    schema:
      $ref: 'https://zalando.github.io/problem/schema.yaml#/Problem'
        
```

## {{ book.must }} Do not expose Stack Traces

Stack traces contain implementation details that are not part of an API, and on which clients
should never rely. Moreover, stack traces can leak sensitive information that partners and third
parties are not allowed to receive and may disclose insights about vulnerabilities to attackers.

### {{ book.must }} Use common field names

There are some data fields that come up again and again in API data. We describe four here:

- `id`: the identity of the object. If used, IDs must opaque strings and not numbers. IDs are unique within some documented context, are stable and don't change for a given object once assigned, and are never recycled cross entities. 

- `created`: when the object was created. If used this must be a date-time construct.

- `modified`: when the object was updated. If used this must be a date-time construct.

- `type`: the kind of thing this object is. If used the type of this field should be a string. Types allow runtime information on the entity provided that otherwise requires examining the Open API file. 

These properties are not always strictly neccessary, but making them idiomatic allows API client developers to build up a common understanding of Zalando's resources. There is very little utility for API consumers in having different names or value types for these fields across APIs. 