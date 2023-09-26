package com.sueldos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistence_escuela.entity.Sueldos;
import com.persistence_escuela.repository.SueldosRepository;
import com.persistence_escuela.request.SueldosRequest;
import com.sueldos.service.SueldosService;

@Service
public class SueldosImplement implements SueldosService{

	@Autowired
	SueldosRepository repo;

	@Override
	public Sueldos guardar(SueldosRequest request) {
		Sueldos s = new Sueldos();
		s.setProfesor(request.getProfesor());
		s.setFecha(request.getFecha());
		s.setMonto(request.getMonto());
		repo.save(s);
		return s;
	}

	@Override
	public Sueldos actualizar(SueldosRequest request) {
		Sueldos s = repo.findById(request.getIdPago()).get();
		s.setProfesor(request.getProfesor());
		s.setFecha(request.getFecha());
		s.setMonto(request.getMonto());
		repo.save(s);
		return s;
	}

	@Override
	public Sueldos buscar(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List mostrar() {
		
		return repo.findAll();
	}

	@Override
	public String borrar(int id) {
		repo.deleteById(id);
		return "Borrado";
	}
}
