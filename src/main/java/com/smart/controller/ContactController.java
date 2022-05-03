package com.smart.controller;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.entities.Contact;

@Controller
public class ContactController
{
	
	@GetMapping("/addContact")
	public String addContact(Model model) 
	{
		model.addAttribute("contact",new Contact());
		return "addContact";
	}
	
	@PostMapping("/processContact")
	public String processContact(@ModelAttribute Contact contact, Model model, @RequestParam("profileImage") MultipartFile file) throws IOException
	{
		System.out.println(contact);
		model.addAttribute("contact",contact);
		
		if(file.isEmpty())
		{
			
		}
		else
		{
			 contact.setImage(file.getOriginalFilename());
			 
			File saveFile= new ClassPathResource("static/img").getFile();
			
		//	Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
			
			Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
		
			
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("File is uploaded ");
		}
		
		
		return "addContact";
	}

}
