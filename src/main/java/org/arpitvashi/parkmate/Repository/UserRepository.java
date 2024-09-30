package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> getUserByUsername(String username);
    Optional<UserModel> getUserByEmail(String email);
    Optional<UserModel> getUserByMobileNo(String mobileNo);
    Optional<UserModel> getUserByName(String name);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByMobileNo(String mobileNo);

    Page<UserModel> findAll(Pageable pageable);

    @Query("SELECT u FROM UserModel u WHERE " +
            "LOWER(u.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.username) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.mobileNo) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<UserModel> searchUsers(@Param("searchTerm") String searchTerm, Pageable pageable);

    @Query("SELECT u FROM UserModel u WHERE " +
            "(LOWER(u.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.username) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.mobileNo) LIKE LOWER(CONCAT('%', :searchTerm, '%'))) " +
            "AND (:name IS NULL OR LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:username IS NULL OR LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%'))) " +
            "AND (:email IS NULL OR LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%'))) " +
            "AND (:mobileNo IS NULL OR LOWER(u.mobileNo) LIKE LOWER(CONCAT('%', :mobileNo, '%')))")
    Page<UserModel> searchWithFilters(@Param("searchTerm") String searchTerm,
                                      @Param("name") String name,
                                      @Param("username") String username,
                                      @Param("email") String email,
                                      @Param("mobileNo") String mobileNo,
                                      Pageable pageable);


    @Query("SELECT u FROM UserModel u WHERE " +
            "(:name IS NULL OR LOWER(u.name) LIKE LOWER(CONCAT(:name, '%'))) AND " +
            "(:username IS NULL OR LOWER(u.username) LIKE LOWER(CONCAT(:username, '%'))) AND " +
            "(:email IS NULL OR LOWER(u.email) LIKE LOWER(CONCAT(:email, '%'))) AND " +
            "(:mobileNo IS NULL OR LOWER(u.mobileNo) LIKE LOWER(CONCAT(:mobileNo, '%')))")
    Page<UserModel> filterUsers(@Param("name") String name,
                                @Param("username") String username,
                                @Param("email") String email,
                                @Param("mobileNo") String mobileNo,
                                Pageable pageable);
}
