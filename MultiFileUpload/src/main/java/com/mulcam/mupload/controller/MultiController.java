package com.mulcam.mupload.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class MultiController {
	private static final Logger Logger = LoggerFactory.getLogger(MultiController.class);
	@Autowired
	private ServletContext servletContext;

	@GetMapping("/")
	public String form() {
		return "uploadForm";
	}
	
	@PostMapping("/multiupload")
	public String multiUpload(MultipartHttpServletRequest mrequest, Model model) {
		Map<String, Object> map = new HashMap<>();
		
		String id = mrequest.getParameter("id");
		String name = mrequest.getParameter("name");
		
		map.put("id", id);
		map.put("name", name);
		
		List<String> fileList = new ArrayList<>();
		String path = servletContext.getRealPath("/upload/");
		Iterator<String> fnames = mrequest.getFileNames();
		while(fnames.hasNext()) {
			String fileName = fnames.next();
			
			MultipartFile mfile = mrequest.getFile(fileName);
			if(mfile.getSize()>0) {
				File file = new File(path+mfile.getOriginalFilename());
				fileList.add(mfile.getOriginalFilename());
				try {
					mfile.transferTo(file);
				}catch(Exception e) {}
			}
		}
		map.put("fileList", fileList);
		model.addAttribute("map",map);
		return "result";
		
	}
	@GetMapping(value="/download/{filename}")
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
