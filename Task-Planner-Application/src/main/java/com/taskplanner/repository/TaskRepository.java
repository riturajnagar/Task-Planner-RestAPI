package com.taskplanner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.taskplanner.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

//	
//	@Query(value="Select * from task order by due_date desc",nativeQuery = true)
//	public List<Task> getAllTaskDueDateDesc();
//	
//	
//	@Query(value="Select new com.taskplanner.dto.CountType(COUNT(*)/(Select COUNT(*) from Task) *100,type) from Task GROUP BY type")
//	public List<CountType> getPercentageGroupByType();
	
}
