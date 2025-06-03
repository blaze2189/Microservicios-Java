package com.bc.jlopez.application.port.usecase.frequence;



import com.bc.jlopez.domain.model.Flight;

import java.util.List;

public interface FindFrequence {

    List<Flight> findAllFrequence();

}
