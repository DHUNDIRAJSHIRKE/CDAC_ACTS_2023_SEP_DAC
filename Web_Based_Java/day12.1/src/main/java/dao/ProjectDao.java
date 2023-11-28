package dao;
import pojos.Employee;
import pojos.Project;
public interface ProjectDao {
	String addNewProject(String title, String begin , String end);
	String addEmpToProject(Employee emp, long projectId);
	
}
