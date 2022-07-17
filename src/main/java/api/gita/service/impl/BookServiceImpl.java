package api.gita.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import api.gita.commons.Constants;
import api.gita.entity.Book;
import api.gita.entity.GitaChapter;
import api.gita.exception.NotFoundException;
import api.gita.repository.BookRepository;
import api.gita.repository.GitaChapterRepository;
import api.gita.service.IBookService;

@Service("book")
public class BookServiceImpl implements IBookService {

	private final BookRepository bookRepository;
	private final GitaChapterRepository gitaChapterRepository;

	public BookServiceImpl(BookRepository bookRepository, GitaChapterRepository gitaChapterRepository) {
		this.bookRepository = bookRepository;
		this.gitaChapterRepository = gitaChapterRepository;
	}

	@Override
	public List<Book> getBooks() throws Exception {
		return bookRepository.findAll();
	}

	@Override
	public Book getBook(Integer id) throws Exception {
		Optional<Book> optBook = bookRepository.findByBookId(id);
		if (optBook.isPresent()) {
			return optBook.get();
		}
		throw new NotFoundException(Constants.BOOK_NOT_FOUND);
	}

	@Override
	public Book saveBook(Book book) throws Exception {
		return bookRepository.save(book);
	}

	@Override
	public Page<GitaChapter> getChapters(Integer bookId, Integer pageNumber, Integer pageSize) throws Exception {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Constants.CHAPTER_INDEX).ascending());
		return gitaChapterRepository.findByBookId(bookId, pageable);
	}

	@Override
	public GitaChapter getChapterByBookId(Integer bookId,Integer chapterIndex) throws Exception {
		Optional<GitaChapter> optChapter=gitaChapterRepository.findByBookIdAndChapterIndex(bookId,chapterIndex);
		if(optChapter.isPresent()) {
			return optChapter.get();
		}
		throw new NotFoundException(Constants.BOOK_NOT_FOUND);
	}

}
