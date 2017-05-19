# Resources

## {{ book.must }} Avoid Actions — Think About Resources

REST is all about your resources, so consider the domain entities that take part in web service interaction, and aim to model your API around these using the standard HTTP methods as operation indicators. For instance, if an application has to lock articles explicitly so that only one user may edit them, create an article lock with PUT or POST instead of using a lock action.

Request:

    PUT /article-locks/{article-id}

The added benefit is that you already have a service for browsing and filtering article locks.

## {{ book.must }} Keep URLs Verb-Free

The API describes resources, so the only place where actions should appear is in the HTTP methods.
In URLs, use only nouns. Instead of thinking of actions (verbs), it's often helpful to think about putting a message in a letter box: e.g., instead of having the verb *cancel* in the url, think of sending a message to cancel an order to the *cancellations* letter box on the server side.

## {{ book.must }} Use Domain-Specific Resource Names

API resources represent elements of the application’s domain model. Using domain-specific nomenclature for resource names helps developers to understand the functionality and basic semantics of your resources. It also reduces the need for further documentation outside the API definition. For example, “sales-order-items” is superior to “order-items” in that it clearly indicates which business object it represents. Along these lines, “items” is too general.

## {{ book.must }} Identify resources and Sub-Resources via Path Segments

Some API resources may contain or reference sub-resources. Embedded sub-resources, which are not top-level resources,
are parts of a higher-level resource and cannot be used outside of its scope. Sub-resources should be referenced
by their name and identifier in the path segments.

Composite identifiers must not contain “/” as a separator. In order to improve the consumer experience, you should
aim for intuitively understandable URLs, where each sub-path is a valid reference to a resource or a set of resources.
For example, if “/customers/12ev123bv12v/addresses/DE\_100100101” is a valid path of your API, then
“/customers/12ev123bv12v/addresses”, “/customers/12ev123bv12v” and “/customers” must be valid as well in principle.

Basic URL structure:

    /{resources}/[resource-id]/{sub-resources}/[sub-resource-id]
    /{resources}/[partial-id-1][separator][partial-id-2]

Examples:

    /carts/1681e6b88ec1/items
    /carts/1681e6b88ec1/items/1
    /customers/12ev123bv12v/addresses/DE_100100101
