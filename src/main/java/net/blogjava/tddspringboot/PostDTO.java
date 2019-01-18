package net.blogjava.tddspringboot;

public class PostDTO {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PostDTO(String content) {
		this.content = content;
	}
	
	PostDTO() {
	}
	
}
