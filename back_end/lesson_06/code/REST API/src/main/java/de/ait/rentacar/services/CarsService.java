package de.ait.rentacar.services;

import de.ait.rentacar.models.Car;

import java.util.List;

/**
 * 7/14/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface CarsService {
    List<Car> getAllCars();
}
