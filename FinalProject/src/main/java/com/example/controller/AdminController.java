package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.AnnouncementVO;
import com.example.domain.EducationVO;
import com.example.service.AnnouncementService;
import com.example.service.EducationService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private EducationService eduService;
	@Autowired
	private AnnouncementService announcementService;
	
	//경호
//	//상품등록 페이지로 이동
//	@RequestMapping("/academyRegister")
//	public String itemRegister() {	
//		return "admin/academyRegister";
//	}
	//경호
	//상품목록 페이지로 이동
	@RequestMapping("/academyList")
	public String itemList(Model m) {	
		List<EducationVO> list = eduService.selectAllAcademy();
		m.addAttribute("result", list);
		return "admin/academyList";
	}
	//경주
	//관리자에 공지 목록띄움
	@RequestMapping("/announcement_m")
	public String annoList(Model m) {	
		List<AnnouncementVO> list = announcementService.selectAllAnnouncement();
		m.addAttribute("result", list);
		return "admin/announcement_m";
	}
	
	//경주
	//공지상세 페이지띄우기
	@RequestMapping("/announcementModify")
	public void getAnnouncement(AnnouncementVO vo, Model m) {
		m.addAttribute("anno", announcementService.getAnnouncement(vo));
		
	}
	
	//경주 
	//공지 등록하기
	@RequestMapping("/announcementInsert")
	public String announcementInsert(AnnouncementVO vo) {
		announcementService.announcementInsert(vo);
		return "redirect:/admin/announcement_m";
	}
	
	//경주
	//공지내용 삭제하기
//	@RequestMapping("/announcement_m")
//	public String deleteAnnouncement(AnnouncementVO vo) {
//		announcementService.deleteAnnouncement(vo);
//		return "admin/announcement_m";
//	}
	
}
