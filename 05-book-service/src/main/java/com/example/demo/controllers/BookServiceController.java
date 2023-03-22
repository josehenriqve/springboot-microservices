package com.example.demo.controllers;




import com.example.demo.proxy.CambioProxy;
import com.example.demo.repository.BookRepository;
import com.example.demo.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("book-service")
public class BookServiceController {

	@Autowired
	private Environment environment;

	@Autowired
	private CambioProxy proxy;
	@Autowired
	private BookRepository repository;
	

	@GetMapping(value="/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		
		var book = repository.getById(id);



		if (book == null) throw new RuntimeException("Book not found");



	var cambio = proxy.getCambio(book.getPrice(),"USD",currency);

		var port = environment.getProperty("local.server.port");
		book.setPrice(cambio.getConvertedValue());
		book.setEnvironment(port +"Feign");
		return book;
	}
}
/*
	@GetMapping(value="/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

		var book = repository.getById(id);
		HashMap<String,String> paramns = new HashMap<>();


		if (book == null) throw new RuntimeException("Book not found");
		paramns.put("amount",book.getPrice().toString());
		paramns.put("from","USD");
		paramns.put("to",currency);

		var response = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
				Cambio.class,paramns);

		var cambio = response.getBody();

		var port = environment.getProperty("local.server.port");
		book.setPrice(cambio.getConvertedValue());
		book.setEnvironment(port);
		return book;
	}*/
