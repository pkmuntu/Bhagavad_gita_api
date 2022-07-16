package api.gita.service.impl;

import org.springframework.stereotype.Service;

import api.gita.repository.GitaChapterHindiRepository;
import api.gita.repository.VerseHindiRepository;
import api.gita.service.IGitaHindiService;

@Service("gitaHindiService")
public class GitaHindiServiceImpl implements IGitaHindiService {

	private final GitaChapterHindiRepository gitaChapterHindiRepository;
	private final VerseHindiRepository verseHindiRepository;

	public GitaHindiServiceImpl(VerseHindiRepository verseHindiRepository,
			GitaChapterHindiRepository gitaChapterHindiRepository) {
		this.gitaChapterHindiRepository = gitaChapterHindiRepository;
		this.verseHindiRepository = verseHindiRepository;
	}

}
