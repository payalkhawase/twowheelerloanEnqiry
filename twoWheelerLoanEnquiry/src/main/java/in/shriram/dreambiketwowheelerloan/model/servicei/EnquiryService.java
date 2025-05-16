package in.shriram.dreambiketwowheelerloan.model.servicei;

import java.util.List;

import in.shriram.dreambiketwowheelerloan.model.model.Cibil;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;

public interface EnquiryService {

	public Enquiry getEnquiry(int customerId);

	public Enquiry setAllData(Enquiry e);
 
	public List<Enquiry> getAllEnquiry();

	public Enquiry delete(int customerId);
 
	public Enquiry updateEnquiry(Enquiry e);

	public Enquiry updateEnquiryStatus(Enquiry e);
	
	//public Enquiry getEnquiryByCibil(int cbCibilId);

   public Enquiry getEnquiryByStatus(int customerId);

	public List<Enquiry> pendingEnquiry();

	public List<Cibil> ShowApprovedEnquiry();

	public List<Cibil> ShowRejectedEnquiry();

	public Enquiry updateEnquiryStatusForword(int customerId);

	public List forwordOE();

	
}
