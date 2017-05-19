package com.cdiscount.search.searcher.back.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/productFinder")
@Api(tags = "Product Finder", hidden = true)
public class ProductFinderController {

    private ProductFinderService productFinderService;

    public ProductFinderController(ProductFinderService productFinderService) {
        this.productFinderService = productFinderService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search by sku")
    public SolrSearchProductResponse productFinderSearchBySku(@RequestParam String productId) {
        return productFinderService.findProducts(productId);
    }
}
