package com.example.workdays.repo;

import com.example.workdays.entities.Users;
import com.example.workdays.entities.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkingDayRepository extends JpaRepository<WorkingDay, Long> {

}