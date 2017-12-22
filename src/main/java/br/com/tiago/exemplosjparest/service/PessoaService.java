package br.com.tiago.exemplosjparest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiago.exemplosjparest.model.Pessoa;
import br.com.tiago.exemplosjparest.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repository;

	public Pessoa saveOrUpdate(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public Collection<Pessoa> listAll() {
		return repository.findAll();
	}

	public Pessoa findById(Long id) {
		return repository.getOne(id);
	}

	public void delete(Pessoa pessoa) {
		repository.delete(pessoa);
	}
}
