package com.project.Monthly.Challenge.App;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;


@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins="http://localhost:3000")
public class ChallengeController {
    private ChallengeService challengeService ;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping()
    public ResponseEntity<List<Challenge>> getAllChallenges(){
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK) ;
    }

    @PostMapping()
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
       boolean addition= challengeService.addChallenge(challenge);
       if(addition){
           return new ResponseEntity<>("challenge added successfully!",HttpStatus.OK) ;
       }
        return new ResponseEntity<>("challenge is empty",HttpStatus.BAD_REQUEST) ;
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
        Challenge temp= challengeService.getChallenge(month) ;
        if(temp!=null){
            return new ResponseEntity<>(temp,HttpStatus.OK) ;
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge challenge){
        boolean update=challengeService.updateChallenge(id,challenge) ;
        if(update){
            return new ResponseEntity<>("challenge updated successfully",HttpStatus.OK) ;
        }
        return new ResponseEntity<>("challenge not found",HttpStatus.NOT_FOUND) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean delete=challengeService.deleteChallenge(id) ;
        if(delete){
            return new ResponseEntity<>("challenge deleted successfully",HttpStatus.OK) ;
        }
        return new ResponseEntity<>("challenge not found",HttpStatus.NOT_FOUND) ;
    }


}
