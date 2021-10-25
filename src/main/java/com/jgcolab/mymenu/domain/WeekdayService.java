package com.jgcolab.mymenu.domain;

import com.jgcolab.mymenu.repository.WeekdayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeekdayService {

    private WeekdayRepository weekdayRepository;

    WeekdayService (WeekdayRepository weekdayRepository) {
        this.weekdayRepository = weekdayRepository;
    }

    public List<Weekday> getWeekdays() {
        return weekdayRepository.findAll();
    }
}
