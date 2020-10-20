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
import com.nguyenchunghuu.service.SanPhamService;

@Controller
@RequestMapping("/admin/deletedPr")
public class DeletedProductController {
	
	@Autowired
	SanPhamService spService;
	
	@Autowired
	CategoriesService cateSer;
	
	@GetMapping
	public String defaultHome(ModelMap modelMap) {
		List<SanPham> listsp = spService.getListSPDel(0);
		modelMap.addAttribute("listsp", listsp);
		
		List<DoiTuong> listDT = cateSer.getDoiTuong();
		
		modelMap.addAttribute("listDT", listDT);
		
		return "admin/deletedPr";
	}
}
