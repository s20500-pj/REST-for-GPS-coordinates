package com.gps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PositionDTO {

    @NotEmpty(message = "{validation.constraints.NotEmpty.message}")
    @Positive(message = "{validation.constraints.Positive.message}")
    @Digits(integer = 7, fraction = 0, message = "{validation.constraints.Digits.message}")
    private String deviceId;
    @NotNull(message = "{validation.constraints.NotNull.message}")
    @Digits(integer = 7, fraction = 5, message = "{validation.constraints.Digits.message}")
    private Double latitiude;
    @NotNull(message = "{validation.constraints.NotNull.message}")
    @Digits(integer = 7, fraction = 5, message = "{validation.constraints.Digits.message}")
    private Double longitude;

}
