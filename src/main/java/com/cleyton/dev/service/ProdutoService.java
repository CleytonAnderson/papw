package com.cleyton.dev.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.cleyton.dev.domain.Produto;
import com.cleyton.dev.repositoy.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto save(Produto produto){
		return produtoRepository.save(produto);
	}

	public Produto findById(Long id){
		return produtoRepository
				.findById(id)
				.orElseThrow(NoSuchElementException::new);
	}

	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}

	public Produto update(Produto produto) {
		if(produto.getId()==null) {
			throw new NoSuchFieldError("ID nao Encontrado");
		}
		return produtoRepository.save(produto);
	}

	public void deleteById(Long id) {
		produtoRepository.deleteById(id);
	}

}
