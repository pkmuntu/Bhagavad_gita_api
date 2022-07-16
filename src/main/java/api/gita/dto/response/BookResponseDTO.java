package api.gita.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {

	private Integer bookId;
	private String title;
	private String subTitle;
	private String coverImageUrl;
	private String language;
	private String colorCode;

	public static BookResponseDTO of(Integer bookId, String title, String subTitle, String coverImageUrl, String language,
			String colorCode) {
		return new BookResponseDTO(bookId, title, subTitle, coverImageUrl, language, colorCode);
	}
}
