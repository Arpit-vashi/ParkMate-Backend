package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.EntityGraph;
import java.util.List;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLotModel, Long> {
    @EntityGraph(attributePaths = {"owners"})
    @Query(value = "SELECT p FROM ParkingLotModel p " +
            "WHERE (LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(p.city) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(p.state) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR CAST(p.capacity AS text) LIKE LOWER(CONCAT('%', :search, '%')))", nativeQuery = true)
    Page<ParkingLotModel> searchByFields(String search, Pageable pageable);
    List<ParkingLotModel> findByNameAndAddressLine1AndCityAndState(String name, String addressLine1, String city, String state);

}
