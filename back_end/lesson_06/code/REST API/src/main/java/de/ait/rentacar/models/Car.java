package de.ait.rentacar.models;

import lombok.*;

/**
 * 7/14/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@ToString // для автоматической генерации toString()
@EqualsAndHashCode // для автоматической генерации equals() и hashCode()
@Getter // для автоматической генерации геттеров
@Setter // для автоматической генерации сеттеров
@NoArgsConstructor // конструктор без параметров
@AllArgsConstructor // конструктор с параметрами
public class Car {

    private Long id; // идентификатор модели
    private String model; // название модели автомобиля
    private String color; // цвет автомобиля
}
