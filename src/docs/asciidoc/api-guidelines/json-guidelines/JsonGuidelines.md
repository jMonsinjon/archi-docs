# JSON Guidelines

These guidelines provides recommendations for defining JSON data at Zalando. JSON here refers to [RFC 7159](http://www.rfc-editor.org/rfc/rfc7159.txt) (which updates [RFC 4627](https://www.ietf.org/rfc/rfc4627.txt)), the “application/json” media type and custom JSON media types defined for APIs. The guidelines clarifies some specific cases to allow Zalando JSON data to have an idiomatic form across teams and services.

## {{ book.must }} Use Consistent Property Names

### {{ book.must }} Property names must be snake_case (and never camelCase).

No established industry standard exists, but many popular Internet companies prefer snake_case: e.g. GitHub, Stack Exchange, Twitter. Others, like Google and Amazon, use both - but not only camelCase. It’s essential to establish a consistent look and feel such that JSON looks as if it came from the same hand.

### {{ book.must }} Property names must be an ASCII subset

Property names are restricted to ASCII encoded strings. The first character must be a letter, an underscore  or a dollar sign, and subsequent characters can be a letter, an underscore, a dollar sign, or a number.

### {{ book.should }} Array names should be pluralized

To indicate they contain multiple values prefer to pluralize array names. This implies that object names should in turn be singular.

## {{ book.must }} Use Consistent Property Values

### {{ book.must }} Boolean property values must not be null

Schema based JSON properties that are by design booleans must not be presented as nulls. A boolean is essentially a closed enumeration of two values, true and false. If the content has a meaningful null value, strongly prefer to replace the boolean with enumeration of named values or statuses - for example accepted_terms_and_conditions with true or false can be replaced with terms_and_conditions with values yes, no and unknown.
