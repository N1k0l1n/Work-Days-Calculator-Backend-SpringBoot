package com.example.workdays.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "working_day")
public class WorkingDay {
    @Id
    @Column(name = "id", nullable = true)
    private int id;

    @Column(name = "user_id", nullable = true)
    private int user_id;

    @Column(name = "date", nullable = true)
    private Date date;

    @Column(name = "hours", nullable = true)
    private int hours;

    @JsonIgnore
    @ManyToOne(optional=false)
    @JoinColumn(name = "user_id" , insertable=false, updatable=false)
    private Users users;


}