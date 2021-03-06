package com.castro.projetosweb.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.castro.projetosweb.domain.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	List<Pessoa> findByNome(String nome);
	List<Pessoa> findByNomeContaining(String nome);
	Optional<Pessoa> findByEmail(String email);

}
