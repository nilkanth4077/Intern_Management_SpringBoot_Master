package com.rh4.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh4.entities.*;
import com.rh4.repositories.*;

@Service
public class InternService {

	@Autowired
	private InternRepo repo;
	public void registerIntern(Intern intern)
	{
		repo.save(intern);
	}
	
	public String getMostRecentInternId()
	{
		Intern mostRecentIntern = repo.findTopByOrderByInternIdDesc();
        return mostRecentIntern != null ? mostRecentIntern.getInternId() : null;
	}
	
}
