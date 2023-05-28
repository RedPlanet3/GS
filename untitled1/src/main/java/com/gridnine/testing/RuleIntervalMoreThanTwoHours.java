package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RuleIntervalMoreThanTwoHours implements Rule{

    public List<Flight> methodFiltration(List<Flight> flights)
    {
        long sumTime;
        List<Flight> result = new ArrayList<>();
        boolean addFly;
        for (Flight fly: flights)
        {
            sumTime = 0;
            addFly = true;
            int i = 0;
            LocalDateTime lastTime = LocalDateTime.now();
            for (Segment segment: fly.getSegments())
            {
                if (i > 0)
                    sumTime += ChronoUnit.HOURS.between(lastTime, segment.getDepartureDate());
                if (sumTime > 2)
                {
                    addFly = false;
                    break;
                }
                lastTime = segment.getArrivalDate();
                i = 1;
            }
            if (addFly) result.add(fly);
        }
        return result;
    }
}
