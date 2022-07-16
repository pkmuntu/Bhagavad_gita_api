package api.gita.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import api.gita.entity.Book;
import api.gita.repository.BookRepository;
import api.gita.service.IBookService;

@Service("book")
public class BookServiceImpl implements IBookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getBooks() throws Exception {
		return bookRepository.findAll();
	}

	@Override
	public Book saveBook(Book book) throws Exception {
		return bookRepository.save(book);
	}

}
