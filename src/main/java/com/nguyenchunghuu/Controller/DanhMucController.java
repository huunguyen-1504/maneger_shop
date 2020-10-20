package com.nguyenchunghuu.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenchunghuu.Entity.ShopCart;
import com.nguyenchunghuu.service.CategoriesService;

@Controller
@RequestMapping("/Categories")
public class DanhMucController {
	
	@Autowired
	CategoriesService cateSV;
	
	@GetMapping
	public String CategoriesDefault() {	
		return "redirect:/shop";
	}
	
	@GetMapping("/{loai}")
	public String loaiSP(@PathVariable String loai, ModelMap modelMap, HttpSession httpSession) {
		
		if(httpSession.getAttribute("unames") != null) {
			modelMap.addAttribute("ssUser", httpSession.getAttribute("unames"));
		}
		
		if(null != httpSession.getAttribute("giohang")) {
			List<ShopCart> cartPr = (List<ShopCart>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsp", cartPr.size());
		}
		
		modelMap.addAttribute("doiTuongByName", cateSV.getDoiTongByName(loai));
		modelMap.addAttribute("listDoiTuong",cateSV.getDoiTuong());
		
		return "Categories";
	}
}
