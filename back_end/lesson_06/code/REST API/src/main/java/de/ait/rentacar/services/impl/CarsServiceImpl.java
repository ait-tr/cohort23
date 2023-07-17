package de.ait.rentacar.services.impl;

import de.ait.rentacar.models.Car;
import de.ait.rentacar.repositories.CarsRepository;
import de.ait.rentacar.services.CarsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 7/14/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Service
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;

    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carsRepository.findAll();
    }
}
