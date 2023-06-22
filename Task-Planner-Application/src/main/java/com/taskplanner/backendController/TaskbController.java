package com.taskplanner.backendController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskplanner.entities.Task;
import com.taskplanner.exceptions.NoAssigneAvailableException;
import com.taskplanner.exceptions.NoMoreTaskException;
import com.taskplanner.exceptions.NoSprintAvailableException;
import com.taskplanner.services.TaskService;

@RestController
@RequestMapping("/api")
public class TaskbController {

	@GetMapping("/welcome")
	public  String  homepage() {
	
		return "greetings here......";
	}
	
	@Autowired
	private TaskService ts;
	
	@PostMapping("/addtask")
	public ResponseEntity<String> addTaskHandler(@RequestBody @Valid Task task) throws NoSprintAvailableException, NoAssigneAvailableException{
		String str= ts.savetask(task);
		 
		return new ResponseEntity<>(str, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<String> deleteTaskHandler(@PathVariable Integer id)throws  NoMoreTaskException{
		String str=ts.deleteTask(id);
		 
		return new ResponseEntity<>(str, HttpStatus.OK);
	}

	@PutMapping("/updatTask")
	public ResponseEntity<String> updateTaskHandler(@RequestBody Task task) throws NoSprintAvailableException, NoAssigneAvailableException, NoMoreTaskException{
		String str= ts.updateTask(task);
		 
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	
}
