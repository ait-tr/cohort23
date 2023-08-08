package de.ait.timepad.dto;

import de.ait.timepad.validation.constraints.CorrectTimes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 8/8/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@CorrectTimes
public class NewEventDto {

    private String titles;

    @NotBlank
    @NotNull
    private String startTime;

    @NotBlank
    @NotNull
    private String finishTime;
}
