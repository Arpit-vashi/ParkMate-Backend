package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> getUserByUsername(String username);
    Optional<UserModel> getUserByEmail(String email);
    Optional<UserModel> getUserByMobileNo(String mobileNo); // Updated to String
    Optional<UserModel> getUserByName(String name);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByMobileNo(String mobileNo); // Updated to String

    Page<UserModel> findAll(Pageable pageable);
}
