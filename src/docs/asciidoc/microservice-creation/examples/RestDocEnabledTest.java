package com.cdiscount.search.searcher.back;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Rule;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.cdiscount.archi.utils.tests.SwaggerDocumentationUtils;

/**
 * Abstract class that provides some basic methods such as documentation initialization
 * and a mockMvc object to perform HTTP mocks
 */
public abstract class RestDocEnabledTest extends AbstractTest {

    @Inject
    protected WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation(
            SwaggerDocumentationUtils.APIDOC_SNIPPETS_OUTPUT_FOLDER);

    @Before
    public void initMockMVC() {
        this.mockMvc = SwaggerDocumentationUtils.initMockMVC(webApplicationContext, restDocumentation);
    }
}
