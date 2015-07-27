package models;

import java.util.*;

import play.data.validation.Constraints.*;
import play.data.*;
import controllers.Application;
import controllers.routes;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model{
	//static Form<Task> taskForm = Form.form(Task.class);
	
	@Id
	public Long id;
	
	@Required
	public String label;
	
	public static Finder<Long,Task> find = new Finder(
			Long.class, Task.class
		);
	
	public static List<Task> all() {
		//return new ArrayList<Task>();
		return find.all();
	}
	public static void create(Task task){
		task.save();
		
	}
	public static void delete(Long id){
		find.ref(id).delete();
	}
	public static Result deleteTask(Long id) {
		Task.delete(id);
		return redirect(routes.Application.tasks());
	}

}
