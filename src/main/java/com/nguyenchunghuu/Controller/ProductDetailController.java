package com.nguyenchunghuu.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenchunghuu.Entity.SanPham;
import com.nguyenchunghuu.Entity.ShopCart;
import com.nguyenchunghuu.service.CategoriesService;
import com.nguyenchunghuu.service.SanPhamService;

@Controller
@RequestMapping("/product-details")
@SessionAttributes("giohang")
public class ProductDetailController {

	@Autowired
	SanPhamService spService;
	
	@Autowired
	CategoriesService cateSV;
	
	
	@GetMapping("/{productID}")
	public String defaulDetail(@PathVariable int productID, ModelMap modelMap, HttpSession httpSession) {
		if(httpSession.getAttribute("unames") != null) {
			modelMap.addAttribute("ssUser", httpSession.getAttribute("unames"));
		}
		SanPham listSPByid = spService.getListSPByID(productID);
		modelMap.addAttribute("getSPByID", listSPByid);
		
		if(null != httpSession.getAttribute("giohang")) {
			List<ShopCart> cartPr = (List<ShopCart>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsp", cartPr.size());
		}
		modelMap.addAttribute("listDoiTuong",cateSV.getDoiTuong());
		return "productDetail";
	}
}
