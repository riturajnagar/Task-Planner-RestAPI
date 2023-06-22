package com.taskplanner.entities;



import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@javax.persistence.Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskId;
	
    @NotEmpty
	private String title;
    
    @NotEmpty
	private String status;
	
    
	private String description;
	
	private Integer assigneeId;
	
	private Integer sprintId;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Sprint sprint;
	
	
}
