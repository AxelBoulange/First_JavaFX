package model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TaskList<Task> extends ArrayList<Task> {

	public void deleteById(int id) {
		for (Task t : this) {
			if (((model.Task) t).getId() == id) {
				this.remove(t);
				return;
			}
		}
		throw new NoSuchElementException("Task with ID " + id + " not found");
	}
	
	public void modifyById(int id, Task task) {
        for (int i = 0; i < this.size(); i++) {
            Task t = this.get(i);
            if (t instanceof model.Task && ((model.Task) t).getId() == id) {
                this.set(i, task);
                return;
            }
        }
        throw new NoSuchElementException("Task with ID " + id + " not found");
    }
    
    
}
