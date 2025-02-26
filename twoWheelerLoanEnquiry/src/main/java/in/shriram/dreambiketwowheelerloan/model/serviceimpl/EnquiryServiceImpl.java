package in.shriram.dreambiketwowheelerloan.model.serviceimpl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.shriram.dreambiketwowheelerloan.model.model.Cibil;
import in.shriram.dreambiketwowheelerloan.model.exceptions.AgeLessThanException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongAdharCardNoException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongEmailException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongMobileNoException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongPancardNoException;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;
import in.shriram.dreambiketwowheelerloan.model.repository.CibilRepo;
import in.shriram.dreambiketwowheelerloan.model.repository.EnquiryRepo;
import in.shriram.dreambiketwowheelerloan.model.servicei.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryRepo er;

	@Autowired
	RestTemplate rt; 

	@Autowired
	CibilRepo cr;

	@Override
	public Enquiry getEnquiry(int customerId) {

		return er.findById(customerId).get();
	}

	public Enquiry setAllData(Enquiry e) {

		if(e.getAge()<18) {
    		throw new AgeLessThanException("Age is less than 18");
    	}
    	
		String mno=String.valueOf(e.getMobileNo());
		if(mno.length()!=10 ||!mno.matches("\\d{10}")) {
			throw new WrongMobileNoException("wrong mobile number");
		}
		 
		String adhar=String.valueOf(e.getAdharcardNo()); 
		  if(adhar.length()!=12 ||!adhar.matches("\\d{12}")) {
		  throw new WrongAdharCardNoException("wrong AdharCard number"); 
		}
		
		 String regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}";
		 Pattern p = Pattern.compile(regexp);
		 Matcher m = p.matcher(e.getPancardNo());
		  if(!m.matches()) {
		 
		   throw new WrongPancardNoException("wrong pancardNo");
		 }
		  
		  String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		  Pattern pt = Pattern.compile(regex);
		  Matcher mt = pt.matcher(e.getEmail());
		 
		  if(!mt.matches()) {
        	 
        	 throw new WrongEmailException("wrong email");
         }
		
		  
		return er.save(e);

	}

	@Override
	public List<Enquiry> getAllEnquiry() {

		return er.findAll();
	}

	@Override
	public Enquiry delete(int customerId) {
		
		er.deleteById(customerId);
		
		return null;
	}

	@Override
	public Enquiry updateEnquiry(Enquiry e) {
		
		return er.save(e);
	}

	@Override
	public Enquiry getEnquiryByStatus(int customerId) {
		
		return null;
		
	}

	
	

	@Override
	public Enquiry updateEnquiryStatus(Enquiry e) {
		/*
		e.setCustomerId(customerId);
		e.setFirstname(e.getFirstname());
		e.setLastName(e.getLastName());
		e.setAddress(e.getAddress());
		e.setCity(e.getCity());
		e.setAge(e.getAge());
		e.setEmail(e.getEmail());
		e.setMobileNo(e.getMobileNo());
		e.setAlternateMobno(e.getAlternateMobno());
		e.setPancardNo(e.getPancardNo());
		e.setAdharcardNo(e.getAdharcardNo());
		e.setEnquiryStatus(status);
		e.setCb(e.getCb());
		*/
		return er.save(e);
	}
	
	@Override
	public Enquiry getEnquiryByCibil(int cbCibilId) {
		
		return er.findByCbCibilId(cbCibilId);
	}

	@Override
	public List<Enquiry> pendingEnquiry() {
		return er.findByenquiryStatus("Pending");
	}

	@Override
	public List ShowApprovedEnquiry() 
	{
		List cb=er.findByenquiryStatus("Pending");
		return cb;
		
       
	}

	@Override
	public List<Cibil> ShowRejectedEnquiry() {
		// TODO Auto-generated method stub
		return null;
	}

	
     

}
