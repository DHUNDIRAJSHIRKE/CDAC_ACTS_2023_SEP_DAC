package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDao;
import dao.ProjectDaoImpl;

public class AddNewProject {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			ProjectDao projectDao = new ProjectDaoImpl();
			System.out.println("Hibernate up and Running!!");
			System.out.println("Enter Project Details: Title, start Date , End Date: ");
			System.out.println(projectDao.addNewProject(sc.next(),sc.next(),sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
