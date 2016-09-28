package com.lj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lj.web.vo.VersionVo;

@Controller
@RequestMapping("version")
public class VersionInfoContoller {

	@RequestMapping("/add")
	public ModelAndView showAddVersionInfo(){
		ModelAndView model = new ModelAndView("/version");
		VersionVo versionVo = new VersionVo();
		model.addObject("versionVo", versionVo);
		return model;
	}
	
	@RequestMapping("/save")
	public ModelAndView showAddVersionInfo(VersionVo versionVo){
		ModelAndView model = new ModelAndView("/version");
		System.out.println(111);
		return model;
	}
	
}
