package com.example.workdays.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class Utils {

//    public static void main(String[] args) throws JSONException
//    {
////constructor of the JSONObject class
//        JSONObject obj = new JSONObject(
//                "{" +
//                        "Employee ID: 092789," +
//                        "Employee Name: Helen Mirren," +
//                        "Age: 27, " +
//                        "Designation: Assistant Manager," +
//                        "City: Florida," +
//                        "Salary: 67000.00, " +
//                        "Experience: 26 " +
//                        "}"
//        );
////getting values form the JSONObject
//        System.out.println("Employee ID: "+obj.getInt("Employee ID"));
//        System.out.println("Employee Name: "+obj.getString("Employee Name"));
//        System.out.println("Age: "+obj.getInt("Age"));
//        System.out.println("Designation: "+obj.getString("Designation"));
//        System.out.println("City: "+obj.getString("City"));
//        System.out.println("Salary: "+obj.getDouble("Salary"));
//        System.out.println("Experience: "+obj.getInt("Experience") +" Months");
//    }
//
//
//
//


    public double calculatePayment(double wage, int hours, boolean isDayOff) {
    if (isDayOff) {
        return this.calculateOffDay(wage, hours);
    } else {
        return this.calculateNormalDay(wage, hours);
    }
}

    public double calculateNormalDay(double wage, int hours) {
        if (hours > 8) {
            int extraHours = hours - 8;
            return extraHours * 1.25 * wage;
        }
        return 0;
    }

    public double calculateOffDay(double wage, int hours) {
        if (hours > 8) {
            int extraHours = hours - 8;
            return wage * 1.25 * 8 + extraHours * 1.5 * wage;
        } else {
            return wage * 1.25 * 8;
        }
    }
}
