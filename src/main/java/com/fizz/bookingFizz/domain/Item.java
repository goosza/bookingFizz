package com.fizz.bookingFizz.domain;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int quantity;
    private String photo;

    public Item(String name, int quantity, String photo) {
        this.name = name;
        this.quantity = quantity;
        this.photo = photo;
    }
    public Item() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhoto() {
        return photo;
    }
    @Transient
    public String getPhotosImagePath() {
        if (photo == null || id == null) return null;

        return "/item-photos/" + id + "/" + photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
