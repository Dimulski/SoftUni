package com.pizzamoreLab.models.session;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pizza_sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "pizzaSession", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SessionData> sessionData;

    public Session() {
        this.setSessionData(new HashSet<>());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<SessionData> getSessionData() {
        return sessionData;
    }

    public void setSessionData(Set<SessionData> sessionData) {
        this.sessionData = sessionData;
    }

    public void addSessionData(String key, String value) {
        SessionData sessionData = new SessionData(key, value, this);
        this.getSessionData().add(sessionData);
    }
}
