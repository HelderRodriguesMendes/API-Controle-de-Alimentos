package br.com.testePratico.convercoesDTO;

import org.modelmapper.ModelMapper;

import br.com.testePratico.model.Compra;
import br.com.testePratico.modelDTO.CompraDTO;

public class CompraMapper {
	ModelMapper mapper = new ModelMapper();

	public CompraDTO toDTO(Compra compra) {
		return mapper.map(compra, CompraDTO.class);
	}

	public Compra toEntity(CompraDTO compraDTO) {
		return mapper.map(compraDTO, Compra.class);
	}
}
