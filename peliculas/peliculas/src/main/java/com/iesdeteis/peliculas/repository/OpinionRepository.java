package com.iesdeteis.peliculas.repository;

import com.iesdeteis.peliculas.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
