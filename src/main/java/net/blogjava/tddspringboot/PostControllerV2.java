package net.blogjava.tddspringboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostControllerV2 {

	@PostMapping("/v2/posts")
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postDTO);
	}
}
