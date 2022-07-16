package api.gita.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.gita.commons.Constants;
import api.gita.dto.response.BookChapterResponseDTO;
import api.gita.dto.response.BookListResponseDTO;
import api.gita.entity.Book;
import api.gita.entity.GitaChapter;
import api.gita.rest.response.RestAPICode;
import api.gita.rest.response.RestResponse;
import api.gita.service.IBookService;

@CrossOrigin("*")
@RequestMapping(value = "/api/books")
@RestController
public class BookController {

	private final IBookService bookService;
	private final BookControllerMapper bookContollerMapper;

	public BookController(IBookService bookService, BookControllerMapper bookContollerMapper) {
		this.bookService = bookService;
		this.bookContollerMapper = bookContollerMapper;
	}

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public RestResponse<List<BookListResponseDTO>> getBooks() throws Exception {
		List<Book> books = bookService.getBooks();
		List<BookListResponseDTO> response = bookContollerMapper.buildBookListResponse(books);
		System.out.println("---------");
		return RestResponse.of(response, Constants.GET_BOOK_LIST, RestAPICode.OK_STATUS_CODE);

	}

	@PostMapping("/save")
	@ResponseStatus(value = HttpStatus.CREATED)
	public RestResponse<Book> saveBook(@RequestBody(required = true) Book book) throws Exception {
		book = bookService.saveBook(book);
		System.out.println("--------");
		return RestResponse.of(book, Constants.SAVE_BOOK, RestAPICode.CREATED_STATUS_CODE);
	}

	@GetMapping("/chapter/{id}")
	public RestResponse<BookChapterResponseDTO> getChapterList(@PathVariable("id") Integer id,
			@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "18") Integer pageSize)
			throws Exception {
		Book books = bookService.getBook(id);
		Page<GitaChapter> gitaChapters = bookService.getChapters(id, pageNumber, pageSize);
		BookChapterResponseDTO bookChapterResponseDTO = bookContollerMapper.buildBookChapterResponse(gitaChapters,
				books);
		return RestResponse.of(bookChapterResponseDTO, Constants.BOOK_CHAPTER, RestAPICode.CREATED_STATUS_CODE);
	}

}
