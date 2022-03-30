package com.gps.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;


@NoArgsConstructor
@Data
@Entity
public class PositionEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deviceId;
    private Double latitiude;
    private Double longitude;
    private Timestamp positionTime;

    public PositionEntity(String deviceId, Double latitiude, Double longitude) {
        this.deviceId = deviceId;
        this.latitiude = latitiude;
        this.longitude = longitude;
        this.positionTime = new Timestamp(new Date().getTime());
    }
}
