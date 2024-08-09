package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.LostAndFoundDTO;
import org.arpitvashi.parkmate.Mapper.LostAndFoundMapper;
import org.arpitvashi.parkmate.Model.LostAndFoundModel;
import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.arpitvashi.parkmate.Repository.LostAndFoundRepository;
import org.arpitvashi.parkmate.Repository.ParkingLotRepository;
import org.arpitvashi.parkmate.Service.LostAndFoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LostAndFoundServiceImpl implements LostAndFoundService {

    @Autowired
    private final LostAndFoundRepository lostAndFoundRepository;

    private final ParkingLotRepository parkingLotRepository;
    private final LostAndFoundMapper lostAndFoundMapper;

    @Autowired
    public LostAndFoundServiceImpl(LostAndFoundRepository lostAndFoundRepository, ParkingLotRepository parkingLotRepository, LostAndFoundMapper lostAndFoundMapper) {
        this.lostAndFoundRepository = lostAndFoundRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.lostAndFoundMapper = lostAndFoundMapper;
    }

    @Override
    public List<LostAndFoundDTO> getAllLostAndFounds() {
        List<LostAndFoundModel> lostAndFounds = lostAndFoundRepository.findAll();
        return lostAndFounds.stream()
                .map(lostAndFoundMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LostAndFoundDTO getLostAndFoundById(Long id) {
        LostAndFoundModel lostAndFounds = lostAndFoundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LostAndFound not found with id: " + id));
        return lostAndFoundMapper.toDTO(lostAndFounds);
    }

    @Override
    public LostAndFoundDTO createLostAndFound(LostAndFoundDTO lostAndFoundDTO) {
        if (lostAndFoundDTO.getParkingLot() == null) {
            throw new IllegalArgumentException("ParkingLot cannot be null");
        }

        ParkingLotModel parlingLot = parkingLotRepository.findById(lostAndFoundDTO.getParkingLot().getParkingLotId())
                .orElseThrow(() -> new RuntimeException("ParkingLot not found"));

        LostAndFoundModel lostAndFound = new LostAndFoundModel();
        lostAndFound.setDescription(lostAndFoundDTO.getDescription());
        lostAndFound.setFoundAt(lostAndFoundDTO.getFoundAt());
        lostAndFound.setClaimed(lostAndFoundDTO.getClaimed());
        lostAndFound.setParkingLot(parlingLot);
        lostAndFound.setCreatedAt(new Date());
        lostAndFound.setUpdatedAt(new Date());

        LostAndFoundModel savedLostAndFound = lostAndFoundRepository.save(lostAndFound);
        return lostAndFoundMapper.toDTO(savedLostAndFound);
    }

    @Override
    public LostAndFoundDTO updateLostAndFound(Long id, LostAndFoundDTO lostAndFoundDTO) {
        LostAndFoundModel existingLostAndFound = lostAndFoundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LostAndFound not found with id: " + id));
        if(lostAndFoundDTO.getDescription()!= null) {
            existingLostAndFound.setDescription(lostAndFoundDTO.getDescription());
        }
        if(lostAndFoundDTO.getFoundAt()!=null){
            existingLostAndFound.setFoundAt(lostAndFoundDTO.getFoundAt());
        }
        if(lostAndFoundDTO.getClaimed()!= null) {
            existingLostAndFound.setClaimed(lostAndFoundDTO.getClaimed());
        }
        if (lostAndFoundDTO.getParkingLot() != null) {
            ParkingLotModel parkingLot = parkingLotRepository.findById(lostAndFoundDTO.getParkingLot().getParkingLotId())
                    .orElseThrow(() -> new RuntimeException("ParkingLot not found"));
            existingLostAndFound.setParkingLot(parkingLot);
        }
        if(lostAndFoundDTO.getCreatedAt()!=null){
            existingLostAndFound.setCreatedAt(lostAndFoundDTO.getCreatedAt());
        }
        if(lostAndFoundDTO.getUpdatedAt()!=null){
            existingLostAndFound.setUpdatedAt(lostAndFoundDTO.getUpdatedAt());
        }

        existingLostAndFound.setUpdatedAt(new Date());
        LostAndFoundModel updatedLostAndFound = lostAndFoundRepository.save(existingLostAndFound);
        return lostAndFoundMapper.toDTO(updatedLostAndFound);
    }

    @Override
    public void deleteLostAndFound(Long id) {
        if (!lostAndFoundRepository.existsById(id)) {
            throw new RuntimeException("LostAndFound not found with id: " + id);
        }
        lostAndFoundRepository.deleteById(id);
    }

}
