package org.arpitvashi.parkmate.Controller;

import org.arpitvashi.parkmate.Dto.CountryDTO;
import org.arpitvashi.parkmate.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "http://localhost:4200") // Corrected casing for "localhost"
public class CountryController {

    @Autowired
    private CountryService countryService;

    // GET endpoint to retrieve the list of countries
    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        List<CountryDTO> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    // POST endpoint to create a new country
    @PostMapping
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) {
        CountryDTO createdCountry = countryService.createCountry(countryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCountry);
    }

    // GET endpoint to retrieve a country by ID
    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        CountryDTO country = countryService.getCountryById(id);
        return country != null ? ResponseEntity.ok(country) : ResponseEntity.notFound().build();
    }

    // GET endpoint to retrieve a country by name
    @GetMapping("/name/{name}")
    public ResponseEntity<CountryDTO> getCountryByName(@PathVariable String name) {
        CountryDTO country = countryService.getCountryByName(name);
        return country != null ? ResponseEntity.ok(country) : ResponseEntity.notFound().build();
    }
}
