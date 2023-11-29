package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.DepartmentDao;
import com.app.dao.DepartmentDaoImpl;
import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Department;
import com.app.pojos.Employee;
import com.app.pojos.EmploymentType;

public class AddNewDeptWithEmps {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			DepartmentDao dao = new DepartmentDaoImpl();
			System.out.println("Enter new dept details : name n location");
			Department dept=new Department(sc.next(), sc.next());
			for(int i=0;i<3;i++)
			{
				System.out.println(
						"Enter emp details : firstName,  lastName,  email,  password,  joinDate,	 empType,  salary");
				// create transient entity /pojo
				Employee emp = new Employee(sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()),
						EmploymentType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
				//establish a bi dir asso between Dept n Emps
				dept.addEmployee(emp);
			}
		System.out.println(dao.addNewDepartment(dept));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
