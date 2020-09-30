package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "CART_ID")
    private long cartId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
    )
    private List<Product> products= new ArrayList<>();

    @OneToOne(mappedBy = "cart",cascade = CascadeType.ALL)
    private User User;

    public Cart(long cartId, List<Product> products) {
        this.cartId = cartId;
        this.products = products;
    }
}
