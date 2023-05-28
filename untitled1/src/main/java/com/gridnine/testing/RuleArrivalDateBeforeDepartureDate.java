package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RuleArrivalDateBeforeDepartureDate implements Rule{

    public List<Flight> methodFiltration(List<Flight> flights)
    {
        List<Flight> result = new ArrayList<>();
        boolean addFly;
        for (Flight fly: flights)
        {
            addFly = true;
            for (Segment segment: fly.getSegments())
            {
                addFly = !segment.getArrivalDate().isBefore(segment.getDepartureDate());
                if (!addFly) {
                    break;
                }
            }
            if (addFly) {
                result.add(fly);
            }
        }
        return result;
    }
}
