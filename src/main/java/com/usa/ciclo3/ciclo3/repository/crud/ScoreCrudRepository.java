package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreCrudRepository extends JpaRepository<Score, Integer> {
}