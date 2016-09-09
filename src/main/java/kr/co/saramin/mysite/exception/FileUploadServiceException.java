package kr.co.saramin.mysite.exception;

public class FileUploadServiceException extends RuntimeException {

	public FileUploadServiceException(String message) {

		super(message);

	}

	public FileUploadServiceException() {

		super("FileUpload Service Exceptipn occurs");

	}

}
