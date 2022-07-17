package api.gita.controller.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import api.gita.commons.StringComparator;
import api.gita.dto.response.BookListResponseDTO;
import api.gita.dto.response.BookResponseDTO;
import api.gita.dto.response.ChapterDTO;
import api.gita.dto.response.ChapterResponseDTO;
import api.gita.dto.response.MetadataForPagination;
import api.gita.dto.response.SubChapterDTO;
import api.gita.dto.response.SubChapterResponseDTO;
import api.gita.dto.response.VerseResponseDTO;
import api.gita.entity.Book;
import api.gita.entity.GitaChapter;
import api.gita.entity.Verse;

@Component
public class BookControllerMapper {

	public List<BookListResponseDTO> buildBookListResponse(List<Book> books) {
		List<BookListResponseDTO> bookListResponses = new ArrayList<>();
		List<BookResponseDTO> bookResponses = new ArrayList<>();
		books.forEach(book -> {
			bookResponses.add(BookResponseDTO.of(book.getBookId(), book.getTitle(), book.getSubTitle(),
					book.getCoverImageUrl(), book.getLanguage(), book.getColorCode()));
		});
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		bookListResponses.add(BookListResponseDTO.of(bookResponses));
		return bookListResponses;
	}

	public ChapterResponseDTO buildBookChapterResponse(Page<GitaChapter> gitaChapters, Book book) {
		MetadataForPagination metadataForPagination = MetadataForPagination.of(gitaChapters.getNumber(),
				gitaChapters.getSize(), gitaChapters.getTotalElements(), gitaChapters.getTotalPages());
		List<ChapterDTO> bookChapters = new ArrayList<>();
		gitaChapters.forEach(bookChapter -> {
			bookChapters.add(
					ChapterDTO.of(bookChapter.getBookId(), bookChapter.getChapterIndex(), bookChapter.getChapterName(),
							bookChapter.getChapterHeading(), bookChapter.getImageUrl(), bookChapter.getDescription()));
		});
		return ChapterResponseDTO.of(BookResponseDTO.of(book.getBookId(), book.getTitle(), book.getSubTitle(),
				book.getColorCode(), book.getLanguage(), book.getColorCode()), metadataForPagination, bookChapters);

	}

	public SubChapterResponseDTO buildChapterResponseDTO(GitaChapter chapter, Integer pageNumber, Integer pageSize) {
		ChapterDTO chapterDTO = ChapterDTO.of(chapter.getBookId(), chapter.getChapterIndex(), chapter.getChapterName(),
				chapter.getChapterHeading(), chapter.getImageUrl(), chapter.getDescription());
		MetadataForPagination metadataForPagination = MetadataForPagination.of(pageNumber, pageSize,
				(long) (int) chapter.getSubChapter().keySet().size(),
				((chapter.getSubChapter().keySet().size()) % pageSize) == 0
						? ((chapter.getSubChapter().keySet().size()) / pageSize)
						: (((chapter.getSubChapter().keySet().size()) / pageSize) + 1));
		Integer count = 0;
		List<SubChapterDTO> subChapters = new ArrayList<SubChapterDTO>();
		for (String key : getKeyList(chapter)) {
			if (count < pageNumber * pageSize) {
				count++;
				continue;
			}
			if (count == (pageNumber + 1) * pageSize)
				break;
			count++;
			subChapters.add(SubChapterDTO.of(key, chapter.getSubChapter().get(key)));
		}
		return SubChapterResponseDTO.of(chapterDTO, metadataForPagination, subChapters);
	}

	public VerseResponseDTO buildVerseRespnseDTO(Verse verse) {
		return VerseResponseDTO.of(verse.getBookId(), verse.getChapterIndex(), verse.getVerseNumber(),
				verse.getOriginalVerse_Hi(), verse.getOriginalVerse_En(), verse.getVerseShort(), verse.getCommentary());
	}

	private List<String> getKeyList(GitaChapter chapter) {
		List<String> keylist = new ArrayList<>();
		chapter.getSubChapter().keySet().forEach(key -> {
			keylist.add(key);
		});
		Collections.sort(keylist, new StringComparator());
		return keylist;
	}

}
