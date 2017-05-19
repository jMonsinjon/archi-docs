package com.cdiscount.search.searcher.back.documentation;

import org.junit.Test;

import com.cdiscount.archi.utils.tests.SwaggerDocumentationUtils;

/**
 * A test class that generates REST API documentation, including : - Swagger
 * basic documentation - Spring restdoc documentation (REST API snippets,
 * examples)
 */
public class DocumentationIT extends RestDocEnabledTest {

    @Test
    public void convertSwaggerToAsciiDoc() throws Exception {
        SwaggerDocumentationUtils.convertSwaggerToAsciiDoc(this.mockMvc);
    }
}
