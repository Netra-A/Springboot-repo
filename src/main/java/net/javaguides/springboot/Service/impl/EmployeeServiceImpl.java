package net.javaguides.springboot.Service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.servic.EmployeeService;

//Here we Implement the Service layer Interface 

@Service // whenever we create service class we use @Service annotation

public class EmployeeServiceImpl implements EmployeeService {

	// INJECTING REPOSITORY CONSTRUCTOR BASED DEPENDENCY

	private EmployeeRepository employeerepository;

	public EmployeeServiceImpl(EmployeeRepository employeerepository) {
		super();
		this.employeerepository = employeerepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeerepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeerepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// Optional<Employee> employee = employeerepository.findById(id);
		// if (employee.isPresent()) {
		// return employee.get();
		// } else {
		// throw new ResourceNotFoundException("Employee", "Id", id);
		// }
		
		return employeerepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingemployee = employeerepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

		existingemployee.setFirstName(employee.getFirstName());
		existingemployee.setLastName(employee.getLastName());
		existingemployee.setEmail(employee.getEmail());
		// save to DB
		return employeerepository.save(existingemployee);
	}

	@Override
	public void deleteEmployee(long id) {
		employeerepository.findById(id).
		orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeerepository.deleteById(id);

	}

}
