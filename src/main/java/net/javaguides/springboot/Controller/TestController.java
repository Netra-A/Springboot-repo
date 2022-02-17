package net.javaguides.springboot.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.TestObj;

@RestController
public class TestController {

@PostMapping("/test")
public void test(@RequestBody TestObj emp) {
	System.out.println("test");
}


}
