package com.gridnine.testing;

import com.gridnine.testing.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FiltrationImpl implements Filtration {

    public List<Flight> applyFilter(FiltrType filtrType, List<Flight> flights)
    {
       return getRule(filtrType).methodFiltration(flights);
    }

    private Rule getRule(FiltrType filtrType)
    {
        switch (filtrType)
        {
            case DEPARTURE_BEFORE_CURRENT_TIME:
                 return new RuleDepartureBeforeCurrentTime();
            case ARRIVAL_BEFORE_DEPARTURE:
                return new RuleArrivalDateBeforeDepartureDate();
            case INTERVAL_MORE_THAN_TWO_HOURS:
                return new RuleIntervalMoreThanTwoHours();
            default:
                return null;
        }
    }
}
