package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class CountryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "telephone_code", nullable = false)
    private String telephoneCode;

    // Constructors
    public CountryModel() {
    }

    public CountryModel(String name, String telephoneCode) {
        this.name = name;
        this.telephoneCode = telephoneCode;
    }

    // Getters and Setters
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

    public String getTelephoneCode() {
        return telephoneCode;
    }

    public void setTelephoneCode(String telephoneCode) {
        this.telephoneCode = telephoneCode;
    }
}
