package in.shriram.dreambiketwowheelerloan.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.shriram.dreambiketwowheelerloan.model.model.Cibil;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;

@Repository
public interface EnquiryRepo extends JpaRepository<Enquiry, Integer>{

<<<<<<< HEAD
	
=======

>>>>>>> branch 'main' of https://github.com/payalkhawase/twowheelerloanEnqiry.git
	public List findByEnquiryStatus(String str);

	

	

	

	

	
	

}
