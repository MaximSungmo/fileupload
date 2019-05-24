package com.cafe24.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.fileupload.service.FileuploadService;

@Controller
public class FileuploadController {
	
	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping("/form")
	public String form() {
		
		return "form";
	}
	
	@PostMapping("/upload")
	public String upload(
		@RequestParam(value="email", required=true, defaultValue="") String email,
		@RequestParam(value="file1") MultipartFile multipartFile, 
		Model model
	) {
		
		System.out.println("email: " + email);

		String url = fileuploadService.restore(multipartFile);
		
		model.addAttribute("url", url);
		
		return "result";
	}
}
