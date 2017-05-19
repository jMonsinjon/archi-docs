package com.cdiscount.search.searcher.back.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.cdiscount.search.searcher.back.RestDocEnabledTest;
import org.junit.Test;


public class ProductFinderControllerIT extends RestDocEnabledTest {

    /**
     * productFinderSearchBySku snippet
     */
    @Test
    public void searchBySku() throws Exception {
        this.mockMvc.perform(get("/productFinder/search")
                .param("productId", "abolive1an"));
    }
}