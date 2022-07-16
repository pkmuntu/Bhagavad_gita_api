package api.gita.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class VerseHindi {
	
	@Id
	private String id;
	@NonNull
	private Integer chapterIndex;
	@NonNull
	private String verseNumber;
	@NonNull
	private String originalVerse;
	@NonNull
	private String wordMeanings;
	@NonNull
	private String verseShort;
	@NonNull
	private String commentary;
	

}
