package api.gita.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubChapterResponseDTO {

	private ChapterDTO bookChapterDTO;
	private MetadataForPagination metadataForPagination;
	private List<SubChapterDTO> subChapters;

	public static SubChapterResponseDTO of(ChapterDTO ChapterDTO, MetadataForPagination metadataForPagination,
			List<SubChapterDTO> subChapters) {
		return new SubChapterResponseDTO(ChapterDTO, metadataForPagination, subChapters);
	}
}
