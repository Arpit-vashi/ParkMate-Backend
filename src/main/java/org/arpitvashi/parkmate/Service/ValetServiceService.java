package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.ValetServiceDTO;

import java.util.List;

public interface ValetServiceService {

    ValetServiceDTO createValetService(ValetServiceDTO valetService);

    List<ValetServiceDTO> getAllValetServices();

    ValetServiceDTO getValetServiceById(Long id);

    ValetServiceDTO updateValetService(Long id, ValetServiceDTO valetServiceDTO);

    void deleteValetService(Long id);

}
