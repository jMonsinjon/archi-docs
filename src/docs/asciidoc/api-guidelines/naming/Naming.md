# API Naming

## {{ book.must }} Use lowercase separate words with hyphens for Path Segments

Example:

    /shipment-orders/{shipment-order-id}

This applies to concrete path segments and not the names of path parameters. For example `{shipment_order_id}` would be ok as a path parameter.

## {{ book.must }} Use snake_case (never camelCase) for Query Parameters

Examples:

    customer_number, order_id, billing_address

## {{ book.must }} Use Hyphenated HTTP Headers

## {{ book.must }} Pluralize Resource Names

Usually, a collection of resource instances is provided (at least API should be ready here). The special case of a resource singleton is a collection with cardinality 1.

## {{ book.could }} Use /api as first Path Segment

In most cases, all resources provided by a service are part of the public API, and therefore should
be made available under the root “/” base path. If  the service should also support non-public,
internal APIs — for specific operational support functions, for example — add “/api” as base path to
clearly separate public and non-public API resources.

## {{ book.must }} Avoid Trailing Slashes

The trailing slash must not have specific semantics. Resource paths must deliver the same results
whether they have the trailing slash or not.
