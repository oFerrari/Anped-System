package br.com.anpede.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anpede.dto.EquipamentoItemDTO;
import br.com.anpede.services.EquipamentoItemService;

@RestController
@RequestMapping(value = "/equipamentosItem")
public class EquipamentoItemResource {
	
	@Autowired
	private EquipamentoItemService service;
	
	@GetMapping
	public ResponseEntity<List<EquipamentoItemDTO>> findAll() {
		List<EquipamentoItemDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
/*
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<EquipamentoItemDTO> findById(@PathVariable Long id){	
		EquipamentoItemDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<EquipamentoItemDTO> insert(@RequestBody EquipamentoItemDTO dto){	
		service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(null);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipamentoItemDTO> update(@PathVariable Long id, @RequestBody EquipamentoItemDTO dto){ 
	dto = service.update(id, dto);
	return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	*/
}
