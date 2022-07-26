package test.forum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.forum.entity.QuoteEntity;

import java.util.UUID;

@Repository
public interface QuoteRepo extends JpaRepository<QuoteEntity, UUID> {



}
