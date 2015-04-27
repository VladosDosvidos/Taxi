package hw8.taxi.domain;

import javax.persistence.*;
import java.awt.*;

/**
 * Created by Роберт on 27.04.2015.
 */
@Entity
public class Cab {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CAB_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    private Long id;

    private String registNumber;

    private String model;

    private Color color;

    public Cab() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistNumber() {
        return registNumber;
    }

    public void setRegistNumber(String registNumber) {
        this.registNumber = registNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id=" + id +
                ", registNumber='" + registNumber + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                '}';
    }
}
