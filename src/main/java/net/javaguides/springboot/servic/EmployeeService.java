package net.javaguides.springboot.servic;

import java.util.List;

import net.javaguides.springboot.model.Employee;

//FROM Step 4: Creating Interface of  Service Layer then Creating Class of Service layer where Implement Interface Service layer

public interface EmployeeService {

	// Employee method is created with Employee class as return type

	public Employee saveEmployee(Employee employee);

	// Method to find all employee
	public List<Employee> getAllEmployee();

	// Method to find employee by id
	public Employee getEmployeeById(long id);
	
	//Method to update employee
	public Employee updateEmployee(Employee employee,long id);
	
	//Method to delete employee
	public void deleteEmployee(long id);
	

}
