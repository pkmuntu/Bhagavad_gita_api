package api.gita.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookListResponseDTO {

	private String title;
	private List<BookResponseDTO> books;

	public static BookListResponseDTO of(List<BookResponseDTO> books) {
		return new BookListResponseDTO("Devotional", books);
	}

}
