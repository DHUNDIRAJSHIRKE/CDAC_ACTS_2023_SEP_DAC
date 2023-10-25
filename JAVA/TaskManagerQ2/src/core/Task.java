package core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public class Task implements Serializable {
	private static int IDCounter=100;
	private int taskId; 
	private String taskName;
	private String desc;
	private LocalDate taskDate;
	private Status status;
	private boolean active;
	
	public Task(String taskName, String desc, LocalDate taskDate) {
		super();
		taskId = ++IDCounter;
		this.taskName = taskName;
		this.desc = desc;
		this.taskDate = taskDate;
		status = Status.valueOf("PENDING");
		//setStatus(PENDING);
		active = true;
		
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", desc=" + desc + ", taskDate=" + taskDate
				+ ", status=" + status + ", active=" + active + "]";
	}

	
	
	
	
	
}
