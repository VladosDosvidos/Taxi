package hw8.taxi.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * Created by Роберт on 27.04.2015.
 */
@Entity
public class Address {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ADDRESS_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    private String street; // только название улицы

    private String prefix; //улица или проспект или переулок ...


    @ManyToOne (fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private District district;

    public Address() {
    }

    public Address(String address) {
        street=address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", prefix='" + prefix + '\'' +
                ", district=" + district +
                '}';
    }
}
