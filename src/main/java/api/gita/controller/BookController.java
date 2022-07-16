package api.gita.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.gita.commons.Constraints;
import api.gita.dto.response.BookListResponse;
import api.gita.entity.Book;
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
	public RestResponse<List<BookListResponse>> getBooks() throws Exception {
		List<Book> books = bookService.getBooks();
		List<BookListResponse> response = bookContollerMapper.buildBookListResponse(books);
		System.out.println("---------");
		return RestResponse.of(response, Constraints.GET_BOOK_LIST, RestAPICode.OK_STATUS_CODE);
		
	}

	@PostMapping("/save")
	@ResponseStatus(value = HttpStatus.CREATED)
	public RestResponse<Book> saveBook(@RequestBody(required = true) Book book) throws Exception {
		book = bookService.saveBook(book);
		System.out.println("--------");
		return RestResponse.of(book, Constraints.SAVE_BOOK, RestAPICode.CREATED_STATUS_CODE);
	}

}
