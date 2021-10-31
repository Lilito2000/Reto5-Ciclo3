package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientCrudRepository extends JpaRepository<Client, Integer> {
}