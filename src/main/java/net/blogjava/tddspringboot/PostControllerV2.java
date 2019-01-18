package net.blogjava.tddspringboot;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostControllerV2 {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserService userService;

	@PostMapping("/v2/posts")
	public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO) {
		Post post = new Post(postDTO.getContent(), userService.getCurrentUsername());
		post.setCreateDate(new Date());
		post = postRepository.save(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(post);
	}
}
