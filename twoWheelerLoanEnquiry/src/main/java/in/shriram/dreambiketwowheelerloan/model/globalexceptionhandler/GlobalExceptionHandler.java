package in.shriram.dreambiketwowheelerloan.model.globalexceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.shriram.dreambiketwowheelerloan.model.dto.CustomerResponse;
import in.shriram.dreambiketwowheelerloan.model.exceptions.AgeLessThanException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongAdharCardNoException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongEmailException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongMobileNoException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongPancardNoException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AgeLessThanException.class)
	public ResponseEntity<CustomerResponse> handelAgeLessThanException(AgeLessThanException ue)
	{
		String message = ue.getMessage();
		
		CustomerResponse cr = new CustomerResponse(message, new Date());
		
		return new ResponseEntity<CustomerResponse>(cr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WrongMobileNoException.class)
	public ResponseEntity<CustomerResponse> handelWrongMobileNoException(WrongMobileNoException ue)
	{
		String message = ue.getMessage();
		
		CustomerResponse cr = new CustomerResponse(message, new Date());
		
		return new ResponseEntity<CustomerResponse>(cr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WrongAdharCardNoException.class)
	public ResponseEntity<CustomerResponse> handelWrongAdharCardNoException(WrongAdharCardNoException ue)
	{
		String message = ue.getMessage();
		
		CustomerResponse cr = new CustomerResponse(message, new Date());
		
		return new ResponseEntity<CustomerResponse>(cr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WrongPancardNoException.class)
	public ResponseEntity<CustomerResponse> handelWrongPancardNoException(WrongPancardNoException ue)
	{
		String message = ue.getMessage();
		
		CustomerResponse cr = new CustomerResponse(message, new Date());
		
		return new ResponseEntity<CustomerResponse>(cr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WrongEmailException.class)
	public ResponseEntity<CustomerResponse> handelWrongEmailException(WrongEmailException ue)
	{
		String message = ue.getMessage();
		
		CustomerResponse cr = new CustomerResponse(message, new Date());
		
		return new ResponseEntity<CustomerResponse>(cr, HttpStatus.BAD_REQUEST);
	}
}
