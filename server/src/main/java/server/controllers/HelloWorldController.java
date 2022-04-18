package server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "TEST: HelloWorld" })
public class HelloWorldController {

	@GetMapping("/hello")
	@ApiOperation(value = "Vraća tekst Hello World.")
	public String helloWorld() {
		return "Hello World";
	}
}
