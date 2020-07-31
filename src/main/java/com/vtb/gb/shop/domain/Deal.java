package com.vtb.gb.shop.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "deal")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deal_id/")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "price")
    private Long price;

    public Deal() {
    }

    public Deal(Long id, Product product, Customer customer, Long price) {
        this.id = id;
        this.product = product;
        this.customer = customer;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return Objects.equals(id, deal.id) &&
                Objects.equals(product, deal.product) &&
                Objects.equals(customer, deal.customer) &&
                Objects.equals(price, deal.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, customer, price);
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
