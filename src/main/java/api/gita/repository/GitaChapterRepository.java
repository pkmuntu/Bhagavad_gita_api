package api.gita.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import api.gita.entity.GitaChapter;

public interface GitaChapterRepository extends MongoRepository<GitaChapter, String> {

	Page<GitaChapter> findByBookId(Integer bookId, Pageable pageable);

	Optional<GitaChapter> findByBookIdAndChapterIndex(Integer bookId, Integer chapterIndex);

}
