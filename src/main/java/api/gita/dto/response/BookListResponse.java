package api.gita.dto.response;

import java.util.List;

import api.gita.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookListResponse {

	private String title;
	private List<Book> books;

	public static BookListResponse of(List<Book> books) {
		return new BookListResponse("self-Heap", books);
	}

}
