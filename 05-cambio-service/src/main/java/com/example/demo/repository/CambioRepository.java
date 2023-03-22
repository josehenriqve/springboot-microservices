package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {
	Cambio findByFromAndTo(String from, String to);
	//com isso já consegue gerar um sql fazendo um bind com a coloca from e to
}
