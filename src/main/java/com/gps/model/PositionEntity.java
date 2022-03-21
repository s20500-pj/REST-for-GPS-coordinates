package com.gps.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class PositionEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deviceId;
    private Integer latitiude;
    private Integer longitude;
    private Timestamp positionTime;

    public PositionEntity(String deviceId, Integer latitiude, Integer longitude) {
        this.deviceId = deviceId;
        this.latitiude = latitiude;
        this.longitude = longitude;
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

    public Timestamp getPositionTime() {
        return positionTime;
    }

    public void setPositionTime(Timestamp positionTime) {
        this.positionTime = positionTime;
    }
}
