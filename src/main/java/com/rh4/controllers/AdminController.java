package com.rh4.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rh4.entities.*;
import com.rh4.services.AdminService;
import com.rh4.services.InternService;
@Controller
@RequestMapping("/bisag/admin")
public class AdminController {
	
	@Autowired
	private InternService internService;

	public String generateInternId() {
        // Generate custom internId using current year and serial number
        SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
        String currentYear = yearFormat.format(new Date());

        // Assuming you have a method to get the next serial number
        int serialNumber = generateSerialNumber();
        ++serialNumber;
        // Combine the parts to form the custom internId
        String sno = String.valueOf(serialNumber);
        String formattedSerialNumber = String.format("%04d", Integer.parseInt(sno));
        System.out.println("serialNumber..."+ serialNumber);
        System.out.println("formated..."+ formattedSerialNumber);
        String internId = currentYear + "BISAG" + formattedSerialNumber;
        return internId;
    }
	public int generateSerialNumber() {
		
		String id = internService.getMostRecentInternId();
		if(id==null)
			return 0;
		String serialNumber = id.substring(id.length() - 4);
		int lastFourDigits = Integer.parseInt(serialNumber);
        return lastFourDigits;
    }
	
	
	//Intern Registration///////////////////////////////////////////////
	
	@GetMapping("/register_intern")
	public String registerIntern()
	{
		return "admin/internregistration";
	}
	
	@PostMapping("/register_intern")
	public String registerIntern(@ModelAttribute("intern") Intern intern)
	{
		intern.setInternId(generateInternId());
		internService.registerIntern(intern);
		return "redirect:/bisag";
	}
	
	//update Intern///////////////////////////////////////////////////
	
	
}
