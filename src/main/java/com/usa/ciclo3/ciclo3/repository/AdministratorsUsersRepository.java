package com.usa.ciclo3.ciclo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.ciclo3.model.AdministratorsUsers;
import com.usa.ciclo3.ciclo3.repository.crud.AdministratorsUsersCrudRepository;

@Repository
public class AdministratorsUsersRepository {

	@Autowired
	private AdministratorsUsersCrudRepository administratorsUsersCrudRepository;

	public List<AdministratorsUsers> getAll() {

		return (List<AdministratorsUsers>) administratorsUsersCrudRepository.findAll();
	}

	public Optional<AdministratorsUsers> getAdministratorUser(int id) {

		return administratorsUsersCrudRepository.findById(id);
	}

	public AdministratorsUsers save(AdministratorsUsers r) {
		return administratorsUsersCrudRepository.save(r);
	}

	public void delete(AdministratorsUsers admin) {
		administratorsUsersCrudRepository.delete(admin);

	}

}
