package net.blogjava.tddspringboot;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public String getCurrentUsername() {
		return "Micky";
	}

}
