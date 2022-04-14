package com.springboot.blog.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.blog.entity.Post;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostRepositoryTests {

	@Autowired
	private PostRepository postRepository;

	@Test
	public void givenPostObject_whenSave_thenReturnSavedPost() {

		Post post = new Post("Title", "Description", "Content");
		Post savedPost = postRepository.save(post);

		assertThat(savedPost).isNotNull();
		assertThat(savedPost.getId()).isGreaterThan(0);

	}

}
