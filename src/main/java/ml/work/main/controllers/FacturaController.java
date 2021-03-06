package ml.work.main.controllers;

import java.util.ArrayList; 

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ml.work.main.dtos.FacturaDTO;
import ml.work.main.service.FacturaService;

@Controller
@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(path = "api/v1/facturas")
public class FacturaController implements ObjectController<FacturaDTO> {

	private FacturaService facturaService;

	public FacturaController(FacturaService facturaService) {
		this.facturaService = facturaService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/")
	public ArrayList<FacturaDTO> getAll() {
		return ResponseEntity.status(200).body(facturaService.getAll()).getBody();
	}

	@Override
	@GetMapping(path = "/{id}")
	public FacturaDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(facturaService.getOne(id)).getBody();
	}

	@Override
	@PostMapping("/")
	public ResponseEntity save(@RequestBody FacturaDTO body) {
		FacturaDTO temp = facturaService.save(body);

		if (temp.getNumFactura() != 0) {
			return ResponseEntity.status(201).body(temp);
		} else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
	}
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity updateEntity(@RequestBody FacturaDTO t, @PathVariable int id) {
		return ResponseEntity.status(201).body(facturaService.update(t, id));
	}
	
	
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEntity(@PathVariable int id) {
		boolean det = facturaService.delete(id);

		if (det) {
			return ResponseEntity.status(204).body("'Message' : 'Successful Delete'");
		} else {
			return ResponseEntity.status(400).body("'Message' . 'Unsuccessful delete'");
		}
	}

}
