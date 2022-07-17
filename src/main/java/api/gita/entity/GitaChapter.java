package api.gita.entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Document("GITA_CHAPTER")
public class GitaChapter {

	@Id
	private String id;
	@NonNull
	private Integer bookId;
	@NonNull
	private Integer chapterIndex;
	@NonNull
	private String chapterName;
	@NonNull
	private String chapterHeading;
	@NonNull
	private String description;
	@NonNull
	private Map<String, String> subChapter;
	@NonNull
	private String imageUrl;
}
