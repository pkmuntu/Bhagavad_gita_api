package api.gita.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterResponseDTO {

	private BookResponseDTO bookResponse;
	private MetadataForPagination metadataForPagination;
	private List<ChapterDTO> chapters;

	public static ChapterResponseDTO of(BookResponseDTO bookResponse, MetadataForPagination metadataForPagination,
			List<ChapterDTO> chapters) {
		return new ChapterResponseDTO(bookResponse, metadataForPagination, chapters);
	}
}
