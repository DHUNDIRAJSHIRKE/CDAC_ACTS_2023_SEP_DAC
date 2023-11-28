package dao;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Employee;
import pojos.Project;

public class ProjectDaoImpl implements ProjectDao {

	@Override
	public String addNewProject(String title, String begin, String end) {
		String msg = "Adding new Project Failed!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			LocalDate beginDate = LocalDate.parse(begin);
			LocalDate endDate = LocalDate.parse(end);
			Project project = new Project(title, beginDate, endDate);
			session.persist(project);
			tx.commit();
			msg = "Added new Project with ID " + project.getId();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

		return msg;
	}

	@Override
	public String addEmpToProject(Employee emp, long projectId) {
		String msg = "Adding Existing Employee to the Project " + projectId + " Failed!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Project project = session.get(Project.class, projectId);
			project.addEmployee(emp);
			Set<Project> projects = emp.getProjects();
			projects.add(project);
			tx.commit();
			msg ="project and employee linked!!";
		}catch(Exception e){
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		

		return msg;
	}

}
