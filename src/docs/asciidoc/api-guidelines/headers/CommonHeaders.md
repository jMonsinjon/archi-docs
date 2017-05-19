# Common Headers

This section describes a handful of headers, which we found raised the most questions in our daily usage, or which are useful in particular circumstances but not widely known.

## {{ book.must }} Use Content Headers Correctly

Content or entity headers are headers with a `Content-` prefix. They describe the content of the body of the message and
they can be used in both, HTTP requests and responses. Commonly used content headers include but are not limited to:

 - [`Content-Disposition`](https://tools.ietf.org/html/rfc6266) can indicate that the representation is supposed to be saved as a file, and the proposed file name.
 - [`Content-Encoding`](https://tools.ietf.org/html/rfc7231#section-3.1.2.2) indicates compression or encryption algorithms applied to the content.
 - [`Content-Length`](https://tools.ietf.org/html/rfc7230#section-3.3.2) indicates the length of the content (in bytes).
 - [`Content-Language`](https://tools.ietf.org/html/rfc7231#section-3.1.3.2) indicates that the body is meant for people literate in some human language(s).
 - [`Content-Location`](https://tools.ietf.org/html/rfc7231#section-3.1.4.2) indicates where the body can be found otherwise ([see below for more details](../headers/CommonHeaders.md#could-use-contentlocation-header)).
 - [`Content-Range`](https://tools.ietf.org/html/rfc7233#section-4.2) is used in responses to range requests to indicate which part of the requested resource representation is delivered with the body.
 - [`Content-Type`](https://tools.ietf.org/html/rfc7231#section-3.1.1.5) indicates the media type of the body content.
