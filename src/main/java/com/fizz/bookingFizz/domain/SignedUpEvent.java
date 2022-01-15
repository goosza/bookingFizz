package com.fizz.bookingFizz.domain;

import javax.persistence.*;

@Entity
public class SignedUpEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "local_event_id")
    private LocalEvent localEvent;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SignedUpEvent(LocalEvent localEvent, User user) {
        this.localEvent = localEvent;
        this.user = user;
    }

    public SignedUpEvent() {

    }

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
