package api.gita.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubChapterDTO {

	private String verseNumber;
	private String description;

	public static SubChapterDTO of(String verseNumber, String description) {
		return new SubChapterDTO(verseNumber, description);
	}
}
