package com.grispi.bootcamp.restservice;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		Greeting g = new Greeting(counter.incrementAndGet(), String.format(template, name));
		return g;
	}

	@GetMapping("/")
	public String hello(@RequestParam(value = "xyz") String xyz) {
		return "Hello World xyz: " + xyz;
	}

	@PostMapping("/")
	public String post(@RequestBody String xyz) {
		return "Hello World: " + xyz;
	}
}