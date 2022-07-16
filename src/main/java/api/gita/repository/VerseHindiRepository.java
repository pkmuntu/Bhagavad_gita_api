package api.gita.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import api.gita.entity.VerseHindi;

public interface VerseHindiRepository extends MongoRepository<VerseHindi, String>  {

}
