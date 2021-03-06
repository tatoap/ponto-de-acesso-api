package com.digitalinnovationone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalinnovationone.domain.model.Calendario;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {

}
