package com.rh4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rh4.entities.*;
@Repository
public interface InternRepo extends JpaRepository<Intern, String> {

	Intern findTopByOrderByInternIdDesc();
}