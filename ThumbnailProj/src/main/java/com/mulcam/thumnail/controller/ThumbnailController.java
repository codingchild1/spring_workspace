package com.mulcam.thumnail.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class ThumbnailController {
	
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/thumbnaillist")
	public String thumbNailList(Model model) {
		List<String> fileList = new ArrayList<>();
		fileList.add("yellow 1.gif");
		fileList.add("yellow 2.jpg");
		model.addAttribute("fileList",fileList);
		return "result";
	}
	
	@GetMapping("/thumbnail/{filename}")
	public void thumbNail(@PathVariable String filename, 
			HttpServletRequest request, HttpServletResponse response) {
		String path = servletContext.getRealPath("/upload/");
		File image = new File(path+filename);
		try {
			OutputStream out = response.getOutputStream();
			if(image.exists()) {
				Thumbnails.of(image).size(50,50).outputFormat("png").toOutputStream(out);
				byte[] buffer = new byte[1024*8];
				out.write(buffer);
			}
		}catch(Exception e) {}
	}
}
