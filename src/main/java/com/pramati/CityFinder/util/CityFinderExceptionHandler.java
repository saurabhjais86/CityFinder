package com.pramati.CityFinder.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class CityFinderExceptionHandler {

	private ObjectMapper mapper = new ObjectMapper();


	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<String> genericException(Exception ex) throws JsonProcessingException {
		ex.printStackTrace();
		Error error = new Error();
		error.setErrorCode("0004");
		error.addErrorMessage(ex.getMessage());
		return new ResponseEntity<String>(mapper.writeValueAsString(error), HttpStatus.INTERNAL_SERVER_ERROR);
	}


	public class Error {
		private List<String> errorMessages = new ArrayList<>();
		private String errorCode;

		/**
		 * @return the errorMessage
		 */
		public List<String> getErrorMessages() {
			return errorMessages;
		}

		/**
		 * @param errorMessage
		 *            the errorMessage to set
		 */
		public void addErrorMessage(String errorMessage) {
			this.errorMessages.add(errorMessage);
		}

		/**
		 * @return the errorCode
		 */
		public String getErrorCode() {
			return errorCode;
		}

		/**
		 * @param errorCode
		 *            the errorCode to set
		 */
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

	}
}