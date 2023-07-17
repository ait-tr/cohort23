package de.ait.rentacar.controllers;

import de.ait.rentacar.models.Car;
import de.ait.rentacar.services.CarsService;
import de.ait.rentacar.services.impl.CarsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 7/14/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Controller
public class CarsController {

    private final CarsService carsService; // ставим final, чтобы это поле нельзя было поменять

    public CarsController(CarsServiceImpl service) {
        this.carsService = service;
    }

//    @GetMapping("/cars") - при обращении с /cars вы получали страницу с машинами
//    public String getCarsPage(Model model) {
//        model.addAttribute("carsList", service.getAllCars());
//        return "cars_view";
//    }

    @GetMapping("/cars")
    @ResponseBody
    public List<Car> getAllCars() {
        return carsService.getAllCars();
    }
}
