package com.vtb.gb.shop.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "details")
public class Deal {

    @Column(name = "deal_price")
    private Long price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer person;

    public Deal() {
    }

    public Customer getCustomer() {
        return person;
    }

    public void setCustomer(Customer customer) {
        this.person = customer;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return Objects.equals(price, deal.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return String.format("Deal [price = %d , customer = %s]", price, person.toString());
    }
}
