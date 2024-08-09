package com.project.Monthly.Challenge.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {


    @Autowired
    ChallengeRepository challengeRepository ;

    public List<Challenge> getAllChallenges(){
        return challengeRepository.findAll() ;
    }

    public boolean addChallenge(Challenge challenge){
        if(challenge!=null){
            challengeRepository.save(challenge) ;
            return true ;
        }
        return false ;
    }

    public Challenge getChallenge(String month){
        Optional<Challenge> temp=challengeRepository.findByMonthIgnoreCase(month) ;

        return temp.orElse(null) ;
    }

    public boolean updateChallenge(Long id, Challenge challenge) {
        Optional<Challenge> challengeOptional=challengeRepository.findById(id) ;
        if (challengeOptional.isPresent()){
            Challenge temp=challengeOptional.get() ;

            temp.setDescription(challenge.getDescription());
            temp.setMonth(challenge.getMonth());
            challengeRepository.save(temp) ;
            return true ;
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        if(challengeRepository.findById(id).isEmpty())return false ;
        challengeRepository.deleteById(id);
        return true ;
    }
}
