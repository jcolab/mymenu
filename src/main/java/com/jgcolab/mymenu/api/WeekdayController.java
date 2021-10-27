package com.jgcolab.mymenu.api;

import com.jgcolab.mymenu.domain.Weekday;
import com.jgcolab.mymenu.domain.WeekdayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (produces = "application/json")
public class WeekdayController {

    private WeekdayService weekdayService;

    public WeekdayController (WeekdayService weekdayService) {
        this.weekdayService = weekdayService;
    }

    @ApiOperation("Retrieve all weekdays.")
    @GetMapping (value = "/weekdays")
    public List<Weekday> getWeekdays() {
        return weekdayService.getWeekdays();
    }
}
