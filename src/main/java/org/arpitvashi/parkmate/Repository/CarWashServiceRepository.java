package org.arpitvashi.parkmate.Repository;


import org.arpitvashi.parkmate.Model.CarWashServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarWashServiceRepository extends JpaRepository<CarWashServiceModel, Long> {
}
