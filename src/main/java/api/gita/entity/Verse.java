package api.gita.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("VERSE")
public class Verse {

	@Id
	private String id;
	@NonNull
	private Integer bookId;
	@NonNull
	private Integer chapterIndex;
	@NonNull
	private String verseNumber;
	@NonNull
	private String originalVerse_Hi;
	@NonNull
	private String originalVerse_En;
	@NonNull
	private String wordMeanings;
	@NonNull
	private String verseShort;
	@NonNull
	private String commentary;

}
