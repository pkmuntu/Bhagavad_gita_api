package api.gita.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "BOOK")
public class Book {
	@Id
	private String id;
	private Integer bookId;
	private String title;
	private String subTitle;
	private String coverImageUrl;
	private String language;
	private String colorCode;
}
