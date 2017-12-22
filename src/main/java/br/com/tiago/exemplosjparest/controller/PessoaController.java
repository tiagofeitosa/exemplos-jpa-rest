package br.com.tiago.exemplosjparest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.exemplosjparest.model.Pessoa;
import br.com.tiago.exemplosjparest.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	PessoaService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Pessoa>> listaPessoas() {
		return new ResponseEntity<Collection<Pessoa>>(service.listAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> salvaOuAtualizaPessoa(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<Pessoa>(service.saveOrUpdate(pessoa), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pessoa> removePessoa(@PathVariable Long id) {
		service.delete(service.findById(id));
		return new ResponseEntity<Pessoa>(HttpStatus.OK);
	}

}
