package com.gps.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class PositionEntity extends PositionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp positionTime;

    public PositionEntity(String deviceId, int latitiude, int longitude) {
        super(deviceId, latitiude, longitude);
        this.positionTime = new Timestamp(new Date().getTime());
    }

    public PositionEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getPositionTime() {
        return positionTime;
    }

    public void setPositionTime(Timestamp positionTime) {
        this.positionTime = positionTime;
    }
}
