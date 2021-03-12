package com.brqapirest.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brqapirest.domain.entidade.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByCpf (String cpf);
	List<Cliente> findByNomeContaining(String nome);	

}