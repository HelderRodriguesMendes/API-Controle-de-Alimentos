package br.com.testePratico.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testePratico.Exception.RegistroNaoEncontradoException;
import br.com.testePratico.convercoesDTO.CompraMapper;
import br.com.testePratico.convercoesDTO.ProdutoMapper;
import br.com.testePratico.model.Compra;
import br.com.testePratico.model.Produto;
import br.com.testePratico.modelDTO.CompraDTO;
import br.com.testePratico.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	CompraRepository compraRepository;
	
	@Autowired
	ProdutoService produtoService;
	
	
	CompraMapper compraMapper = new CompraMapper();
	ProdutoMapper produtoMapper = new ProdutoMapper();

	public Compra salvar(CompraDTO compraDTO) {
		
		Compra compra = compraMapper.toEntity(compraDTO);
		
		List<Produto> produtos = compra.getProdutos();

		Compra compraSalva = compraRepository.save(compra);
		
		for(Produto p : produtos) {
			p.setCompra(compraSalva);
			produtoService.salvar(p);
		}

		return compraSalva;
	}
	
	public List<Compra> buscarSupermercado(String nome){
		List<Compra> compras = compraRepository.findBySupermercado(nome);
		
		if(compras.isEmpty()) {
			throw new RegistroNaoEncontradoException("Compra não encontrada");
		}
		return compras;
	}
	
	public List<Compra> buscarDatacompra(LocalDate dataCompra){
		List<Compra> compras = compraRepository.findByDatacompra(dataCompra);
		
		if(compras.isEmpty()) {
			throw new RegistroNaoEncontradoException("Compra não encontrada");
		}
		return compras;
	}
}
