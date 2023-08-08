package br.com.anpede.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anpede.dto.AssociadoDTO;
import br.com.anpede.services.AssociadoService;

@RestController
@RequestMapping(value = "/associados")
public class AssociadoResource {
	
	@Autowired
	private AssociadoService service;
	
	@GetMapping
	public ResponseEntity<List<AssociadoDTO>> findAll() {
		List<AssociadoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<AssociadoDTO> findById(@PathVariable Long id){
		AssociadoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
