package com.castro.projetosweb.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.castro.projetosweb.domain.exception.NegocioException;
import com.castro.projetosweb.domain.model.Pessoa;
import com.castro.projetosweb.domain.repository.PessoaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PessoaService {
	private PessoaRepository pessoaRepository;

	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		
		boolean emailEmUso = pessoaRepository.findByEmail(pessoa.getEmail()) 
				.stream() 
				.anyMatch(pessoaExistente -> !pessoaExistente.equals(pessoa));

		if(emailEmUso) {
			throw new NegocioException("Já existe uma pessoa cadastrada com esse e-mail.");
		}
		
		return pessoaRepository.save(pessoa);
	}

	@Transactional
	public void remover(long pessoaId) {
		pessoaRepository.deleteById(pessoaId);
	}
}
