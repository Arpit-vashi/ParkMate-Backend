package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.CountryDTO;
import org.arpitvashi.parkmate.Mapper.CountryMapper;
import org.arpitvashi.parkmate.Model.CountryModel;
import org.arpitvashi.parkmate.Repository.CountryRepository;
import org.arpitvashi.parkmate.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<CountryDTO> getAllCountries() {
        List<CountryModel> countries = countryRepository.findAll();
        return countries.stream()
                .map(countryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDTO createCountry(CountryDTO countryDTO) {
        CountryModel countryModel = countryMapper.toModel(countryDTO);
        CountryModel savedCountry = countryRepository.save(countryModel);
        return countryMapper.toDTO(savedCountry); // Will include ID
    }

    @Override
    public CountryDTO getCountryById(Long id) {
        return countryRepository.findById(id)
                .map(countryMapper::toDTO)
                .orElse(null); // Handle not found case as needed
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        return countryRepository.findByName(name)
                .map(countryMapper::toDTO)
                .orElse(null); // Handle not found case as needed
    }
}
