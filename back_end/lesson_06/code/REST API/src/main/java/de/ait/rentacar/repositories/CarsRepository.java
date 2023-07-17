package de.ait.rentacar.repositories;

import de.ait.rentacar.models.Car;

import java.util.List;

public interface CarsRepository {
    List<Car> findAll();
}
