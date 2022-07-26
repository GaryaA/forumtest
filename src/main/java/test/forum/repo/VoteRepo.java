package test.forum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.forum.entity.Vote;
import test.forum.entity.VoteId;

@Repository
public interface VoteRepo extends JpaRepository<Vote, VoteId> {

}
