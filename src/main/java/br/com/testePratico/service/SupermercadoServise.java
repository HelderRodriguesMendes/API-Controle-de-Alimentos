package br.com.testePratico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.testePratico.Exception.RegistroNaoEncontradoException;
import br.com.testePratico.convercoesDTO.SupermercadoMapper;
import br.com.testePratico.model.Supermercado;
import br.com.testePratico.modelDTO.SupermercadoDTO;
import br.com.testePratico.repository.SupermecadoRepository;

@Service
public class SupermercadoServise {

	@Autowired
	SupermecadoRepository supermercadoRepository;

	SupermercadoMapper supermecadoMapper = new SupermercadoMapper();

	public Supermercado salvar(SupermercadoDTO supermercadoDTO) {
		Supermercado supermercado = supermecadoMapper.toEntity(supermercadoDTO);

		String ina = String.valueOf(supermercado.getInativo());

		if (ina.equals("")) {
			supermercado.setInativo(0);
		}

		return supermercado = supermercadoRepository.save(supermercado);
	}

	public List<Supermercado> listar() {
		List<Supermercado> supermercados = supermercadoRepository.findByInativo();
		return supermercados;
	}
	
	public List<Supermercado> listarNome(String nome) {
		List<Supermercado> supermercado = supermercadoRepository.findByNome(nome);
		if(supermercado == null) {
			throw new RegistroNaoEncontradoException("Supermercado não encontrado");
		}
		return supermercado;
	}

	@Transactional
	public List<Supermercado> desabilitar(Long id) {
		supermercadoRepository.desabilitarSupermercado(id);
		List<Supermercado> supermercados = supermercadoRepository.findByInativo();
		return supermercados;
	}

}
