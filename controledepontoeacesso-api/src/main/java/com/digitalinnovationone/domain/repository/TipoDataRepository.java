package com.digitalinnovationone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalinnovationone.domain.model.TipoData;

@Repository
public interface TipoDataRepository extends JpaRepository<TipoData, Long> {
	
}
