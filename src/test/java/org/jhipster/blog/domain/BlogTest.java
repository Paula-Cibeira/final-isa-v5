package org.jhipster.blog.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jhipster.blog.domain.BlogTestSamples.*;

import org.jhipster.blog.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BlogTest {

    // para correr estos test: ./mvnw -Dtest=BlogTest test
    @Test
    void testBlogCreation() {
        // Creo un Blog con valores válidos
        Blog blog = new Blog();
        blog.setName("Test Blog");
        blog.setHandle("testhandle");

        // Verifico que los valores son correctos
        assertThat(blog.getName()).isEqualTo("Test Blog");
        assertThat(blog.getHandle()).isEqualTo("testhandle");
    }

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Blog.class);
        Blog blog1 = getBlogSample1();
        Blog blog2 = new Blog();
        assertThat(blog1).isNotEqualTo(blog2);

        blog2.setId(blog1.getId());
        assertThat(blog1).isEqualTo(blog2);

        blog2 = getBlogSample2();
        assertThat(blog1).isNotEqualTo(blog2);
    }
}
