package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long   id;
    @Column(name = "name")
    String name;
    @Column(name = "number")
    String number;
    @Column(name = "series")
    int    series;


    @OneToOne
    @PrimaryKeyJoinColumn(name = "user_id")

    User user;


    public Car() {


    }

    public Car(String name, int series, String number) {
        this.name = name;
        this.series = series;
        this.number = number;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
