package com.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskplanner.entities.Assignee;

public interface AssigneeRepo extends JpaRepository<Assignee, Integer>{

}
