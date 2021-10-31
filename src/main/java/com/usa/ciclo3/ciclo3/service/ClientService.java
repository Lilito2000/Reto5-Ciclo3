package com.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAll() {
		return clientRepository.getAll();
	}

	public Optional<Client> getClient(int id) {
		return clientRepository.getClient(id);
	}

	public Client save(Client client) {
		if (client.getIdClient() == null) {
			return clientRepository.save(client);
		} else {
			Optional<Client> clientAux = clientRepository.getClient(client.getIdClient());
			if (clientAux.isEmpty()) {
				return clientRepository.save(client);
			} else {
				return client;
			}
		}
	}

	public Client update(Client client) {
		if (client.getIdClient() != null) {
			Optional<Client> clientEjemplo = clientRepository.getClient(client.getIdClient());
			if (!clientEjemplo.isEmpty()) {
				if (client.getName() != null) {
					clientEjemplo.get().setName(client.getName());
				}
				if (client.getEmail() != null) {
					clientEjemplo.get().setEmail(client.getEmail());
				}
				if (client.getAge() != null) {
					clientEjemplo.get().setAge(client.getAge());
				}
				if (client.getPassword() != null) {
					clientEjemplo.get().setPassword(client.getPassword());
				}
				clientRepository.save(clientEjemplo.get());
				return clientEjemplo.get();
			} else {
				return client;
			}
		} else {
			return client;
		}
	}

	public boolean deleteClient(int id){
        Boolean aBoolean = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
