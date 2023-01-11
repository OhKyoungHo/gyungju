package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.EducationVO;
import com.example.persistence.RankRepository;

@Controller
@RequestMapping("/academy")
public class RankController {

	//서비스, 서비스임플 단을 통하지않고 바로 레포지토리 단을 통하여 코드실행
	@Autowired
	private RankRepository rankRepo;
	
	@RequestMapping("/rank")
	public void rankQuery(Model m) {
//		System.out.println("실험");
		
		//1~3위까지
		m.addAttribute("rank", rankRepo.rankQuery());
		
		//4~10위까지
		m.addAttribute("rankOther", rankRepo.rankQueryOther());
		
	}
	
}
