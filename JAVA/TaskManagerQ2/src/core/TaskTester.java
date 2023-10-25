package core;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import custom_Ordering.TaskComparator;

import static taskUtils.TaskUtils.*;;

public class TaskTester {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		boolean exit = false;
		List<Task> taskList = new ArrayList<>(populateList());
		try (Scanner sc = new Scanner(System.in);
				
				// FileOutputStream wo = new FileOutputStream("Assignment1.txt");//here we want the objects directly 
		       // ObjectOutputStream s = new ObjectOutputStream(wo);
				
				ObjectOutputStream DOS = new ObjectOutputStream( new FileOutputStream("C:/Users/dac.STUDENTSDC/Desktop/abcfd.txt"));
				FileWriter fw = new FileWriter("C:/Users/dac.STUDENTSDC/Desktop/abcfd2.txt");//while here we want the object with its attributes
		       // PrintWriter pw = new PrintWriter(fw);
				PrintWriter w = new PrintWriter(new FileWriter("C:/Users/dac.STUDENTSDC/Desktop/abcfd3.txt"));

				//ObjectOutputStream s = new ObjectOutputStream(DOS);
				) {
			
			while (!exit) {
				System.out.print(
						"\n1.Add Task 2.Delete task 3.Update Task 4.Display All 5.Display All pending 6.Display All pending for Today 7.sort by date 0.Exit: ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.print("Enter Name, Desc, Date(yyyy-MM-dd: ");
						Task newTask = validateAllInputs(sc.next(), sc.next(), sc.next());
						taskList.add(newTask.getTaskId()-101, newTask);
						System.out.println("Task Added successfully!!");
						break;
					case 2:
						System.out.print("Enter TaskID : ");
						Task t_delete = searchById(sc.nextInt(), taskList);
						System.out.println("Following task has been deleted : \n" + t_delete.getTaskName());
						
						break;
					case 3:
						System.out.print("Enter TaskID : ");
						Task t_update = searchById(sc.nextInt(), taskList);
						System.out.println("1. IN_PROGRESS 2.COMPLETED: ");
						int st = sc.nextInt();
						if(st==1) {
							t_update.setStatus(Status.valueOf("IN_PROGRESS"));
						}
						if(st==2) {
							t_update.setStatus(Status.valueOf("COMPLETED"));
						}
						else {
							System.out.println("invalid Choice!!");
						}
						break;
					case 4:
						for(Task t : taskList) {
							System.out.println(t);
						}
						System.out.println();
						break;
					case 5:
						for(Task t : taskList) {
							if(t.getStatus() == Status.valueOf("PENDING") && t.isActive()){
								System.out.println(t);								
							}
						}
						System.out.println();
						break;
					case 6:
						for(Task t : taskList) {
							if(t.getStatus() == Status.valueOf("PENDING") && t.isActive() && t.getTaskDate().equals(LocalDate.now())){
								System.out.println(t);								
							}
						}
						System.out.println();
						break;
					case 7:
						Collections.sort(taskList,new TaskComparator());
						for(Task t : taskList) {
							if(t.getStatus() == Status.valueOf("PENDING") && t.isActive()){
								System.out.println(t);								
							}
						}
						System.out.println();
						break;
					case 8:
						taskList.stream().forEach(t -> {
						//	try {
							//	DOS.writeObject(t);								//DOS.writeObject(t);
								//pw.print(t);
								w.println(t);
							
						});
						break;
					case 9:
						PrintWriter printwriter = new PrintWriter(new FileWriter("C:/Users/dac.STUDENTSDC/Desktop/abcfd4.txt"));
						taskList.stream().forEach(i -> printwriter.println(i));
						System.out.println("Copied data!");
						printwriter.close();
						break;
					case 0:
						exit = true;
						break;
					default:
						System.out.println("Invalid Input!!");
						break;
					}
				}
				catch(DateTimeParseException DTPE) {
					System.out.println("Wrong Date Format!!");
				}
				catch (NullPointerException NPE) {

				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}
		}
	}

}
