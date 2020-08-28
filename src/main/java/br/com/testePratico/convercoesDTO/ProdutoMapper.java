package br.com.testePratico.convercoesDTO;

import org.modelmapper.ModelMapper;

import br.com.testePratico.model.Produto;
import br.com.testePratico.modelDTO.ProdutoDTO;

public class ProdutoMapper {
	
	ModelMapper mapper = new ModelMapper();

	public ProdutoDTO toDTO(Produto produto) {
		return mapper.map(produto, ProdutoDTO.class);
	}

	public Produto toEntity(ProdutoDTO produtoDTO) {
		return mapper.map(produtoDTO, Produto.class);
	}
}
