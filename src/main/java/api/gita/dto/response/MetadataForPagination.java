package api.gita.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetadataForPagination {
	Integer page;
	Integer pageSize;
	Long totalRecords;
	Integer totalPage;
	
	public static MetadataForPagination of(Integer page,Integer pageSize,Long totalRecords,Integer totalPage) {
		return new MetadataForPagination(page, pageSize, totalRecords, totalPage);
	}

}
