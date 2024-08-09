package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.CarWashServiceDTO;
import java.util.List;

public interface CarWashServiceService {

    CarWashServiceDTO createCarWashService(CarWashServiceDTO carWashServiceDTO);

    List<CarWashServiceDTO> getAllCarWashServices();

    CarWashServiceDTO getCarWashServiceById(Long id);

    CarWashServiceDTO updateCarWashService(Long id, CarWashServiceDTO carWashServiceDTO);

    void deleteCarWashService(Long id);

}
