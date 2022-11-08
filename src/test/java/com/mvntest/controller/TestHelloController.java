package com.mvntest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class TestHelloController {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testController() throws Exception {
		var uri = new URI("http://localhost:" + randomServerPort + "/home");
		RestTemplate restTemplate = new RestTemplate();
		var result = restTemplate.getForObject(uri, String.class);
		assertEquals(result, HttpStatus.OK.name());
	}
}
