package com.pizzamoreLab.models.session;

import javax.persistence.*;

@Entity
@Table(name = "pizza_session_data")
public class SessionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "key_data")
    private String key;

    @Column(name = "value_data")
    private String value;

    @ManyToOne
    @JoinColumn(name = "pizza_session_id", nullable = false)
    private Session pizzaSession;

    public SessionData() {
    }

    public SessionData(String key, String value, Session session) {
        this.key = key;
        this.value = value;
        this.pizzaSession = session;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Session getPizzaSession() {
        return pizzaSession;
    }

    public void setPizzaSession(Session session) {
        this.pizzaSession = session;
    }
}
