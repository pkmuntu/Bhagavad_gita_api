package api.gita.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import api.gita.entity.GitaChapterEnglish;

public interface GitaChapterEnglishRepository extends MongoRepository<GitaChapterEnglish, String> {

}
