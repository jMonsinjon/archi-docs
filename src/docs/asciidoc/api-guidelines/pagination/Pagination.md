# Pagination

## {{ book.must }} Support Pagination

Access to lists of data items must support pagination for best client side batch processing and iteration experience. This holds true for all lists that are (potentially) larger than just a
few hundred entries.

There are two page iteration techniques:

* [Offset/Limit-based pagination](http://developer.infoconnect.com/paging-results-limit-and-offset):
  numeric offset identifies the first page entry
* [Cursor-based](https://dev.twitter.com/overview/api/cursoring) — aka key-based — pagination: a
  unique key element identifies the first page entry (see also
  [Facebook’s guide](https://developers.facebook.com/docs/graph-api/using-graph-api/v2.4#paging))

The technical conception of pagination should also consider user experience related issues. As mentioned
in this [article](https://www.smashingmagazine.com/2016/03/pagination-infinite-scrolling-load-more-buttons/),
jumping to a specific page is far less used than navigation via next/previous page links. This favours
cursor-based over offset-based pagination.
