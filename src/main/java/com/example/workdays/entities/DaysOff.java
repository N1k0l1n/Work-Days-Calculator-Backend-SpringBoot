package com.example.workdays.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "days_off")
public class DaysOff {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "date", nullable = true)
    private Date date;
}