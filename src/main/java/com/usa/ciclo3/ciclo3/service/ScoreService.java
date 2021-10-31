package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Score;
import com.usa.ciclo3.ciclo3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }
        else{
            Optional<Score> scoreAux=scoreRepository.getScore(score.getIdScore());
            if(scoreAux.isEmpty()){
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }

    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> scoreEjemplo=scoreRepository.getScore(score.getIdScore());
            if(!scoreEjemplo.isEmpty()){
                if(score.getMessageText()!=null){
                    scoreEjemplo.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    scoreEjemplo.get().setStars(score.getStars());
                }
                scoreRepository.save(scoreEjemplo.get());
                return scoreEjemplo.get();
            }
            else{
                return score;
            }
        }
        else{
            return score;
        }
    }

    public boolean deleteSkate(int id){
        Boolean aBoolean = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}