package in.shriram.dreambiketwowheelerloan.model.servicei;

import java.util.List;

import in.shriram.dreambiketwowheelerloan.model.model.Cibil;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;

public interface EnquiryService {

	public Enquiry getEnquiry(int customerId);

	public Enquiry setAllData(Enquiry e);
 
	public List<Enquiry> getAllEnquiry();

	public Enquiry delete(int customerId);
 
	public Enquiry updateEnquiryStatus(Enquiry e);

   public Enquiry getEnquiryByStatus(int customerId);

	public List<Enquiry> pendingEnquiry();

	public List<Cibil> ShowApprovedEnquiry();

	public Enquiry updateEnquiryStatusForword(int customerId);

	public List<Cibil> ShowRejectedEnquiry();
	
        public List<Enquiry> forwordOE();
	
}
