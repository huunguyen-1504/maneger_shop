package com.nguyenchunghuu.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenchunghuu.Entity.DoiTuong;
import com.nguyenchunghuu.Entity.SanPham;
import com.nguyenchunghuu.Entity.ShopCart;
import com.nguyenchunghuu.service.CategoriesService;
import com.nguyenchunghuu.service.SanPhamService;

@Controller
@RequestMapping("/shop")
public class shopController {
	
	@Autowired
	CategoriesService cateSV;
	
	@Autowired
	SanPhamService spService;
	
	@GetMapping
	public String viewShop(ModelMap modelMap, HttpSession httpSession) {
		if(httpSession.getAttribute("unames") != null) {
			modelMap.addAttribute("ssUser", httpSession.getAttribute("unames"));
		}
		
		if(null != httpSession.getAttribute("giohang")) {
			List<ShopCart> cartPr = (List<ShopCart>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsp", cartPr.size());
		}
		
		List<DoiTuong> getListDoituong = cateSV.getDoiTuong();
		List<SanPham> listsp = spService.getListSP(-1);
		
		modelMap.addAttribute("listDoiTuong", getListDoituong);
		modelMap.addAttribute("listsp", listsp);
		
		return "shop";
	}
	
	
}
