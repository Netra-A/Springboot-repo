package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Employee;

//Step 2:now create EmployeeRepository Interface for our JPA entity Class Employee.

//No need to use @Repository annotation because  it is inbuilt in JpaRepository class<Entityclassname,ID(Datatype in EntityClass)> with SIMPLE JPA REPOSITORY

//OUR EmployeeRepository will get CRUD methods for Employee JPA entity

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	// STEP 4:CREATE REST API  end points to 1st to Save data in employee table. 
	//FOR THIS FIRST CREATE CONTROLLER AND SERVICE LAYER(INTERFACES& CLASSES IN THESE LAYERS)

	
}
