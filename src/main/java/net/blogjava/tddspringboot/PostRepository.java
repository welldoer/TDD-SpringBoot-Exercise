package net.blogjava.tddspringboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	Post findByContent(String content);

}
