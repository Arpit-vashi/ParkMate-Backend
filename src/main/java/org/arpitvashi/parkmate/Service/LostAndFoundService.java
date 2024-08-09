package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.LostAndFoundDTO;

import java.util.List;

public interface LostAndFoundService {

    LostAndFoundDTO createLostAndFound(LostAndFoundDTO lostAndFoundDTO);

    List<LostAndFoundDTO> getAllLostAndFounds();

    LostAndFoundDTO getLostAndFoundById(Long id);

    LostAndFoundDTO updateLostAndFound(Long id, LostAndFoundDTO lostAndFoundDTO);

    void deleteLostAndFound(Long id);

}
