package com.springboot.restadvice;

import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class RestAdvice implements ResponseBodyAdvice<Map<String, String>> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

		String className = returnType.getContainingClass().toString();

		String methodName = returnType.getMethod().toString();

		if (className.contains("RestController") && methodName.contains("modifyRestResponse")) {

			return true;
		}

		return false;
	}

	@Override
	public Map<String, String> beforeBodyWrite(Map<String, String> body, MethodParameter returnType,
			MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {

		body.put("message", "Hi! This is Response Body Advice modifying the response");

		return body;
	}

}
