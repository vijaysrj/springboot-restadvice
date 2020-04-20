package com.springboot.restadvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@PostMapping("/modifyRESTResponse")
	public Map<String, String> modifyRestResponse(@RequestBody Map<String,String> message) {

		Map<String, String> result = new HashMap<>();
		result.put("name", "Mr Spring Boot Advice");
		result.putAll(message);

		return result;

	}

}
