package api.gita.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDTO {

	private Integer bookId;
	private Integer chapterIndex;
	private String chapterName;
	private String chapterHeading;
	private String description;

	public static ChapterDTO of(Integer bookId, Integer chapterIndex, String chapterName, String chapterHeading,
			String description) {
		return new ChapterDTO(bookId, chapterIndex, chapterName, chapterHeading, description);
	}
}
