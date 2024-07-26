package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.GateDTO;

import java.util.List;

public interface GateService {

    GateDTO createGate(GateDTO gateDTO);

    List<GateDTO> getAllGates();

   GateDTO getGateById(Long id);

    GateDTO updateGate(Long id, GateDTO gateDTO);

    void deleteGate(Long id);

}
