package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.usersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usersRepository extends JpaRepository<usersModel, Long> {
    Optional<usersModel> findByUsername(String username);
    Optional<usersModel> findByEmail(String email);
    Optional<usersModel> findByMobileNo(Long mobileno);
}
