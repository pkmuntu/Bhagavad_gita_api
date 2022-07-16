package api.gita.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import api.gita.entity.VerseEnglish;

public interface VerseEnglishRepository extends MongoRepository<VerseEnglish, String> {

}
