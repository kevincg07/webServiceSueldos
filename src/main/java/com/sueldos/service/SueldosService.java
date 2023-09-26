package com.sueldos.service;

import java.util.List;

import com.persistence_escuela.entity.Sueldos;
import com.persistence_escuela.request.SueldosRequest;

public interface SueldosService {

	Sueldos guardar(SueldosRequest request);
	Sueldos actualizar(SueldosRequest request);
	Sueldos buscar(int id);
	List mostrar();
	String borrar(int id);
}
