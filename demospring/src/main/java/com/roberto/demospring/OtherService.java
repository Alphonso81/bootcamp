package com.roberto.demospring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherService {

	@GetMapping("/hola/{userName}")
	public String hola(@PathVariable(value="userName")String userName) {
		return "hola "+userName;
	}
}//endclass
