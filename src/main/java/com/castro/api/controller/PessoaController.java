package com.castro.api.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.castro.api.domain.model.Pessoa;
import com.castro.api.domain.repository.PessoaRepository;
import com.castro.api.domain.service.PessoaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {


	private PessoaRepository pessoaRepository;
	private PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> buscar(@PathVariable Long pessoaId) {
		return pessoaRepository.findById(pessoaId)
				.map(ResponseEntity::ok) 
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa adicionar(@Valid @RequestBody Pessoa pessoa) {
		return pessoaService.salvar(pessoa);
	}

	@PutMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long pessoaId, @Valid @RequestBody Pessoa pessoa){
		if(!pessoaRepository.existsById(pessoaId)) {
			return ResponseEntity.notFound().build();
		}

		pessoa.setId(pessoaId);
		pessoa = pessoaService.salvar(pessoa);

		return ResponseEntity.ok(pessoa);
	}

	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<Void> remover(@PathVariable Long pessoaId) {
		if(!pessoaRepository.existsById(pessoaId)) {
			return ResponseEntity.notFound().build();
		}
		pessoaService.remover(pessoaId);

		return ResponseEntity.noContent().build();
	}

}
