package tester;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.ProjectDao;
import dao.ProjectDaoImpl;
import pojos.Employee;

import static utils.HibernateUtils.getFactory;
public class AssignExistingEmpToProject {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);SessionFactory sf = getFactory()){
			ProjectDao projectDao = new ProjectDaoImpl();
			EmployeeDao empDao = new EmployeeDaoImpl();
			
					
			System.out.println("Enter ID of Employee: ");
			Employee employee = empDao.getEmpDetailsById(sc.nextLong());
			System.out.println(employee);
			if(employee != null) {
				System.out.println("Enter Project ID : ");
				System.out.println(projectDao.addEmpToProject(employee,sc.nextLong()));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
