package api.gita.service;

import java.util.List;

import api.gita.entity.Book;

public interface IBookService {

	public List<Book> getBooks() throws Exception;
	
	public Book saveBook(Book book) throws Exception;
}
