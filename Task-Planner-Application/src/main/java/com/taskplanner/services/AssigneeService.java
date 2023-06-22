package com.taskplanner.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskplanner.entities.Assignee;
import com.taskplanner.entities.Task;
import com.taskplanner.exceptions.NoAssigneAvailableException;
import com.taskplanner.repository.AssigneeRepo;
import com.taskplanner.repository.TaskRepository;

@Service
public class AssigneeService {
	
	
	@Autowired
	private AssigneeRepo ar;
	
	@Autowired
	private TaskRepository tr;
    
	public String saveAssignee(Assignee as) {
		ar.save(as);
		return "Assignee registered successfully!";
	}
	
	
	public String deleteAssignee(Integer Id) throws NoAssigneAvailableException {
		Optional<Assignee> a=ar.findById(Id);
		
		if(a.isPresent()) {
			
			ar.deleteById(Id);
			return "Assignee deleted successfully!";
		}
		else {
			throw new NoAssigneAvailableException("No assigneee available to die!");
		}
		
	}
	
	public List<Task> getallAssignedTask(Integer Id) {
		
		List<Task> allTask = tr.findAll();
		List<Task> getALLTask=new ArrayList<>();
		
		for(int i=0; i<allTask.size(); i++) {
			if(allTask.get(i).getAssigneeId()==Id) {
				getALLTask.add(allTask.get(i));
			}
		}
		
		return getALLTask;
		
	}
	
}
