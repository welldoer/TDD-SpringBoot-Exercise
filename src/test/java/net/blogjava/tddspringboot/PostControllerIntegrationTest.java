package net.blogjava.tddspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testSentValidPostRequest() throws Exception {
		ResultActions resultActions = mockMvc.perform(
				post("/v2/posts")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new PostDTO("post content test")))
				);
		resultActions.andDo(print())
				.andExpect(status().isCreated());
		String response = resultActions
				.andReturn()
				.getResponse()
				.getContentAsString();
		Post result = objectMapper.readValue(response, Post.class);
		
		assertThat(result.getId()).isEqualTo(1);
		assertThat(result.getContent()).isEqualTo("post content test");
		assertThat(result.getUsername()).isEqualTo("Micky");
		assertThat(result.getCreateDate()).isCloseTo(new Date(), 300);
		
	}

	@Test
	public void testSentValidPostRequestAndQuery() throws Exception {
		ResultActions resultActions0 = mockMvc.perform(
				post("/v2/posts")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new PostDTO("post content abc")))
				);
		resultActions0.andDo(print())
				.andExpect(status().isCreated());

		ResultActions resultActions = mockMvc.perform(
				get("/v2/posts/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(1))
				);
		resultActions.andDo(print())
				.andExpect(status().isOk());
	}
}
