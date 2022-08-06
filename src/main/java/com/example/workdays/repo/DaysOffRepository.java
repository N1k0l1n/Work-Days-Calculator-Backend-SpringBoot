package com.example.workdays.repo;

import com.example.workdays.entities.DaysOff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaysOffRepository extends JpaRepository<DaysOff, Long> {
    //shto query
}