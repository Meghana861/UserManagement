package com.amzur.registration.practice.p1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="REGISTRATION")
public class Register {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name="username")
  private String username;
  @Column(name="MOBILENO")
  private String mobileno;
  @Column(name="EMAIL")
  private String email;
  public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(name="PASSWORD")
  private String password;
  
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
  
}
