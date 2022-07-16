package api.gita.service.impl;

import org.springframework.stereotype.Service;

import api.gita.repository.GitaChapterEnglishRepository;
import api.gita.repository.VerseEnglishRepository;
import api.gita.service.IGitaEnglishService;

@Service("gitaServiceEnglish")
public class GitaEnglishServiceImpl implements IGitaEnglishService {

	private final GitaChapterEnglishRepository gitaChapterEnglishRepository;
	private final VerseEnglishRepository verseEnglishRepository;

	public GitaEnglishServiceImpl(GitaChapterEnglishRepository gitaChapterEnglishRepository,
			VerseEnglishRepository verseEnglishRepository) {
		this.gitaChapterEnglishRepository = gitaChapterEnglishRepository;
		this.verseEnglishRepository = verseEnglishRepository;
	}

}
