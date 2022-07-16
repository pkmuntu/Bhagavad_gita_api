package api.gita.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import api.gita.entity.Book;

public interface BookRepository extends MongoRepository<Book, String> {

	Optional<Book> findByBookId(Integer id);

}
