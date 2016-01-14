package cn.iktz.web.project.a00_dbassist;

public class DBAssistException extends RuntimeException {

	private static final long serialVersionUID = -4465110401887273957L;

	public DBAssistException() {
	}

	public DBAssistException(String message) {
		super(message);
	}

	public DBAssistException(Throwable cause) {
		super(cause);
	}

	public DBAssistException(String message, Throwable cause) {
		super(message, cause);
	}

}
