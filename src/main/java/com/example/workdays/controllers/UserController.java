package com.example.workdays.controllers;

import com.example.workdays.entities.DaysOff;
import com.example.workdays.entities.Users;
import com.example.workdays.entities.WorkingDay;
import com.example.workdays.repo.DaysOffRepository;
import com.example.workdays.repo.UsersRepository;
import com.example.workdays.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {


    public UsersRepository usersRepository;
    public DaysOffRepository daysOffRepository;

    public UserController(UsersRepository usersRepository, DaysOffRepository daysOffRepository) {
        this.usersRepository = usersRepository;
        this.daysOffRepository = daysOffRepository;
    }

    @GetMapping("/list")
    public List<Users> getUsers() {

        Utils utils = new Utils();
        List<DaysOff> daysOffs = this.daysOffRepository.findAll();
        List<Users> users = this.usersRepository.findAll();
        for (Users user : users) {
            System.out.println(user.getId());
            List<WorkingDay> workingDays = user.getWorkingDays();
            double payment = user.getPayment();
            double paymentForHour = payment / 168; // 168 are working hours in month
            double additionalPayment = 0;
            for (WorkingDay day : workingDays) {
                System.out.println("Day - " + day.getDate());
                boolean isDayOff = false;
                for (DaysOff off : daysOffs) {
                    if (off.getDate().compareTo(day.getDate()) == 0) {
                        isDayOff = true;
                        break;
                    }
                }

                System.out.println("isDayOff - " + isDayOff);
                additionalPayment = additionalPayment + utils.calculatePayment(paymentForHour, day.getHours(), isDayOff);
            }

            System.out.println("Initial Payment - " + user.getPayment());
            System.out.println("Additional Payment - " + additionalPayment);
            user.setPayment(payment + additionalPayment);
            System.out.println("Amount - " + user.getPayment());
        }

        return users;
    }


}
