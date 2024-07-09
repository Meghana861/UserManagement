package com.amzur.registration.practice.p4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amzur.registration.practice.dto.RegRequest;
import com.amzur.registration.practice.dto.RegResponse;
import com.amzur.registration.practice.p1.Register;
import com.amzur.registration.practice.p3.Regservice;

@RestController
@RequestMapping("/Registration")
public class RegControl {
	@Autowired
   private Regservice regs;
   @PostMapping
   public String create(@RequestBody RegRequest request)
   {
	   regs.Regisave(request);
	   return "Registered Successfully";
   }
   
   @GetMapping("/email/{email}/password/{password}")
   public ResponseEntity<?> findByEmailPass(@PathVariable String email,@PathVariable String password)
   {
	   return regs.findByEmail(email, password);
	   
   }
   
   @GetMapping("/{id}")
   public Optional<Register> findbyid (@PathVariable Long id)
   {
	   return regs.findbyid(id);
	   
   }
   
   @GetMapping
   public List<Register> findAllRegistrations()
   {
	   return regs.findRegistrations();
   }
   
   @DeleteMapping("/{id}")
   public String delete(@PathVariable Long id)
   {
	   regs.deletebyid(id);
	   return "Deleted Successfully";
	   
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Register> update(@PathVariable Long id,@RequestBody Register updateentity)
   {
	   Register re=regs.updatebyid(id, updateentity);
	   return ResponseEntity.ok(re);
   }
   
  

   

}
