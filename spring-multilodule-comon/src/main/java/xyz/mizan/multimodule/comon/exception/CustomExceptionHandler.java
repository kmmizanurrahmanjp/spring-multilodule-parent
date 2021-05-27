package xyz.mizan.multimodule.comon.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import xyz.mizan.multimodule.comon.util.ErrorResponse;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@Autowired
	ErrorResponse errorResponse;
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        errors.add(ex.getLocalizedMessage());
        ErrorResponse response = errorResponse.getResponse(0, null, false, "Internal Server Error", errors);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for(ObjectError objectError : ex.getBindingResult().getAllErrors()) {
        	errors.add(objectError.getDefaultMessage());
        }
        ErrorResponse response = errorResponse.getResponse(0, null, false, "Validation Failed", errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
