package com.lj.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lj.elasticsearch.service.SampleBookRepositoryService;

@Controller
@RequestMapping("book")
public class SampleBookController {

	@Resource
	private SampleBookRepositoryService sampleBookRepositoryService;


 @RequestMapping("find")
 public ModelAndView find(@RequestParam(value="name", defaultValue="world") String name){
  System.out.println("hello " + name);
  Map<String, Object> map = new HashMap<String,Object>();
  map.put("name", name);
  sampleBookRepositoryService.shouldIndexSingleBookEntity();
  return new ModelAndView("/book",map);
 }
}