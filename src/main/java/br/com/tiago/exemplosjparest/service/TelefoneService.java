package br.com.tiago.exemplosjparest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiago.exemplosjparest.model.Pessoa;
import br.com.tiago.exemplosjparest.model.Telefone;
import br.com.tiago.exemplosjparest.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	TelefoneRepository repository;

	@Autowired
	PessoaService service;

	public Telefone saveOrUpdate(Telefone telefone) {
		Pessoa pessoa = service.findById(telefone.getPessoa().getId());
		pessoa.getTelefone().add(telefone);
		System.out.println(pessoa.getNome());
		telefone.setPessoa(pessoa);

		return repository.save(telefone);
	}

	public Collection<Telefone> listAll() {
		return repository.findAll();
	}

	public Telefone findById(Long id) {
		return repository.getOne(id);
	}

	public void delete(Telefone telefone) {
		repository.delete(telefone);
	}

}
