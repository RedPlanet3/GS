package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void printFlights(List<Flight> flights)
    {
        int i = 1;
        for (Flight flight: flights)
//            System.out.println(i++ + " : " +flight);
        System.out.println(flight);
    }
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        printFlights(flights);
        Filtration filtration = new FiltrationImpl(); //слабая связанность. можно заменить фильтр
        System.out.println(FiltrType.DEPARTURE_BEFORE_CURRENT_TIME);
        printFlights(filtration.applyFilter(FiltrType.DEPARTURE_BEFORE_CURRENT_TIME, flights));
        System.out.println(FiltrType.ARRIVAL_BEFORE_DEPARTURE);
        printFlights(filtration.applyFilter(FiltrType.ARRIVAL_BEFORE_DEPARTURE, flights));
        System.out.println(FiltrType.INTERVAL_MORE_THAN_TWO_HOURS);
        printFlights(filtration.applyFilter(FiltrType.INTERVAL_MORE_THAN_TWO_HOURS, flights));
    }
}
