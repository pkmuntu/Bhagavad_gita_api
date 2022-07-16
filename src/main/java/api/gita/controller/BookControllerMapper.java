package api.gita.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import api.gita.dto.response.BookChapterDTO;
import api.gita.dto.response.BookChapterResponseDTO;
import api.gita.dto.response.BookListResponseDTO;
import api.gita.dto.response.BookResponseDTO;
import api.gita.dto.response.MetadataForPagination;
import api.gita.entity.Book;
import api.gita.entity.GitaChapter;

@Component
public class BookControllerMapper {

	public List<BookListResponseDTO> buildBookListResponse(List<Book> books) {
		List<BookListResponseDTO> bookListResponses = new ArrayList<>();
		List<BookResponseDTO> bookResponses = new ArrayList<>();
		books.forEach(book -> {
			bookResponses.add(BookResponseDTO.of(book.getBookId(), book.getTitle(), book.getSubTitle(),
					book.getCoverImageUrl(), book.getLanguage(), book.getColorCode()));
		});
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		return bookListResponses;
	}

	public BookChapterResponseDTO buildBookChapterResponse(Page<GitaChapter> gitaChapters, Book book) {
		MetadataForPagination metadataForPagination = MetadataForPagination.of(gitaChapters.getNumber(),
				gitaChapters.getSize(), gitaChapters.getTotalElements(), gitaChapters.getTotalPages());
		List<BookChapterDTO> bookChapters = new ArrayList<>();
		gitaChapters.forEach(bookChapter -> {
			bookChapters.add(BookChapterDTO.of(bookChapter.getBookId(), bookChapter.getChapterIndex(),
					bookChapter.getChapterName(), bookChapter.getChapterHeading(), bookChapter.getDescription()));
		});
		return BookChapterResponseDTO.of(BookResponseDTO.of(book.getBookId(), book.getTitle(), book.getSubTitle(),
				book.getColorCode(), book.getLanguage(), book.getColorCode()), metadataForPagination, bookChapters);

	}

}
