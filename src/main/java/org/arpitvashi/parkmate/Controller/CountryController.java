package org.arpitvashi.parkmate.Controller;

import org.arpitvashi.parkmate.Dto.CountryDTO;
import org.arpitvashi.parkmate.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin( origins = "http://Localhost:4200")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // GET endpoint to retrieve the list of countries
    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        List<CountryDTO> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }
}
