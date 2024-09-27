package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.CountryDTO;
import org.arpitvashi.parkmate.Model.CountryModel;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {
    // Convert CountryModel to CountryDTO
    public CountryDTO toDTO(CountryModel country) {
        if (country == null) {
            return null;
        }
        return new CountryDTO(country.getId(), country.getName(), country.getTelephoneCode()); // Include ID
    }

    // Convert CountryDTO to CountryModel
    public CountryModel toModel(CountryDTO countryDTO) {
        if (countryDTO == null) {
            return null;
        }
        return new CountryModel(countryDTO.getName(), countryDTO.getTelephoneCode());
    }
}
