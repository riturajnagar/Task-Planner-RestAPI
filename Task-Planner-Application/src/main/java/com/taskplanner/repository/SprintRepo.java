package com.taskplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskplanner.entities.Sprint;

public interface SprintRepo extends JpaRepository<Sprint, Integer> {

}
