package com.farhad.example.design_principles02.ppp.exercise_2_srp.library.mocks;

import java.text.ParseException;
import java.util.Date;

import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.TimeSource;
import com.farhad.example.design_principles02.ppp.exercise_2_srp.library.utils.DateUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MockTimeSource implements TimeSource {

    private Date time;

    public MockTimeSource(String dateString) throws ParseException {
        time = DateUtil.dateFromString(dateString);
    }

    @Override
    public Date getTime() {
        return time;
    }
    
}
