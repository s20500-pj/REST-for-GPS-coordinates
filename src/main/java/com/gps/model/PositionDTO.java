package com.gps.model;

import javax.validation.constraints.*;

public class PositionDTO {

    @NotEmpty(message = "{validation.constraints.NotEmpty.message}")
    @Positive(message = "{validation.constraints.Positive.message}")
    @Digits(integer = 7, fraction = 0, message = "{validation.constraints.Digits.message}")
    private String deviceId;
    @NotNull(message = "{validation.constraints.NotNull.message}")
    @Digits(integer = 7, fraction = 0, message = "{validation.constraints.Digits.message}")
    private Integer latitiude;
    @NotNull(message = "{validation.constraints.NotNull.message}")
    @Digits(integer = 7, fraction = 0, message = "{validation.constraints.Digits.message}")
    private Integer longitude;

    public PositionDTO() {

    }

    public PositionDTO(String deviceId, Integer latitiude, Integer longitude) {
        this.deviceId = deviceId;
        this.latitiude = latitiude;
        this.longitude = longitude;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getLatitiude() {
        return latitiude;
    }

    public void setLatitiude(Integer latitiude) {
        this.latitiude = latitiude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }
}
