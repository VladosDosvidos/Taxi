package hw8.taxi.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vlad on 23.04.2015.
 */

@Entity
public class Taxist {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "TAXI_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    private Long id;

    private String firstName;

    private String secondName;

    private String phone;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Set<Order> taxiOrders;

    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Order currentOrder;

    private boolean isOnline;

    public Taxist() {
    }
    public Taxist(String firstName, String phone) {
        this.firstName = firstName;
        this.secondName = null;
        this.phone = phone;
        this.password = null;
        this.isOnline = false;
    }

    public Taxist(String firstName, String secondName, String phone, String pass) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.password = pass;
        this.isOnline = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Order> getTaxiOrders() {
        return taxiOrders;
    }

    public void setTaxiOrders(Set<Order> taxiOrders) {
        this.taxiOrders = taxiOrders;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public void addOrder(Order order){
        taxiOrders.add(order);
    }

    @Override
    public String toString() {
        return "Taxist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", isOnline=" + isOnline +
                '}';
    }
}
