package com.kjm.myproject.myproject.search;

import java.net.URLEncoder;
import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
	@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE,value="/info")
	public String search() throws Exception {
		HashMap<String,String> map = new HashMap<String,String>();
		String b=URLEncoder.encode("지역구분","UTF-8");
		map.put("serviceKey", "rdz%2FhGzhFd1qNiQNU7Etu%2Fg6zCxjE4qp%2BTPX%2FyBvC%2BJ%2Fj%2FNFOhhA9o1V6w7BvI9xKRXzATfY6VTJIjT%2B4jxU9Q%3D%3D");
		map.put("GRP_NM",URLEncoder.encode("색상코드","UTF-8"));
		//map.put("CD_NM",URLEncoder.encode("속초시","UTF-8"));
		ParsingData parse = new ParsingData("http://apis.data.go.kr/1320000/CmmnCdService/getCmmnCd", map);
		return parse.openData();
	}
}
