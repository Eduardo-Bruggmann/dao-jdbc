package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: department findById =====");
		Department department = departmentDao.findById(3);
		System.out.println(department);

		System.out.println("\n=== TEST 2: department findAll =====");
		List<Department> allDepartments = departmentDao.findAll();
		for (Department d: allDepartments) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: department insert =====");
		Department newDepartment = new Department(22, "Marketing");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n=== TEST 4: department update =====");
		department = departmentDao.findById(1);
		department.setName("Sales");
		departmentDao.update(department);
		System.out.println("Update completed!");

		System.out.println("\n=== TEST 5: department delete =====");
		departmentDao.deleteById(5);
		System.out.println("Deleted completed!");
	}
}
