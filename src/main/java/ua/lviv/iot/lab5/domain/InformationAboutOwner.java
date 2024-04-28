package ua.lviv.iot.lab5.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "information_about_owner", schema = "project", catalog = "")
public class InformationAboutOwner {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "age")
    private Integer age;
    @Basic
    @Column(name = "fortunes")
    private Integer fortunes;
    @OneToMany(mappedBy = "informationAboutOwner")
    private List<Establishment> establishments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getFortunes() {
        return fortunes;
    }

    public void setFortunes(Integer fortunes) {
        this.fortunes = fortunes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformationAboutOwner that = (InformationAboutOwner) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(age, that.age) && Objects.equals(fortunes, that.fortunes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, fortunes);
    }

    public List<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<Establishment> establishments) {
        this.establishments = establishments;
    }
}
