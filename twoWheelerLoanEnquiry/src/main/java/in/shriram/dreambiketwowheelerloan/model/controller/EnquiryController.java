package in.shriram.dreambiketwowheelerloan.model.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.shriram.dreambiketwowheelerloan.model.model.Cibil;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;
import in.shriram.dreambiketwowheelerloan.model.servicei.EnquiryService;

@RestController
@RequestMapping("/enq")
//@CrossOrigin("http://localhost:5173")
public class EnquiryController {

	@Autowired
	EnquiryService es;
	
	
	@PostMapping("/add")
	public ResponseEntity<Enquiry> setAllData(@RequestBody Enquiry e){
		
		Enquiry en=es.setAllData(e);
		
		return new ResponseEntity<Enquiry>(en,HttpStatus.CREATED);
		
	}
	

	@GetMapping("/enquiry")
	public ResponseEntity<List<Enquiry>> getAllEnquiry(){
		
		List<Enquiry> eq = es.getAllEnquiry();
		
		return new ResponseEntity<List<Enquiry>>(eq, HttpStatus.OK);
	}
	
	@GetMapping("/enquiry/{customerId}")
	public ResponseEntity<Enquiry> getEnquirySingle(@PathVariable("customerId") int customerId) {
		
		Enquiry eo = es.getEnquiry(customerId);
		
		return new ResponseEntity<Enquiry>(eo, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Enquiry> updateEnquirySingle(@RequestBody Enquiry e)
	{
		Enquiry er=es.updateEnquiry(e);
		
		return new ResponseEntity<Enquiry>(er,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<Enquiry> delete(@PathVariable("customerId") int customerId){
		
		Enquiry er=	es.delete(customerId);
		
		return new ResponseEntity<Enquiry>(er, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/status/{customerId}")
	public ResponseEntity<Enquiry> getEnquiryByStatus(@PathVariable("customerId") int customerId){
		
		Enquiry eo = es.getEnquiry(customerId);
		
			Cibil cb = new Cibil();
			
			System.out.println(cb.getStatus());
		
		return new ResponseEntity<Enquiry>(eo, HttpStatus.OK);
	}
	
	@GetMapping("/RejectedEnquiry")
	public ResponseEntity<List<Cibil>> showrejectedEnquiry() {
		
		List<Cibil> cb = es.ShowRejectedEnquiry();
		
		return new ResponseEntity<List<Cibil>>(cb, HttpStatus.OK);
	
    } 
	@GetMapping("/ApprovedEnquiry")
	public ResponseEntity<List<Cibil>> showapprovedenquiry() {
		
		List<Cibil> cb = es.ShowApprovedEnquiry();
		
		return new ResponseEntity<List<Cibil>>(cb, HttpStatus.OK);
	
    } 
	
	@PutMapping("/updateEnquiryStatus")
	public ResponseEntity<Enquiry> updateEnquiryStatus(@RequestBody Enquiry e){
		
		Enquiry er=es.updateEnquiryStatus(e);
		
		return new ResponseEntity<Enquiry>(er,HttpStatus.OK);
	}
	
/*	@GetMapping("/enquiryByCibil/{cbCibilId}")
	public ResponseEntity<Enquiry> getEnquiryByCibil(@PathVariable("cbCibilId") int cbCibilId) {
		
		Enquiry eo = es.getEnquiryByCibil(cbCibilId);
		
		return new ResponseEntity<Enquiry>(eo, HttpStatus.OK);
	}
	
*/
	
	@GetMapping("/enquiry/getPendingEnquiry")
	public ResponseEntity<List> pendingEnquiry()

	{
		List eq = es.pendingEnquiry();
		
		return new ResponseEntity<List>(eq, HttpStatus.OK);
	} 
	
	@PutMapping("/updateEnquiryStatusforword/{customerId}")
	public ResponseEntity<Enquiry> updateEnquiryStatusForword(@PathVariable("customerId") int customerId)
	{
		Enquiry er=es.updateEnquiryStatusForword(customerId);
		
		return new ResponseEntity<Enquiry>(er,HttpStatus.OK);
	}
	
	@GetMapping("/enquiry/getForwordOE")
	public ResponseEntity<List> forwordOE()
	{
		List e = es.forwordOE();
		
		return new ResponseEntity<List>(e, HttpStatus.OK);
	}
	
}
	
