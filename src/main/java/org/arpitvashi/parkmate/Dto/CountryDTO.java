package org.arpitvashi.parkmate.Dto;

public class CountryDTO {
    private Long id; // Add the ID field
    private String name;
    private String telephoneCode;

    public CountryDTO() {
    }

    public CountryDTO(Long id, String name, String telephoneCode) { // Update constructor
        this.id = id;
        this.name = name;
        this.telephoneCode = telephoneCode;
    }

    // Getters and Setters
    public Long getId() {
        return id; // Getter for ID
    }

    public void setId(Long id) {
        this.id = id; // Setter for ID
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
