package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.ParkingLotDTO;
import org.arpitvashi.parkmate.Mapper.ParkingLotMapper;
import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.arpitvashi.parkmate.Repository.ParkingLotRepository;
import org.arpitvashi.parkmate.Service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    private static final int MAX_FLOORS = 1000;
    private static final String NAME_REGEX = "^[A-Za-z0-9-_,\\s\\/]+$"; // allow spaces
    private static final String ADDRESS_REGEX = "^[A-Za-z0-9-_,\\s\\/\\\\]+$"; // allow spaces
    private static final String CITY_STATE_REGEX = "^[A-Za-z,\\s]+$"; // allow spaces

    @Autowired
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLotMapper) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLotMapper = parkingLotMapper;
    }

    @Override
    public Page<ParkingLotDTO> getAllParkingLots(int page, int size) {
        Page<ParkingLotModel> parkingLotPage = parkingLotRepository.findAll(PageRequest.of(page, size));
        return parkingLotPage.map(parkingLotMapper::toDTO);
    }

    @Override
    public ParkingLotDTO getParkingLotById(Long id) {
        ParkingLotModel parkingLot = parkingLotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking lot not found with id: " + id));
        return parkingLotMapper.toDTO(parkingLot);
    }

    @Override
    public ParkingLotDTO createParkingLot(ParkingLotDTO parkingLotDTO) {
        validateParkingLotData(parkingLotDTO);
        checkForDuplicateParkingLot(parkingLotDTO); // Check for duplicates

        ParkingLotModel parkingLot = parkingLotMapper.toEntity(parkingLotDTO);
        ParkingLotModel savedParkingLot = parkingLotRepository.save(parkingLot);
        return parkingLotMapper.toDTO(savedParkingLot);
    }

    @Override
    public ParkingLotDTO updateParkingLot(Long id, ParkingLotDTO parkingLotDTO) {
        ParkingLotModel existingParkingLot = parkingLotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking lot not found with id: " + id));

        // Validate and update the fields
        if (parkingLotDTO.getName() != null) {
            validateName(parkingLotDTO.getName());
            existingParkingLot.setName(parkingLotDTO.getName());
        }

        if (parkingLotDTO.getAddressLine1() != null) {
            validateAddress(parkingLotDTO.getAddressLine1());
            existingParkingLot.setAddressLine1(parkingLotDTO.getAddressLine1());
        }

        if (parkingLotDTO.getCity() != null) {
            validateCityOrState(parkingLotDTO.getCity(), "City");
            existingParkingLot.setCity(parkingLotDTO.getCity());
        }

        if (parkingLotDTO.getState() != null) {
            validateCityOrState(parkingLotDTO.getState(), "State");
            existingParkingLot.setState(parkingLotDTO.getState());
        }

        if (parkingLotDTO.getCountry() != null) {
            existingParkingLot.setCountry(parkingLotDTO.getCountry());
        }

        if (parkingLotDTO.getSupportEmail() != null) {
            existingParkingLot.setSupportEmail(parkingLotDTO.getSupportEmail());
        }

        if (parkingLotDTO.getSupportMobile() != null) {
            existingParkingLot.setSupportMobile(parkingLotDTO.getSupportMobile());
        }

        if (parkingLotDTO.getCapacity() != null) {
            existingParkingLot.setCapacity(parkingLotDTO.getCapacity());
        }

        if (parkingLotDTO.getFloors() != null) {
            if (parkingLotDTO.getFloors().intValue() > MAX_FLOORS) {
                throw new IllegalArgumentException("Floors cannot exceed " + MAX_FLOORS);
            }
            existingParkingLot.setFloors(parkingLotDTO.getFloors());
        }

        if (parkingLotDTO.getUsedFloors() != null) {
            if (existingParkingLot.getFloors() != null &&
                    parkingLotDTO.getUsedFloors().intValue() > existingParkingLot.getFloors().intValue()) {
                throw new IllegalArgumentException("Used floors cannot be greater than total floors");
            }
            existingParkingLot.setUsedFloors(parkingLotDTO.getUsedFloors());
        }

        existingParkingLot.setUpdatedAt(new Date());
        ParkingLotModel updatedParkingLot = parkingLotRepository.save(existingParkingLot);
        return parkingLotMapper.toDTO(updatedParkingLot);
    }

    @Override
    public void deleteParkingLot(Long id) {
        if (!parkingLotRepository.existsById(id)) {
            throw new RuntimeException("Parking lot not found with id: " + id);
        }
        parkingLotRepository.deleteById(id);
    }

    private void checkForDuplicateParkingLot(ParkingLotDTO parkingLotDTO) {
        List<ParkingLotModel> existingParkingLots = parkingLotRepository.findByNameAndAddressLine1AndCityAndState(
                parkingLotDTO.getName(),
                parkingLotDTO.getAddressLine1(),
                parkingLotDTO.getCity(),
                parkingLotDTO.getState()
        );

        if (!existingParkingLots.isEmpty()) {
            throw new IllegalArgumentException("A parking lot with the same name, address, city, and state already exists.");
        }
    }

    @Override
    public List<ParkingLotDTO> searchParkingLots(String search, Pageable pageable) {
        return parkingLotRepository.searchByFields(search, pageable).getContent().stream()
                .map(parkingLotMapper::toDTO)
                .collect(Collectors.toList());
    }

    private void validateParkingLotData(ParkingLotDTO parkingLotDTO) {
        validateName(parkingLotDTO.getName());
        validateAddress(parkingLotDTO.getAddressLine1());
        validateCityOrState(parkingLotDTO.getCity(), "City");
        validateCityOrState(parkingLotDTO.getState(), "State");

        if (parkingLotDTO.getFloors() != null && parkingLotDTO.getFloors().intValue() > MAX_FLOORS) {
            throw new IllegalArgumentException("Floors cannot exceed " + MAX_FLOORS);
        }

        if (parkingLotDTO.getUsedFloors() != null &&
                parkingLotDTO.getFloors() != null &&
                parkingLotDTO.getUsedFloors().intValue() > parkingLotDTO.getFloors().intValue()) {
            throw new IllegalArgumentException("Used floors cannot be greater than total floors");
        }
    }

    private void validateName(String name) {
        if (isBlank(name) || !Pattern.matches(NAME_REGEX, name)) {
            throw new IllegalArgumentException("Invalid name. Only A-Z, a-z, 0-9, -, _, / are allowed and it cannot be empty or consist only of whitespace.");
        }
    }

    private void validateAddress(String address) {
        if (isBlank(address) || !Pattern.matches(ADDRESS_REGEX, address)) {
            throw new IllegalArgumentException("Invalid address. Only A-Z, a-z, 0-9, -, _, \\, / are allowed and it cannot be empty or consist only of whitespace.");
        }
    }

    private void validateCityOrState(String value, String fieldName) {
        if (isBlank(value) || !Pattern.matches(CITY_STATE_REGEX, value)) {
            throw new IllegalArgumentException(fieldName + " must contain only letters and cannot be empty or consist only of whitespace.");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
