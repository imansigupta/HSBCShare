package com.multi.main;

import com.multi.domain.Employee;
import com.multi.exceptions.EmployeeNotFoundException;
import com.multi.service.EmployeeService;

public class EmployeeMain {

	public static void main(String[] args) {

		EmployeeService service = new EmployeeService();

		Employee all[] = service.getAllEmployees();

		for (Employee x : all) {
			System.out.println(x);
		}
		System.out.println("========This is Delete ===================================");
		try {
			service.delete(200);
			System.out.println("Employee with id 200 deleted");
		} catch (EmployeeNotFoundException e) {
			e.showMessage();
		}

		System.out.println("===============This is one employee ============================");

		Employee e1 = service.getOneEmployee(300);

		if (e1 == null)
			System.out.println("Employee not found");
		else
			System.out.println(e1);

		e1 = service.getOneEmployee(400);
		if (e1 != null) {
			e1.setSalary(20000);
			try {
				service.update(e1);
			} catch (EmployeeNotFoundException e) {
				e.showMessage();
			}
		}

		System.out.println("=========checking after update==================================");

		all = service.getAllEmployees();

		for (Employee x : all) {
			System.out.println(x);
		}

	}

}
