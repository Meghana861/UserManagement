package com.amzur.registration.practice.p3;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amzur.registration.practice.Constants.ApplicationConstants;
import com.amzur.registration.practice.dto.RegRequest;
import com.amzur.registration.practice.dto.RegResponse;
import com.amzur.registration.practice.handlers.UserAlreadyExistsException;
import com.amzur.registration.practice.p1.Register;
import com.amzur.registration.practice.p2.RegRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Regservice {
   @Autowired
   RegRepository reg;
   
   public RegResponse Regisave(RegRequest request)
   {
	   Optional<Register> existinguser =reg.findByEmailAndPassword(request.getEmail(),request.getPassword());
	   if(existinguser.isPresent())
	   {
		   throw new UserAlreadyExistsException(ApplicationConstants.USER_ALREADY_EXISTS);
	   }
	   else
	   {
	   Register re=new Register();
	   BeanUtils.copyProperties(request, re);
	   re= reg.save(re);
	   RegResponse response=new RegResponse();
	   BeanUtils.copyProperties(response, re);
	   return response;
	   } 
   }
   
  public List<Register> findRegistrations()
  {
	  return reg.findAll();
  }		  
			  
/*.stream().map(re->
			  {
				  RegResponse response=new RegResponse();
				  BeanUtils.copyProperties(response, re);
				  return response;
			  }).collect(Collectors.toList());
		  }*/
/*public Register findByEmail(String email) {
	
	return reg.findByEmail(email);
	
}*/


public ResponseEntity<?> findByEmail(String email, String password)
{
	   Register user=reg.findByEmail(email);
	   if(user.getPassword().equals(password))
	   {
		   return ResponseEntity.ok(user);
	   }
	   else
	   {
		   return ResponseEntity.status(401).body("Invalid Credentials"); 
	   }
}

/*public List<RegResponse> findbyid(Long id)
{
	return reg.findById(id).stream().map(re->
	{
		RegResponse response=new RegResponse();
		BeanUtils.copyProperties(response, re);
		return response;
	}).collect(Collectors.toList());
}*/
public Optional<Register> findbyid(Long id)
{
	return reg.findById(id);
}

public void deletebyid(Long id)
{
	reg.deleteById(id);
}

public Register updatebyid(Long id, Register updateEntity)
{
    Optional<Register> optional=reg.findById(id); 
    if(optional.isPresent())
    {
    	Register regist=optional.get();
    	regist.setUsername(updateEntity.getUsername());
    	return reg.save(regist);

     }
    else {
        
        throw new EntityNotFoundException("Register not found with id: " + id);
    }

}
}


