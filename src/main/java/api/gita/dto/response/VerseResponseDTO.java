package api.gita.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerseResponseDTO {

	private Integer bookId;
	private Integer chapterIndex;
	private String verseNumber;
	private String originalVerse_Sn;
	private String originalVerse_En;
	private String verseShort;
	private String commentary;

	public static VerseResponseDTO of(Integer bookId, Integer chapterIndex, String verseNumber, String originalVerse_sn,
			String originalVerse_En, String verseShort, String commentary) {
		return new VerseResponseDTO(bookId, chapterIndex, verseNumber, originalVerse_sn, originalVerse_En,
				verseShort, commentary);
	}

}
