package com.cleyton.dev.web.rest;

import java.util.List;

import javax.validation.Valid;

import com.cleyton.dev.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cleyton.dev.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoRest {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/{id}/", method = RequestMethod.GET)
	public Produto getProdutoById(@PathVariable Long id) {
		return produtoService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Produto> getProdutos() {
		return produtoService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Produto save(@RequestBody @Valid Produto produto) {
		return produtoService.save(produto);
	}
	//
	@RequestMapping(method = RequestMethod.PUT)
	public Produto update(@PathVariable @Valid Produto produto) {
		return produtoService.save(produto);
	}

	@RequestMapping(value = "/{id}/", method = RequestMethod.DELETE)
	public ResponseEntity deleteById(@PathVariable Long id) {
		produtoService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
