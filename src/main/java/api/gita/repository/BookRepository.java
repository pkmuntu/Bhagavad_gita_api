package api.gita.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import api.gita.entity.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
