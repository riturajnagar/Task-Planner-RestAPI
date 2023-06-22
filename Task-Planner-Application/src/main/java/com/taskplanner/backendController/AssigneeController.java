package com.taskplanner.backendController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskplanner.entities.Assignee;
import com.taskplanner.entities.Task;
import com.taskplanner.exceptions.NoAssigneAvailableException;
import com.taskplanner.services.AssigneeService;

@RestController
@RequestMapping("/api")
public class AssigneeController {
	
	@Autowired
	private AssigneeService as;
	
	@PostMapping("/addassignee")
	public ResponseEntity<String> addassigneeHandler(@RequestBody @Valid Assignee assignee){
		String str= as.saveAssignee(assignee);
		 
		return new ResponseEntity<>(str, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAssigneeHandler(@PathVariable Integer id) throws NoAssigneAvailableException{
		String str= as.deleteAssignee(id);
		 
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	
     @GetMapping("/getaallAssignedTask/{id}")
     public ResponseEntity<List<Task>> getAllAssigndTask(@PathVariable Integer id){
    	 List<Task> li=as.getallAssignedTask(id);
    	 
    	 return new ResponseEntity<List<Task>>(li,HttpStatus.ACCEPTED);
     }
	
	
}
