package com.briansdigital.p1TmocRunRanker.tmocker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TmockerRepo
        extends JpaRepository<Tmocker, Long> {

    @Query("SELECT s FROM Tmocker s WHERE s.email = ?1")
    Optional<Tmocker> findTmockerByEmail(String email);


}
