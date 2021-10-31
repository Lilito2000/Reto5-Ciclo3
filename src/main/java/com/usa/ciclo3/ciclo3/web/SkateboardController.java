package com.usa.ciclo3.ciclo3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ciclo3.ciclo3.model.Skateboard;
import com.usa.ciclo3.ciclo3.service.SkateboardService;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class SkateboardController {

	@Autowired
	private SkateboardService skateboardService;

	@GetMapping("/all")
	public List<Skateboard> getSkateboards() {
		return skateboardService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Skateboard> getSkateboard(@PathVariable("id") int id) {
		return skateboardService.getSkateboard(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Skateboard saveSkateboard(@RequestBody Skateboard skate) {
		return skateboardService.save(skate);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Skateboard updateSkateboard(@RequestBody Skateboard skateboard) {
		return skateboardService.update(skateboard);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteSkateboard(@PathVariable("id") int skateId) {
		return skateboardService.deleteSkate(skateId);
	}
}
