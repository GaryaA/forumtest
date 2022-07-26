package test.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import test.forum.entity.Vote;
import test.forum.entity.VoteId;
import test.forum.repo.VoteRepo;

import javax.validation.Valid;

@RestController
@RequestMapping("/votes")
public class VoteResource {

    @Autowired
    private VoteRepo voteRepo;

    @PostMapping
    public Vote create(@Valid @RequestBody Vote vote) {
        if (voteRepo.existsById(new VoteId(vote.getUserId(), vote.getQuoteId()))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vote already exists");
        }
        return voteRepo.save(vote);
    }

}
