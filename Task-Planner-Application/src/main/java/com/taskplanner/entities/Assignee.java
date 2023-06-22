package com.taskplanner.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignee {
	    @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
		private Long AssigneeId;
	    
	    
	    @NotEmpty
	    private String name;
	   
	    
	    @Email
	    private String email;
	  
		
}
