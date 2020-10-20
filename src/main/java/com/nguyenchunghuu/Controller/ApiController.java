package com.nguyenchunghuu.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nguyenchunghuu.Entity.ShopCart;
import com.nguyenchunghuu.service.SanPhamService;
import com.nguyenchunghuu.service.UserService;

@Controller
@RequestMapping("api/")
@SessionAttributes({ "unames", "giohang" })
public class ApiController {

	@Autowired
	UserService userService;
	
	@Autowired
	SanPhamService spService;

	@GetMapping("KiemTraDangNhap")
	@ResponseBody
	public String checkLogin(@RequestParam String uname, @RequestParam String psw, ModelMap modelMap) {
		boolean ktra = userService.checkLogin(uname, psw);
		modelMap.addAttribute("unames", uname);
		return "" + ktra;
	}

	@GetMapping("AddCart")
	@ResponseBody
	public String addCart(@RequestParam int idSP, @RequestParam int idSize, @RequestParam int idMau,
			@RequestParam String tenSP, @RequestParam int giaSP, @RequestParam String tenMau,
			@RequestParam String tenSize, @RequestParam int soluongSP, @RequestParam int idCTSP, HttpSession httpSession) {

		if (httpSession.getAttribute("giohang") == null) {
			List<ShopCart> listCart = new ArrayList<>();

			ShopCart carts = new ShopCart();
			carts.setIdSP(idSP);
			carts.setIdMau(idMau);
			carts.setTenSP(tenSP);
			carts.setGiaSP(giaSP);
			carts.setTenMau(tenMau);
			carts.setTenSize(tenSize);
			carts.setSoluongSP(soluongSP);
			carts.setIdSize(idSize);
			carts.setIdCTSP(idCTSP);

			listCart.add(carts);
			httpSession.setAttribute("giohang", listCart);
			
			return listCart.size() + "";
		} else {
			List<ShopCart> listcarts = (List<ShopCart>) httpSession.getAttribute("giohang");
			int vitri = KtraSPDaTonTai(idSP, idSize, idMau, httpSession);
			if (vitri == -1) {
				
				ShopCart carts = new ShopCart();
				carts.setIdSP(idSP);
				carts.setIdMau(idMau);
				carts.setTenSP(tenSP);
				carts.setGiaSP(giaSP);
				carts.setTenMau(tenMau);
				carts.setTenSize(tenSize);
				carts.setSoluongSP(soluongSP);
				carts.setIdSize(idSize);
				carts.setIdCTSP(idCTSP);
				
				listcarts.add(carts);	
			} else {
				int soluongmoi = listcarts.get(vitri).getSoluongSP() + soluongSP;
				listcarts.get(vitri).setSoluongSP(soluongmoi);
			}
			return listcarts.size() + "";
		}		

	}

	private int KtraSPDaTonTai(int idSP, int idSize, int idMau, HttpSession httpSession) {
		if (httpSession.getAttribute("giohang") != null) {

			List<ShopCart> listcarts = (List<ShopCart>) httpSession.getAttribute("giohang");
			for (int i = 0; i < listcarts.size(); i++) {
				if (listcarts.get(i).getIdSP() == idSP && listcarts.get(i).getIdMau() == idMau
						&& listcarts.get(i).getIdSize() == idSize) {
					return i;
				}
			}
		}
		return -1;
	}
	
	/*
	 * @GetMapping("LaySoLuong")
	 * 
	 * @ResponseBody public String loadSoluong(HttpSession httpSession) { if(null !=
	 * httpSession.getAttribute("giohang")) { List<ShopCart> cartPr =
	 * (List<ShopCart>) httpSession.getAttribute("giohang"); return
	 * cartPr.size()+""; } return ""; }
	 */
	@GetMapping("updatecart")
	@ResponseBody
	public void UpdateCart(HttpSession httpSession, @RequestParam int idSP, @RequestParam int idMau, @RequestParam int idSize, @RequestParam int soluongSP) {
		if (httpSession.getAttribute("giohang") != null) {
			List<ShopCart> listcarts = (List<ShopCart>) httpSession.getAttribute("giohang");
			int vitri = KtraSPDaTonTai(idSP, idSize, idMau, httpSession);
			//int soluongmoi = listcarts.get(vitri).getSoluongSP() + soluongSP;
			listcarts.get(vitri).setSoluongSP(soluongSP);
		}
	}
	
	@GetMapping("delcart")
	@ResponseBody
	public void delCart(HttpSession httpSession, @RequestParam int idSP, @RequestParam int idMau, @RequestParam int idSize) {
		
		if (httpSession.getAttribute("giohang") != null) {
			List<ShopCart> listcarts = (List<ShopCart>) httpSession.getAttribute("giohang");
			int vitri = KtraSPDaTonTai(idSP, idSize, idMau, httpSession);
			listcarts.remove(vitri);
		}
	}
	
	@GetMapping("statusPr")
	@ResponseBody
	public Long getSoLuong(@RequestParam int idSP) {
		Long soluong = spService.getSoLuongSP(idSP);
		return soluong;
	}
	
}
