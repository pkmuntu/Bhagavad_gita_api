package api.gita.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookChapterResponseDTO {

	private BookResponseDTO bookResponse;
	private MetadataForPagination metadataForPagination;
	private List<BookChapterDTO> chapters;

	public static BookChapterResponseDTO of(BookResponseDTO bookResponse, MetadataForPagination metadataForPagination,
			List<BookChapterDTO> chapters) {
		return new BookChapterResponseDTO(bookResponse, metadataForPagination, chapters);
	}
}
