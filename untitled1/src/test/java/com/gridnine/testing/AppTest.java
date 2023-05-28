package com.gridnine.testing;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    @Test
    public void depBeforeCurr()
    {
        Filtration filtration = new FiltrationImpl();
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(Arrays.asList(new Segment(threeDaysFromNow.minusDays(6), threeDaysFromNow))));
        List<Flight> answ = filtration.applyFilter(FiltrType.DEPARTURE_BEFORE_CURRENT_TIME, flights);
        assertEquals(0, answ.size());
    }

    @Test
    public void arivBeforeDep()
    {
        Filtration filtration = new FiltrationImpl();
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(6)))));
        List<Flight> answ = filtration.applyFilter(FiltrType.ARRIVAL_BEFORE_DEPARTURE, flights);
        assertEquals(0, answ.size());
    }

    @Test
    public void moreTwoHours()
    {
        Filtration filtration = new FiltrationImpl();
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)), new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)))));
        List<Flight> answ = filtration.applyFilter(FiltrType.INTERVAL_MORE_THAN_TWO_HOURS, flights);
        assertEquals(0, answ.size());
    }
}
