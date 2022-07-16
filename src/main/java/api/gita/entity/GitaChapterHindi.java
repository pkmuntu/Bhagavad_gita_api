package api.gita.entity;

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
@Document
public class GitaChapterHindi {

	@Id
	private String id;
	@NonNull
	private Integer chapterIndex;
	@NonNull
	private String chapterName;
	@NonNull
	private String chapterHeading;
}
