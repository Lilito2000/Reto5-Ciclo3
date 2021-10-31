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

import com.usa.ciclo3.ciclo3.model.Score;
import com.usa.ciclo3.ciclo3.service.ScoreService;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class ScoreController {

	@Autowired
	private ScoreService scoreService;

	@GetMapping("/all")
	public List<Score> getScores() {
		return scoreService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Score> getScore(@PathVariable("id") int id) {
		return scoreService.getScore(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Score saveScore(@RequestBody Score score) {
		return scoreService.save(score);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Score updateScore(@RequestBody Score score) {
		return scoreService.update(score);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteScore(@PathVariable("id") int scoreId) {
		return scoreService.deleteSkate(scoreId);
	}
}