package com.digitalinnovationone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalinnovationone.domain.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>, EmpresaRepositoryQueries {
	
	Empresa findByCnpj(@Param("cnpj") String cnpj);

}
