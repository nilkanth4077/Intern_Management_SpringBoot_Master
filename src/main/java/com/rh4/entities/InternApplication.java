package com.rh4.entities;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.annotation.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "internapplication")
public class InternApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number")
    private String contactNo;

    @Column(name = "email")
    private String email;

    @Column(name = "collegeName")
    private String collegeName;
	@Column(name = "branch_name")
    private String branch;
	@Lob
	@NotNull 
    @Column(name = "icard_image", length = 1000)
    private byte[] icardImage;
    @Column(name = "semester")
    private int semester;
    public InternApplication(Long id, String firstName, String lastName, String contactNo, String email,
			String collegeName, String branch, byte[] icardImage, int semester) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.email = email;
		this.collegeName = collegeName;
		this.branch = branch;
		this.icardImage = icardImage;
		this.semester = semester;
	}
	public byte[] getIcardImage() {
		return icardImage;
	}
	public void setIcardImage(byte[] icardImage) {
		this.icardImage = icardImage;
	}

//	@Lob
//    @Column(name = "noc_pdf", columnDefinition = "BLOB")
//    private byte[] nocPdf;


    public InternApplication(Long id, String firstName, String lastName, String contactNo, String email, String collegeName,
		String branch, int semester) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.contactNo = contactNo;
	this.email = email;
	this.collegeName = collegeName;
	this.branch = branch;
	this.semester = semester;
}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public InternApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

    

}
