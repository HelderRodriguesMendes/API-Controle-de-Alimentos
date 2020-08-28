package br.com.testePratico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		if(compraDTO.getProdutosDTO().isEmpty()) {
			System.out.println("nulo");
		}else {
			System.out.println("não nulo");
		}
		Compra compra = compraMapper.toEntity(compraDTO);
		
		List<Produto>produtos = compra.getProdutos();
		if(produtos.isEmpty()) {
			System.out.println("não pego");
		}else {
			System.out.println("pego");
		}
		
		Compra compraSalva = compraRepository.save(compra);
		
		/*List<Produto> produtosInvalidados = new ArrayList<>();
		
		for(int i = 0; i < compra.getProdutos().size(); i ++) {
			Produto p = (Produto) compra.getProdutos().get(i);
			produtosInvalidados.add(p);
		}

		if(produtosInvalidados.isEmpty()) {
			System.out.println("VAZIO");
		}else {
			System.out.println("NÃO VAZIO");
		}

		Compra compraSalva = compraRepository.save(compra);
		produtoService.salvarLista(compraSalva);
		
		List<Produto> produtosSalvos = new ArrayList<>();
		
		for(Produto p : produtosInvalidados) {
			System.out.println("NOME: " + p.getNome());
			p.setCompra(compraSalva);
			ProdutoDTO produtoDtoInvalidado = produtoMapper.toDTO(p);
			Produto produtoSalvo = produtoService.salvar(produtoDtoInvalidado);
			produtosSalvos.add(produtoSalvo);
		}
		compraSalva.setProdutos(produtosSalvos);*/
		
		return compraSalva;
	}
}
