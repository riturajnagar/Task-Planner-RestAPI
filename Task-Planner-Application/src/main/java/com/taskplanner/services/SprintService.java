package com.taskplanner.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskplanner.entities.Sprint;
import com.taskplanner.entities.Task;
import com.taskplanner.exceptions.NoSprintAvailableException;
import com.taskplanner.repository.SprintRepo;
import com.taskplanner.repository.TaskRepository;

@Service
public class SprintService {
	
	@Autowired
	private SprintRepo sp;
	
	
	@Autowired
	private TaskRepository tr;
	
	public String saveSprint(Sprint sprint) {
		sp.save(sprint);
		
		return "sprint saved succesfully!";
	}
	
	public String deleteSprint(Integer id) throws NoSprintAvailableException{
		Optional<Sprint> s= sp.findById(id);
		
		if(s.isPresent()) {
			sp.deleteById(id);
			return "sprint deleted successfully!";
		}
		else {
			throw new NoSprintAvailableException("OOOpp!, Sprint is not there!");
		}
		
	}
	
    public List<Task> getallAssignedTaskInThisSprint(Integer Id) {
		
		List<Task> allTask = tr.findAll();
		List<Task> getALLTaskBySprint=new ArrayList<>();
		
		for(int i=0; i<allTask.size(); i++) {
			if(allTask.get(i).getSprintId()==Id) {
				getALLTaskBySprint.add(allTask.get(i));
			}
		}
		
		return getALLTaskBySprint;
		
	}
	

}
