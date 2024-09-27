package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<CountryModel, Long> {
    Optional<CountryModel> findByName(String name);
}
