package br.com.anpede.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anpede.dto.EquipamentoDTO;
import br.com.anpede.services.EquipamentoService;

@RestController
@RequestMapping(value = "/equipamentos")
public class EquipamentoResource {
	
	@Autowired
	private EquipamentoService service;
	
	@GetMapping
	public ResponseEntity<List<EquipamentoDTO>> findAll() {
		List<EquipamentoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
/*
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<EquipamentoDTO> findById(@PathVariable Long id){	
		EquipamentoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<EquipamentoDTO> insert(@RequestBody EquipamentoDTO dto){	
		service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(null);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EquipamentoDTO> update(@PathVariable Long id, @RequestBody EquipamentoDTO dto){ 
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
