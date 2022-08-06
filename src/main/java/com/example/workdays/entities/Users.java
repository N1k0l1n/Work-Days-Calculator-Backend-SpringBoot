package com.example.workdays.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "id", nullable = false)
    private int id;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "surname", nullable = false)
    private String surname;


    @Column(name = "payment", nullable = false)
    private double payment;


    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<WorkingDay> workingDays;


}