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

import br.com.tiago.exemplosjparest.model.Telefone;
import br.com.tiago.exemplosjparest.service.TelefoneService;

@RestController
@RequestMapping(value = "/telefone")
public class TelefoneController {

	@Autowired
	TelefoneService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Telefone>> listaTelefones() {
		return new ResponseEntity<Collection<Telefone>>(service.listAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Telefone> salvaOuAtualizaTelefone(@RequestBody Telefone telefone) {
		return new ResponseEntity<Telefone>(service.saveOrUpdate(telefone), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Telefone> removeTelefone(@PathVariable Long id) {
		service.delete(service.findById(id));
		return new ResponseEntity<Telefone>(HttpStatus.OK);
	}

}
