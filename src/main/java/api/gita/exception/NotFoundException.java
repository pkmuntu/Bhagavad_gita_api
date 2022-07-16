package api.gita.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1001L;
	private String field;

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String field, String message) {
		super(message);
		this.field = field;
	}
}
