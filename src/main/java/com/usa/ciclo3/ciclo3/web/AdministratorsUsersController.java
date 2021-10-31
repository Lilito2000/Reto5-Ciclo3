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

import com.usa.ciclo3.ciclo3.model.AdministratorsUsers;
import com.usa.ciclo3.ciclo3.service.AdministratorsUsersService;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class AdministratorsUsersController {

	@Autowired
	private AdministratorsUsersService administratorsUsersService;

	@GetMapping("/all")
	public List<AdministratorsUsers> getResrvations() {

		return administratorsUsersService.getAll();

	}

	@GetMapping("/{id}")
	public Optional<AdministratorsUsers> getResrvation(@PathVariable("id") int id) {

		return administratorsUsersService.getAdministratorUser(id);

	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public AdministratorsUsers save(@RequestBody AdministratorsUsers admin) {
		return administratorsUsersService.save(admin);
	}

	@PutMapping("/update")
	public AdministratorsUsers updateAdmin(@RequestBody AdministratorsUsers admin) {
		return administratorsUsersService.update(admin);
	}

	@DeleteMapping("/{id}")
	public boolean deleteAdmin(@PathVariable("id") int adminId) {
		return administratorsUsersService.deleteAdmin(adminId);
	}
}
