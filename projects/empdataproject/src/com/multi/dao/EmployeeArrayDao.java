package com.multi.dao;

import com.multi.domain.Employee;
import com.multi.exceptions.EmployeeNotFoundException;


/* 
 * DAO implemented using normal array.
 * create method not implemented because we cannot add new element in array
 * deletion implemented by setting the element to null
 */
public class EmployeeArrayDao implements EmployeeDao {

	Employee[] employees = { 
			new Employee(100, "Suresh", 26000), 
			new Employee(200, "Aloknath", 18000),
			new Employee(300, "Banerjee", 12000), 
			new Employee(400,"John",9000), 
			new Employee(500, "Deepa", 6000)
		};

	@Override
	public void create(Employee e) {
		System.out.println("Create method not implemented");
	}

	@Override
	public Employee getEmployee(int id) {
 
		for (Employee x : employees) {
			if (x != null && x.getEmpId() == id)  // we have to check for deleted employees  with null value
				return x;
		}

		return null;
	}

	@Override
	public Employee[] getAllEmployees() {
// this is new array to be returned
// we should not return data array reference to outside
		Employee[] x = new Employee[employees.length];

		for (int i = 0; i < employees.length; i++) {
			if (employees[i] == null)
				x[i] = null;
			else
				x[i] = new Employee(employees[i].getEmpId(), employees[i].getName(), employees[i].getSalary());
		}

		return x;
	}

	@Override
	public void update(Employee e) throws EmployeeNotFoundException {
		Employee e1 = null;
		for (Employee x : employees) {

			if (x != null && x.getEmpId() == e.getEmpId()) {
				e1 = x;
			}
		}

		if (e1 == null)
			throw new EmployeeNotFoundException(e.getEmpId());

		e1.setName(e.getName());
		e1.setSalary(e.getSalary());

	}

	@Override
	public void delete(int id) throws EmployeeNotFoundException {

		int position = -1;

		for (int i = 0; i < employees.length; i++) {

			if (employees[i] != null && employees[i].getEmpId() == id) {
				position = i;
				break;
			}

		}
  // position remains -1 if employee not found
		if (position == -1)
			throw new EmployeeNotFoundException(id);
		employees[position] = null;
	}

}
