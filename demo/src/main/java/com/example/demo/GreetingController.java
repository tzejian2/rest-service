package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	// create a variable to store reference to component
	// define a GreetingComponent variable without initialization
	private GreetingComponent gc;

	// define a constructor
	// inject/initialize GreetingComponent in the constructor
	@Autowired
	public GreetingController(GreetingComponent gc) {
		this.gc = gc;
	}

	// define a service's method
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	// define a method to call compenent's method
	// test the greeting component
	@GetMapping("/testgc")
	public ResponseEntity<String> getMessage() {
		return ResponseEntity.ok(gc.getMessage());
	}

}
