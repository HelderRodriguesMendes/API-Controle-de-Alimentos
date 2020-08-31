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

	public Compra salvar(CompraDTO compraDTO, String status) { // SALVA E ALTERA COMPRA - E SALVA PRODUTOS

		Compra compra = compraMapper.toEntity(compraDTO);

		List<Produto> produtos = compra.getProdutos(); // SEPARA OS PRODUTOS PARA SALVAR UM A UM COM A FK
		Compra compraSalva = compraRepository.save(compra);

		if (status.equals("salvar")) {
			for (Produto p : produtos) {
				p.setCompra(compraSalva);
				produtoService.salvar(produtoMapper.toDTO(p));
			}
		}

		return compraSalva;
	}

	public List<Compra> buscarCompra(Long id) { // BUSCA POR ID DE TODAS AS COMPRAS DISPONIVEIS
		List<Compra> compras = compraRepository.buscarCompra(id);
		if (compras.isEmpty()) {
			throw new RegistroNaoEncontradoException("Compra não encontrada");
		}
		return compras;
	}

	public List<Compra> buscarTodas() { // BUSCA TODAS AS COMPRAS DISPONIVEIS
		List<Compra> compras = compraRepository.comprasAtivas();
		if (compras.isEmpty()) {
			throw new RegistroNaoEncontradoException("Compra não encontrada");
		}
		return compras;
	}

	public List<Compra> buscarSupermercado(String nome) { // BUSCA POR SUPERMERCADO DE TODAS AS COMPRAS DISPONIVEIS
		List<Compra> compras = compraRepository.findBySupermercado(nome);

		if (compras.isEmpty()) {
			throw new RegistroNaoEncontradoException("Compra não encontrada");
		}
		return compras;
	}

	public List<Compra> buscarDatacompra(LocalDate dataCompra) { // BUSCA POR DATA DA COMPRA DE TODAS AS COMPRAS
																	// DISPONIVEIS
		List<Compra> compras = compraRepository.findByDatacompra(dataCompra);

		if (compras.isEmpty()) {
			throw new RegistroNaoEncontradoException("Compra não encontrada");
		}
		return compras;
	}

	public List<Compra> desabilitar(Long id) { // DESABILITA COMPRA
		Compra compra = compraRepository.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontradoException("Compra não encontrada"));
		List<Produto> produtos = compra.getProdutos();
		for (Produto p : produtos) {
			produtoService.desabilitar(p.getId());
		}
		compraRepository.desabilitarProduto(id);

		return buscarTodas();
	}
}
