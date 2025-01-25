package org.example.coach.impl;

import org.example.coach.Coach;
import org.springframework.stereotype.Component;

@Component("BaseballCoach")
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Thang nay phai day som nha m";
    }
}
