package com.gridnine.testing;

import java.util.List;

public interface Filtration {
     List<Flight> applyFilter(FiltrType filtrType, List<Flight> flights);
//    public List<Flight> methodFiltration(List<Flight> flights)
}
