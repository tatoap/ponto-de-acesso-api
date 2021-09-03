package com.digitalinnovationone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalinnovationone.domain.model.NivelAcesso;

@Repository
public interface NivelAcessoRepository extends JpaRepository<NivelAcesso, Long> {

}
