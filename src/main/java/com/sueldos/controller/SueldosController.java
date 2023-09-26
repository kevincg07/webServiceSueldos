package com.sueldos.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistence_escuela.entity.Sueldos;
import com.persistence_escuela.request.SueldosRequest;
import com.sueldos.impl.SueldosImplement;

@RestController
@RequestMapping("sueldos/")
public class SueldosController {

	@Autowired
	SueldosImplement logic;
	
	@PostMapping
	ResponseEntity<Sueldos> guardar(@RequestBody SueldosRequest request){
		Sueldos s = logic.guardar(request);
		return new ResponseEntity<Sueldos>(s, HttpStatus.OK);
	}
	
	@PutMapping
	ResponseEntity<Sueldos> actualizar(@RequestBody SueldosRequest request){
		Sueldos s = logic.actualizar(request);
		return new ResponseEntity<Sueldos>(s, HttpStatus.OK);
	}
	
	@GetMapping("buscar-por-id/{id}")
	ResponseEntity<Sueldos> buscar(@PathVariable("id")int id){
		Sueldos s = logic.buscar(id);
		return new ResponseEntity<Sueldos>(s, HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity<List<Sueldos>> mostrar(){
		List<Sueldos> sueldos = logic.mostrar();
		return new ResponseEntity<List<Sueldos>>(sueldos, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar-por-id/{id}")
	ResponseEntity<String> eliminar(@PathVariable("id")int id){
		String m = logic.borrar(id);
		return new ResponseEntity<String>(m, HttpStatus.OK);
	}
}
