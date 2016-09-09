package kr.co.saramin.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.saramin.mysite.service.FileUploadService;

@Controller
@RequestMapping( "/fileupload")
public class FileUploadController {

	@Autowired
	private FileUploadService fileuploadService;
	
	
	@RequestMapping("/form")
	public String form(){
		System.out.println("asdf");
		return "fileupload/form";
	}
	
	@RequestMapping("/upload")
	public String upload(
			
			@RequestParam("email") String email,
			@RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2
			,Model model
			)
	{
		
		System.out.println(email);
		String saveFileName= fileuploadService.saveFile( file1);
		
		String url= "/upload-images/"+ saveFileName;
		
		model.addAttribute("urlImage1", url);
		
		String saveFileName2= fileuploadService.saveFile( file2);
		
		String url2= "/upload-images/"+ saveFileName;
		
		model.addAttribute("urlImage2", url2);
		
		
		return "fileupload/result";
	}
	
}
