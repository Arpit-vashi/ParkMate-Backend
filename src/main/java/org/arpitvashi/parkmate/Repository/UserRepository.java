package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> getUserByUsername(String username);
    Optional<UserModel> getUserByEmail(String email);
    Optional<UserModel> getUserByMobileNo(Long mobileNo);

    boolean existsByEmail(String email);

    boolean existsByMobileNo(Long mobileNo);
}
