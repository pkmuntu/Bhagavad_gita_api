package api.gita.service;

import java.util.List;

import org.springframework.data.domain.Page;

import api.gita.entity.Book;
import api.gita.entity.GitaChapter;
import api.gita.entity.Verse;

public interface IBookService {

	public List<Book> getBooks() throws Exception;

	public Book saveBook(Book book) throws Exception;

	public Book getBook(Integer id) throws Exception;

	public Page<GitaChapter> getChapters(Integer bookId, Integer pageNumber, Integer pageSize) throws Exception;

	public GitaChapter getChapterByBookId(Integer bookId, Integer chapterIndex) throws Exception;

	public Verse getVerse(Integer bookId, Integer chapterIndex, String verseNumber) throws Exception;
}
