package com.taskplanner.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskplanner.entities.Assignee;
import com.taskplanner.entities.Sprint;
import com.taskplanner.entities.Task;
import com.taskplanner.exceptions.NoAssigneAvailableException;
import com.taskplanner.exceptions.NoMoreTaskException;
import com.taskplanner.exceptions.NoSprintAvailableException;
import com.taskplanner.repository.AssigneeRepo;
import com.taskplanner.repository.SprintRepo;
import com.taskplanner.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository tr;
	
	@Autowired
	private SprintRepo sr;
	
	@Autowired
	private AssigneeRepo ar;
	
	public String savetask(Task task) throws NoSprintAvailableException, NoAssigneAvailableException {
	
			tr.save(task);
			return "task saved Successfully!";
		
	}
	
	
	public String updateTask(Task task) throws NoMoreTaskException, NoSprintAvailableException, NoAssigneAvailableException{
		
		Optional<Task> t=tr.findById(task.getTaskId());
		
		if(t.isEmpty()) {
			throw new NoMoreTaskException("this task is not available to edit!");
		}
		else {
			
			     Task ts=t.get();	
			     ts.setAssigneeId(task.getAssigneeId());
			     ts.setSprintId(task.getSprintId());
			     ts.setStatus(task.getStatus());
			     ts.setDescription(task.getDescription());
			     ts.setTitle(task.getTitle());
			     			     
				return "task Updated Successfully!";
			}
		
	}
	
	
	public String deleteTask(Integer id) throws NoMoreTaskException
	{
		Optional<Task> t=tr.findById(id);
		if(!t.isPresent()) {
			tr.deleteById(id);
					
						
			return "task deleted successfully";
		}
		else {
			throw new NoMoreTaskException("Task is not available!");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
