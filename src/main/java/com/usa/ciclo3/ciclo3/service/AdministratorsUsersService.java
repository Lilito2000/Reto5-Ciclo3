package com.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.ciclo3.model.AdministratorsUsers;
import com.usa.ciclo3.ciclo3.repository.AdministratorsUsersRepository;

@Service
public class AdministratorsUsersService {

	@Autowired
	private AdministratorsUsersRepository administratorsUsersRepository;

	public List<AdministratorsUsers> getAll() {

		return administratorsUsersRepository.getAll();
	}

	public Optional<AdministratorsUsers> getAdministratorUser(int id) {
		return administratorsUsersRepository.getAdministratorUser(id);
	}

	public AdministratorsUsers save(AdministratorsUsers admin) {
		if (admin.getIdAdminUser() == null) {
			return administratorsUsersRepository.save(admin);
		} else {
			Optional<AdministratorsUsers> auxOptional = administratorsUsersRepository
					.getAdministratorUser(admin.getIdAdminUser());
			if (auxOptional.isEmpty()) {
				return administratorsUsersRepository.save(admin);
			} else {
				return admin;
			}

		}
	}

	public AdministratorsUsers update(AdministratorsUsers admin){
        if(admin.getIdAdminUser()!=null){
            Optional<AdministratorsUsers> adminEjemplo=administratorsUsersRepository.getAdministratorUser(admin.getIdAdminUser());
            if(!adminEjemplo.isEmpty()){
                if(admin.getUserName()!=null){
                    adminEjemplo.get().setUserName(admin.getUserName());
                }
                if(admin.getUserPassword()!=null){
                    adminEjemplo.get().setUserPassword(admin.getUserPassword());
                }
                if(admin.getUserMail()!=null){
                    adminEjemplo.get().setUserMail(admin.getUserMail());
                }
                administratorsUsersRepository.save(adminEjemplo.get());
                return adminEjemplo.get();
            }
            else{
                return admin;
            }
        }
        else{
            return admin;
        }
    }

	 public boolean deleteAdmin(int id){
	        Boolean aBoolean = getAdministratorUser(id).map(admin -> {
	        	administratorsUsersRepository.delete(admin);
	            return true;
	        }).orElse(false);
	        return aBoolean;
	    }
}
