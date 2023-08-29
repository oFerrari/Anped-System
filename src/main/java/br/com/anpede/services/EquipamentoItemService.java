package br.com.anpede.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.anpede.dto.EquipamentoItemDTO;
import br.com.anpede.entities.EquipamentoItem;
import br.com.anpede.repositories.EquipamentoItemRepository;

@Service
public class EquipamentoItemService {
	@Autowired
	private EquipamentoItemRepository repository;

	@Transactional(readOnly = true)
	public List<EquipamentoItemDTO> findAll() {
		List<EquipamentoItem> lista = repository.findAll();

		return lista.stream().map(x -> new EquipamentoItemDTO(x)).collect(Collectors.toList());
	}
	
/*
	@Transactional(readOnly = true)
	public EquipamentoItemDTO findById(Long id) {
		Optional<EquipamentoItem> obj = repository.findById(id);
		EquipamentoItem entity = obj
				.orElseThrow(() -> new ResourceNotFoundException("O registro solicitado não foi encontrado"));
		return new EquipamentoItemDTO(entity);
	}

	@Transactional
	public EquipamentoItemDTO insert(EquipamentoItemDTO dto) {
		EquipamentoItem entity = new EquipamentoItem();
		entity.setNome(dto.getNome());
		entity.setCPF(dto.getCPF());
		entity.setDataNascimento(dto.getDataNascimento());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
		entity.setEndereco(dto.getEndereco());

		entity = repository.save(entity);

		return new EquipamentoItemDTO(entity);
	}

	@Transactional
	public EquipamentoItemDTO update(Long id, EquipamentoItemDTO dto) {
		try {
			EquipamentoItem entity = repository.getReferenceById(id);
			entity.setNome(dto.getNome());
			entity.setCPF(dto.getCPF());
			entity.setDataNascimento(dto.getDataNascimento());
			entity.setTelefone(dto.getTelefone());
			entity.setEmail(dto.getEmail());
			entity.setEndereco(dto.getEndereco());

			entity = repository.save(entity);

			return new EquipamentoItemDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O recurso com o ID " + id + " não foi localizado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O recurso com o ID " + id + " não foi localizado");
		}
	}
	*/
}
