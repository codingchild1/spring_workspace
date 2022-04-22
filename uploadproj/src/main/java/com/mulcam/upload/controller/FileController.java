package com.mulcam.upload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/fileupload")
	public String fileupload() {
		return "fileupload";
	}
	
	
	@PostMapping("/fileupload")
	public String fileupload(@RequestParam(value="file") MultipartFile file, Model model) {
		String path = servletContext.getRealPath("/upload/");
		File destFile = new File(path+file.getOriginalFilename());
		try {
			file.transferTo(destFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("filepath",path+file.getOriginalFilename());
		model.addAttribute("file",file);
		return "uploadresult";
	}
	
	@GetMapping("/filedownload")
	public void filedownload(@RequestParam(value="filename") String filename,
			HttpServletRequest request, HttpServletResponse response) {
		String path = servletContext.getRealPath("/upload/");
		File file = new File(path+filename);
		String sfilename = null;
		FileInputStream fis = null;
		try {
			if(request.getHeader("User-Agent").indexOf("MSIE")>-1) {
				sfilename = URLEncoder.encode(file.getName(), "utf-8");
			}else {
				sfilename = new String(file.getName().getBytes("utf-8"),"ISO-8859-1");
			}
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=\""+sfilename+"\";");
			OutputStream out = response.getOutputStream();
			fis= new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				}catch(Exception e) {
					
				}
			}
		}
	}
	
	@GetMapping(value="/fileview/board/{filename}")
	public void fileview(@PathVariable String filename, 
			HttpServletRequest request, HttpServletResponse response) {
		
		String path = servletContext.getRealPath("/upload/");
		File file = new File(path+filename);
		String sfilename = null;
		FileInputStream fis = null;
		
		try {
			if(request.getHeader("User-Agent").indexOf("MSIE")>-1) {
				sfilename = URLEncoder.encode(file.getName(), "utf-8");
			}else {
				sfilename = new String(file.getName().getBytes("utf-8"),"ISO-8859-1");
			}
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=\""+sfilename+"\";");
			OutputStream out = response.getOutputStream();
			fis= new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				}catch(Exception e) {
					
				}
			}
		}
	}
}
