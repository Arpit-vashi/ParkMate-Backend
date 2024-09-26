package org.arpitvashi.parkmate.Dto;

public class CountryDTO {
    private String name;
    private String telephoneCode;

    public CountryDTO() {
    }

    public CountryDTO(String name, String telephoneCode) {
        this.name = name;
        this.telephoneCode = telephoneCode;
    }

    // Getters and Setters
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
