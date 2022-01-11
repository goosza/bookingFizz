package com.fizz.bookingFizz.Domain;

import javax.persistence.*;

@Entity
public class SignedUpLocalEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localevent_id")
    private LocalEvent localEvent;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalEvent getLocalEvent() {
        return localEvent;
    }

    public void setLocalEvent(LocalEvent localEvent) {
        this.localEvent = localEvent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
