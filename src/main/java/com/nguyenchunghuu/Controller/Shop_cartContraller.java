package com.nguyenchunghuu.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenchunghuu.Entity.ChiTietHD;
import com.nguyenchunghuu.Entity.ChiTietHDID;
import com.nguyenchunghuu.Entity.HoaDon;
import com.nguyenchunghuu.Entity.ShopCart;
import com.nguyenchunghuu.service.CategoriesService;
import com.nguyenchunghuu.service.ChiTietHDService;
import com.nguyenchunghuu.service.HoaDonService;

@Controller
@RequestMapping("/shop-cart")
public class Shop_cartContraller {

	@Autowired
	HoaDonService hdService;
	
	@Autowired
	ChiTietHDService chitiethdService;
	
	@Autowired
	CategoriesService cateSV;

	@GetMapping
	public String shopcartDefault(HttpSession httpSession, ModelMap modelMap) {
		if(httpSession.getAttribute("unames") != null) {
			modelMap.addAttribute("ssUser", httpSession.getAttribute("unames"));
		}
		
		
		int tong = 0;
		if (httpSession.getAttribute("giohang") != null) {
			List<ShopCart> listCart = (List<ShopCart>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsp", listCart.size());
			modelMap.addAttribute("listprd", listCart);
			for (ShopCart sc : listCart) {
				tong = tong + (sc.getSoluongSP() * sc.getGiaSP());
			}
			modelMap.addAttribute("tong", tong);
		}
		modelMap.addAttribute("listDoiTuong",cateSV.getDoiTuong());
		return "shop-cart";
	}

	@PostMapping
	public String addCheckout(HttpSession httpSession, @RequestParam int soDT, @RequestParam String tenKH,
			@RequestParam String diaChi, @RequestParam String ghiChu) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		// ngayLap = formatter.format(date).toString();
		if (httpSession.getAttribute("giohang") != null) {
			List<ShopCart> listCart = (List<ShopCart>) httpSession.getAttribute("giohang");

			HoaDon hd = new HoaDon();
			hd.setDiaChi(diaChi);
			hd.setGhiChu(ghiChu);
			hd.setTenKH(tenKH);
			hd.setSoDT(soDT);
			hd.setNgayLap(formatter.format(date).toString());
			hd.setTinhTrang("Đang xử lý");

			int idHD = hdService.addHD(hd);

			if (idHD > 0) {
				Set<ChiTietHD> cthds = new HashSet<>();
				for (ShopCart shopCart : listCart) {
					
					ChiTietHDID ctHDiD = new ChiTietHDID();
					ctHDiD.setIdChiTietSP(shopCart.getIdCTSP());
					ctHDiD.setIdHD(hd.getIdHD());

					ChiTietHD ctHD = new ChiTietHD();
					ctHD.setChitiethdID(ctHDiD);
					ctHD.setGiatien(shopCart.getGiaSP());
					ctHD.setSoluong(shopCart.getSoluongSP());
					
					chitiethdService.addCTHD(ctHD);
					
				}
			} else {
				System.out.println("Thêm thất bại?");
			}

		}
		return "redirect:/";
	}
}
