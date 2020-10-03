package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "USER_KEY")
    private long userKey;

    @NotNull
    @Column(name = "USERNAME", unique = true)
    private String username;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    private Cart cart;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orders = new ArrayList<>();

    @Column(name = "IS_ENABLE")
    private boolean isEnable;

    @Column(name = "DATE_OF_KEY")
    private LocalDateTime timeOfCreateKey;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        isEnable = true;
    }

    public User(long userId, long userkey, String username, String password, Cart cart, List<Order> orders, boolean isEnable) {
        this.userId = userId;
        this.userKey = userkey;
        this.username = username;
        this.password = password;
        this.cart=cart;
        this.orders=orders;
        this.isEnable=isEnable;

    }

    public void setUserKey(long userKey) {
        this.userKey = userKey;
        timeOfCreateKey = LocalDateTime.now();
    }

    private void setDateOfKey() {
    }
}