# Data Formats

## {{ book.must }} Use JSON as the Body Payload

JSON-encode the body payload. The JSON payload must follow [RFC-7159](https://tools.ietf.org/html/rfc7159) by having
(if possible) a serialized object as the top-level structure, since it would allow for future extension.
This also applies for collection resources where one naturally would assume an array. See the
[pagination](../pagination/Pagination.md#could-use-pagination-links-where-applicable) section for an example.

## {{ book.must }} Use Standard Date and Time Formats

###JSON Payload
Read more about date and time format in [Json Guideline](../json-guidelines/JsonGuidelines.md#date-property-values-should-conform-to-rfc-3399).

###HTTP headers
Http headers including the proprietary headers. Use the [HTTP date format defined in RFC 7231](http://tools.ietf.org/html/rfc7231#section-7.1.1.1).
