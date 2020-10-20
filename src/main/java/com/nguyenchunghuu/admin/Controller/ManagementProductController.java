package com.nguyenchunghuu.admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenchunghuu.Entity.DoiTuong;
import com.nguyenchunghuu.Entity.SanPham;
import com.nguyenchunghuu.service.CategoriesService;
import com.nguyenchunghuu.service.GetAllDetailService;
import com.nguyenchunghuu.service.SanPhamService;

@Controller
@RequestMapping("/admin/product")
public class ManagementProductController {
	@Autowired
	SanPhamService spService;
	
	@Autowired
	GetAllDetailService getAllDetailService;
	
	@Autowired
	CategoriesService cateSer;
	
	@GetMapping
	public String homedefault(ModelMap modelMap) {

		List<SanPham> listsp = spService.getListSP(1);
		modelMap.addAttribute("listsp", listsp);
		
		List<DoiTuong> listDT = cateSer.getDoiTuong();
		
		modelMap.addAttribute("listDT", listDT);
		
		int page = (listsp.size() / 5) + 2;
		
		modelMap.addAttribute("page", page);
		return "admin/product";
	}
}
