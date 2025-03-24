package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.LoyaltyProgramDTO;
import java.util.List;

public interface LoyaltyProgramService {

    LoyaltyProgramDTO createLoyaltyProgram(LoyaltyProgramDTO loyaltyProgram);

    List<LoyaltyProgramDTO> getAllLoyaltyPrograms();

   LoyaltyProgramDTO getLoyaltyProgramById(Long id);

    LoyaltyProgramDTO updateLoyaltyProgram(Long id, LoyaltyProgramDTO loyaltyProgramDTO);

    void deleteLoyaltyProgram(Long id);

}
