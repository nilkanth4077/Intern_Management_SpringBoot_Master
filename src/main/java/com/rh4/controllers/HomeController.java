package com.rh4.controllers;
import com.rh4.repositories.*;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rh4.entities.*;
@Controller
@Validated
public class HomeController {

	private InternApplicationRepo repo;
	  public HomeController(InternApplicationRepo repo) {
	        this.repo = repo;
	    }
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	@GetMapping("/intern_login")
	public void login()
	{
		
	}
	@PostMapping("/intern_login")
	public void login(Intern intern)
	{
		
	}
	@GetMapping("/bisag_internship")
	public String bisag_internship()
	{
		return "internapply";
	}
	@PostMapping("/bisag_internship")
	public String bisag_iternship(@ModelAttribute InternApplication internApplication,
	        @RequestParam("icardImage") MultipartFile icardImageFile,BindingResult result) throws IOException 
	{

	    if (result.hasErrors()) {
	        // Handle validation errors, if any
	        return "internapply"; // Or redirect to the form with error messages
	    }

	    if (!icardImageFile.isEmpty()) 
	    {
	        internApplication.setIcardImage(icardImageFile.getBytes());
	    }
	    repo.save(internApplication);
		return null;
	}
		
}		
