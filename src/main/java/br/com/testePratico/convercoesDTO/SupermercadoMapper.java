package br.com.testePratico.convercoesDTO;

import org.modelmapper.ModelMapper;

import br.com.testePratico.model.Supermercado;
import br.com.testePratico.modelDTO.SupermercadoDTO;

public class SupermercadoMapper {

	ModelMapper mapper = new ModelMapper();

	public SupermercadoDTO toDTO(Supermercado supermacado) {
		return mapper.map(supermacado, SupermercadoDTO.class);
	}

	public Supermercado toEntity(SupermercadoDTO supermecadoDTO) {
		return mapper.map(supermecadoDTO, Supermercado.class);
	}
}
