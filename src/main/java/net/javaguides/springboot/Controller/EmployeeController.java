package net.javaguides.springboot.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.servic.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	// INJECT DEPENDENCY OF SERVICE CLASS (CONSTRUCTOR BASED DEPENDENCY)
	private EmployeeService employeeservice;

	public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}

	// build REST API to create Employee by using method saveEmployee
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeservice.saveEmployee(employee), HttpStatus.CREATED);
	}

	// build REST API to find all employee
	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeservice.getAllEmployee();
	}

	// build rest Api to find employee by id
	// http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		return new ResponseEntity<Employee>(employeeservice.getEmployeeById(id), HttpStatus.OK);
	}

	
	//build rest Api for update
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")long id,
			@RequestBody Employee employee)  {
	return new ResponseEntity<Employee>(employeeservice.updateEmployee(employee,id),HttpStatus.OK);
	}
	
	//build rest api api to delete
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("{id}")long id){
		//Delete employee
		employeeservice.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee Deleted successfully", HttpStatus.OK);
	}
}
