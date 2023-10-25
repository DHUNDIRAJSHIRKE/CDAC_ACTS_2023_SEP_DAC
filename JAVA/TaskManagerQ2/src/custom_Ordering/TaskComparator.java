package custom_Ordering;

import java.util.Comparator;

import core.Task;

public class TaskComparator implements Comparator<Task> {
	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		if (o1.getTaskDate().isBefore(o2.getTaskDate())) {
			return -1;
		}
		if (o1.getTaskDate().isAfter(o2.getTaskDate())) {
			return 1;
		}
		return 0;
	}
}
