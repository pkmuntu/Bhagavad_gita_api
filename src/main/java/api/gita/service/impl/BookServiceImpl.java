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
import api.gita.entity.Verse;
import api.gita.exception.NotFoundException;
import api.gita.repository.BookRepository;
import api.gita.repository.GitaChapterRepository;
import api.gita.repository.VerseRepository;
import api.gita.service.IBookService;

@Service("bookService")
public class BookServiceImpl implements IBookService {

	private final BookRepository bookRepository;
	private final GitaChapterRepository gitaChapterRepository;
	private final VerseRepository verseRepository;

	public BookServiceImpl(BookRepository bookRepository, GitaChapterRepository gitaChapterRepository,
			VerseRepository verseRepository) {
		this.bookRepository = bookRepository;
		this.gitaChapterRepository = gitaChapterRepository;
		this.verseRepository = verseRepository;
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
	public GitaChapter getChapterByBookId(Integer bookId, Integer chapterIndex) throws Exception {
		Optional<GitaChapter> optChapter = gitaChapterRepository.findByBookIdAndChapterIndex(bookId, chapterIndex);
		if (optChapter.isPresent()) {
			return optChapter.get();
		}
		throw new NotFoundException(Constants.SUBCHAPTER_NOT_FOUND);
	}

	@Override
	public Verse getVerse(Integer bookId, Integer chapterIndex, String verseNumber) throws Exception {
		Optional<Verse> optVerse = verseRepository.findByBookIdAndChapterIndexAndVerseNumber(bookId, chapterIndex,
				verseNumber);
		if (optVerse.isPresent()) {
			return optVerse.get();
		}
		throw new NotFoundException(Constants.VERSE_NOT_FOUND);
	}

}
