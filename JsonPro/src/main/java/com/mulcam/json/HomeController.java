package com.mulcam.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/json5", method = RequestMethod.GET)
	public String json_from5() {
		return "json5";
	}
	@RequestMapping(value = "/json6", method = RequestMethod.GET)
	public String json_from6() {
		return "json6";
	}
	
	@ResponseBody
	@RequestMapping(value="json", method=RequestMethod.POST)
	public void json5(@RequestParam(value="jsonInfo",required=false) String jsonInfo) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject)parser.parse(jsonInfo);
		logger.info((String)jsonObject.get("name"));
		logger.info((String)jsonObject.get("age"));
		logger.info((String)jsonObject.get("gender"));
		logger.info((String)jsonObject.get("nickname"));
	}
	
//	@ResponseBody
//	@RequestMapping(value="json2", method=RequestMethod.POST,produces="application/text; charset=utf-8")
//	public String json6() {
//		JSONObject totalObject = new JSONObject();
//		JSONArray membersArray = new JSONArray();
//		
//		JSONObject memberInfo1 = new JSONObject();
//		memberInfo1.put("name", "박지성");
//		memberInfo1.put("age", "25");
//		memberInfo1.put("gender", "남자");
//		memberInfo1.put("nickname", "날쌘돌이");
//		membersArray.add(memberInfo1);
//		
//		JSONObject memberInfo2 = new JSONObject();
//		memberInfo2.put("name", "김연아");
//		memberInfo2.put("age", "21");
//		memberInfo2.put("gender", "여자");
//		memberInfo2.put("nickname", "칼치");
//		membersArray.add(memberInfo2);
//		totalObject.put("members", membersArray);
//		return totalObject.toJSONString();
//	}
	@ResponseBody
	@RequestMapping(value="json2", method=RequestMethod.POST)
	public void json6(HttpServletResponse response) throws IOException {
		JSONObject totalObject = new JSONObject();
		JSONArray membersArray = new JSONArray();
		
		JSONObject memberInfo1 = new JSONObject();
		memberInfo1.put("name", "박지성");
		memberInfo1.put("age", "25");
		memberInfo1.put("gender", "남자");
		memberInfo1.put("nickname", "날쌘돌이");
		membersArray.add(memberInfo1);
		
		JSONObject memberInfo2 = new JSONObject();
		memberInfo2.put("name", "김연아");
		memberInfo2.put("age", "21");
		memberInfo2.put("gender", "여자");
		memberInfo2.put("nickname", "칼치");
		membersArray.add(memberInfo2);
		
		totalObject.put("members", membersArray);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(totalObject.toJSONString());
	}
	
}
