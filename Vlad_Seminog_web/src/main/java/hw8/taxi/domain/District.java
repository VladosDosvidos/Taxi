package hw8.taxi.domain;

import javax.persistence.*;

/**
 * Created by Роберт on 27.04.2015.
 */
@Entity
public class District {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "DISTRICT_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    private String title;

    public District() {
    }

    public District(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
