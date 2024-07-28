package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, Long> {
}

