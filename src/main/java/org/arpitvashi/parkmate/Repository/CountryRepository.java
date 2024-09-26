package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryModel, Long> {
}
