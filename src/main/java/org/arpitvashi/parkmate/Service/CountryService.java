package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.CountryDTO;

import java.util.List;

public interface CountryService {
    List<CountryDTO> getAllCountries();
    CountryDTO createCountry(CountryDTO countryDTO);
    CountryDTO getCountryById(Long id);
    CountryDTO getCountryByName(String name);
}
