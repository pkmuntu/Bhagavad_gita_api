package api.gita.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import api.gita.entity.Verse;

public interface VerseRepository extends MongoRepository<Verse, String> {

	Optional<Verse> findByBookIdAndChapterIndexAndVerseNumber(Integer bookId, Integer chapterIndex, String verseNumber);

}
