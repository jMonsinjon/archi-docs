# Hypermedia

## {{ book.must }} Use REST Maturity Level 2

We strive for a good implementation of [REST Maturity Level 2](http://martinfowler.com/articles/richardsonMaturityModel.html#level2) as it enables
us to build resource-oriented APIs that make full use of HTTP verbs and status codes.
You can see this expressed by many rules throughout these guidelines, e.g.:
- [Avoid Actions — Think About Resources](../resources/Resources.md#must-avoid-actions-—-think-about-resources)
- [Keep URLs Verb-Free](../resources/Resources.md#must-keep-urls-verbfree)
- [Use HTTP Methods Correctly](../http/Http.md#must-use-http-methods-correctly)
- [Use Meaningful HTTP Status Codes](../http/Http.md#must-use-meaningful-http-status-codes)

Although this is not HATEOAS, it should not prevent you from designing proper link relationships in your APIs as stated in rules below.

## {{ book.must }} Use a well-defined subset of HAL

Links to other resources must be defined exclusively using [HAL](http://stateless.co/hal_specification.html) and
preferably using standard [link relations](http://www.iana.org/assignments/link-relations/link-relations.xml).

Clients and Servers are required to support `_links` with its `href` and `rel` attributes, not only at the root level
but also in nested objects. To reduce the effort needed by clients to process hypertext data from servers it's not recommended to serve data with CURIEs, URI templates or embedded resources. Nor is it required to support the HAL media type `application/hal+json`. The following snippet specifies the HAL link structure in JSONSchema:

```yaml
Link:
  type: object
  properties:
    href:
      type: string
      format: uri
      example: https://api.example.com/sales-orders/10101058747628
  required:
    - href
Links:
  type: object
  description: |
    Values can be either a single Link or an array of Links
    See https://docs.pennybags.zalan.do/ for more.
  additionalProperties:
    # keys are link relations
    type: array
    items:
      $ref: '#/definitions/Link'
  example:
    'self':
      - href: https://api.example.com/sales-orders/10101058747628
```

We opted for this subset of HAL after conducting a comparison of different hypermedia formats based on properties like:

* Simplicity: resource link syntax and concepts are easy to understand and interpret for API clients.
* Compatibility: introducing and adding links to resources is not breaking existing API clients.
* Adoption: use in open-source libraries and tools as well as other companies
* Docs: degree of good documentation

<p></p>

| Standard                                                       | Simplicity | Compatibility | Adoption | Primary Focus           | Docs |
|----------------------------------------------------------------|------------|---------------|----------|-------------------------|------|
| HAL Subset                                                     | ✓          | ✓             | ✓        | Links and relationships | ✓    |
| [HAL](http://stateless.co/hal_specification.html)              | ✗          | ✓             | ✓        | Links and relationships | ✓    |
| [JSON API](http://jsonapi.org/)                                | ✗          | ✗             | ✓        | Response format         | ✓    |
| [JSON-LD](http://json-ld.org/)                                 | ✗          | ✓             | ?        | Link data               | ?    |
| [Siren](https://github.com/kevinswiber/siren)                  | ✗          | ✗             | ✗        | Entities and navigation | ✗    |
| [Collection+JSON](http://amundsen.com/media-types/collection/) | ✗          | ✗             | ✗        | Collections and queries | ✓    |

We define HAL links to be extensible, i.e. to contain additional properties if needed. For consistency extensions should reuse attributes from the [`Link` header](https://tools.ietf.org/html/rfc5988#section-5).

Interesting articles for comparisons of different hypermedia formats:
* [Kevin Sookocheff’s On choosing a hypermedia type for your API](http://sookocheff.com/post/api/on-choosing-a-hypermedia-format/)
* [Mike Stowe's API Best Practices: Hypermedia](http://blogs.mulesoft.com/dev/api-dev/api-best-practices-hypermedia-part-3/)

## {{ book.must }} Do Not Use Link Headers with JSON entities

We don't allow the use of the [`Link` Header defined by RFC 5988](http://tools.ietf.org/html/rfc5988#section-5)
in conjunction with JSON media types, and favor [HAL](#must-use-hal) instead. The primary reason is to have a consistent
place for links as well as the better support for links in JSON payloads compared to the uncommon link header syntax.
