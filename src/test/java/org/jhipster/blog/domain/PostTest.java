package org.jhipster.blog.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jhipster.blog.domain.BlogTestSamples.*;
import static org.jhipster.blog.domain.PostTestSamples.*;
import static org.jhipster.blog.domain.TagTestSamples.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import org.jhipster.blog.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PostTest {

    // para correr estos test: ./mvnw -Dtest=PostTest test
    @Test
    void testPostCreation() {
        // Creo un Post con valores válidos
        Post post = new Post();
        post.setTitle("Test Post");
        post.setContent("Soy el contenido del test");
        post.setDate(Instant.now());

        // Verifico que los valores son correctos
        assertThat(post.getTitle()).isEqualTo("Test Post");
        assertThat(post.getContent()).isEqualTo("Soy el contenido del test");
        assertThat(post.getDate()).isNotNull();
    }

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Post.class);
        Post post1 = getPostSample1();
        Post post2 = new Post();
        assertThat(post1).isNotEqualTo(post2);

        post2.setId(post1.getId());
        assertThat(post1).isEqualTo(post2);

        post2 = getPostSample2();
        assertThat(post1).isNotEqualTo(post2);
    }

    @Test
    void blogTest() {
        Post post = getPostRandomSampleGenerator();
        Blog blogBack = getBlogRandomSampleGenerator();

        post.setBlog(blogBack);
        assertThat(post.getBlog()).isEqualTo(blogBack);

        post.blog(null);
        assertThat(post.getBlog()).isNull();
    }

    @Test
    void tagTest() {
        Post post = getPostRandomSampleGenerator();
        Tag tagBack = getTagRandomSampleGenerator();

        post.addTag(tagBack);
        assertThat(post.getTags()).containsOnly(tagBack);

        post.removeTag(tagBack);
        assertThat(post.getTags()).doesNotContain(tagBack);

        post.tags(new HashSet<>(Set.of(tagBack)));
        assertThat(post.getTags()).containsOnly(tagBack);

        post.setTags(new HashSet<>());
        assertThat(post.getTags()).doesNotContain(tagBack);
    }
}
