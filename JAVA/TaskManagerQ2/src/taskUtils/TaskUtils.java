package taskUtils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import core.Task;

public class TaskUtils {
	public static ArrayList<Task> populateList() {
		ArrayList<Task> list = new ArrayList<>();
		list.add(0,new Task("Buy Groceries","Go to D-Mart and Buy the groceries",LocalDate.parse("2023-10-15")));
		list.add(1,new Task("Finish Assignment","using java docs finish the assignment",LocalDate.parse("2023-10-19")));
		return list;
	}
	public static Task validateAllInputs(String name,String desc ,String uncheckedDate) throws DateTimeParseException {
		LocalDate checkedDate = LocalDate.parse(uncheckedDate);
		Task newTask = new Task(name , desc, checkedDate);
		return newTask;
	}
	public static Task searchById(int id, List<Task> list) {
		boolean found =false;
		for(Task t : list) {
			if(t.getTaskId() == id) {
				System.out.println("task found!!");
				t.setActive(false);
				found = true;
				return t;
			}
		}
		if(!found) {
			System.out.println("Task not found!!");
		}
		return null;
	}
}
