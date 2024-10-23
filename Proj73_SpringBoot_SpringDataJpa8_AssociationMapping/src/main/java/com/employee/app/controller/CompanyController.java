package com.employee.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.employee.app.service.CompanyMgmtService;

@Controller("controller")
public class CompanyController {
	
	@Autowired
	private CompanyMgmtService service;
	
	public void saveDataUsingParent() {
		service.saveDataUsingParent();
	}
	
	public void saveDataUsingChild() {
		service.saveDataUsingChilds();
	}
	
	public void getDataUsingParent() {
		service.getDataUsingParent();
	}
	
  public void getDataUsingChild() {
	  service.getDataUsingChilds();
  }

}
