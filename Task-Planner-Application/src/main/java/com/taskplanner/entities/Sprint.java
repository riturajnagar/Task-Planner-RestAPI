package com.taskplanner.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sprint {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
		private Long SprintId;
	 
	   
	   @OneToMany(cascade = CascadeType.ALL,mappedBy = "sprint")
	  private List<Task> allTask;
		
}
