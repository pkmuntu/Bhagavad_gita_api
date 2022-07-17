package api.gita.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import api.gita.entity.Verse;

public interface VerseRepository extends MongoRepository<Verse, String> {

}
