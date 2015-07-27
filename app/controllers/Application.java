package controllers;
//import  models;

import play.*;
import play.mvc.*;

import models.Task;//per instructions
import play.data.*;//per instructions

import views.html.*;

public class Application extends Controller {
	static Form<Task> taskForm = Form.form(Task.class);
    public static Result index() {
        //return ok(index.render("Your new application is ready."));
    	/*return ok(index.render("Hello, World!"));*/
    	return redirect(routes.Application.tasks());
    }
    public static Result tasks(){
    	
    	return ok(
    		views.html.index.render(Task.all(), taskForm)
    	);
    }
    public static Result newTask(){
    	//return TODO;
    	Form<Task> filledForm = taskForm.bindFromRequest();
    	if(filledForm.hasErrors() ) {
    		return badRequest(
				views.html.index.render(Task.all(), filledForm)
			);
    	} else{
    		Task.create(filledForm.get());
    		return redirect(routes.Application.tasks() );
    	}
    }
    public static Result deleteTask(Long id){
    	return TODO;
    }

}
