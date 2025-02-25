package in.shriram.dreambiketwowheelerloan.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.shriram.dreambiketwowheelerloan.model.model.Cibil;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;

@Repository
public interface CibilRepo extends JpaRepository<Cibil, Integer> {

	
	//public List<Cibil> findByStatus();

	
}
