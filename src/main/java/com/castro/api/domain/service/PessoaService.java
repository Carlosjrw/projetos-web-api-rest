package com.castro.api.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.castro.api.domain.model.Pessoa;
import com.castro.api.domain.repository.PessoaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PessoaService {
	private PessoaRepository pessoaRepository;

	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Transactional
	public void remover(long pessoaId) {
		pessoaRepository.deleteById(pessoaId);
	}
}
