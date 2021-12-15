package com.fizz.bookingFizz.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
public class LocalEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime datefrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateto;

    private String billboardPath;
    private String description;


    public LocalEvent(String name, LocalDateTime datefrom, LocalDateTime dateto, String billboardPath, String description) {
        this.name = name;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.billboardPath = billboardPath;
        this.description = description;
    }

    public LocalEvent() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(LocalDateTime datefrom) {
        this.datefrom = datefrom;
    }

    public LocalDateTime getDateto() {
        return dateto;
    }

    public void setDateto(LocalDateTime dateto) {
        this.dateto = dateto;
    }

    public String getBillboardPath() {
        return billboardPath;
    }

    @Transient
    public String getPhotosImagePath() {
        if (billboardPath == null || id == null) return null;

        return "/localEvents-photos/" + id + "/" + billboardPath;
    }

    public void setBillboardPath(String billboardPath) {
        this.billboardPath = billboardPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
