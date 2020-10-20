package com.nguyenchunghuu.Controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nguyenchunghuu.Entity.ChiTietSP;
import com.nguyenchunghuu.Entity.DoiTuong;
import com.nguyenchunghuu.Entity.Json_SanPham;
import com.nguyenchunghuu.Entity.Loaisp;
import com.nguyenchunghuu.Entity.MauSP;
import com.nguyenchunghuu.Entity.SanPham;
import com.nguyenchunghuu.Entity.SizeSP;
import com.nguyenchunghuu.service.CategoriesService;
import com.nguyenchunghuu.service.SanPhamService;

@Controller
@RequestMapping("/apiAdmin")
public class ApiAdminController {

	@Autowired
	SanPhamService sanphamService;
	
	@Autowired
	CategoriesService cateSer;

	@GetMapping(path = "getListSP", produces = "plain/text;charset=UTF-8")
	@ResponseBody
	public String getSP_page(@RequestParam int startLimit) {

		String html = "";
		List<SanPham> listsp = sanphamService.getListSP(startLimit);
		for (SanPham sp : listsp) {
			html += "<tr>";
			html += "<td><input type=\"checkbox\" id=\"checkthis\" value=\"" + sp.getIdSP() + "\"/></td>";
			html += "<td> <img style=\"width: 55px;\" src=\"resources/img/product/"+sp.getHinhSP()+"\"></td>";
			html += "<td data-idSP=\"" + sp.getIdSP() + "\">" + sp.getTenSP() + "</td>";
			html += "<td class=\"price\">VNĐ " + sp.getGiaTien() + "</td>";
			html += "<td>\r\n" + "<ul class=\"list-inline m-0\">\r\n" + "    <li class=\"list-inline-item\">\r\n"
					+ "      <button class=\"btn btn-success btn-sm rounded-0 btnUpdate\" data-sp=\""+sp.getIdSP()+"\" type=\"button\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Edit\"><i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i></button>\r\n"
					+ "    </li>\r\n" + "    <li class=\"list-inline-item\">\r\n"
					+ "       <button class=\"btn btn-danger btn-sm rounded-0\" type=\"button\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Delete\"><i class=\"fa fa-trash-o\" aria-hidden=\"true\"></i></button>\r\n"
					+ "    </li>\r\n" + "</ul>\r\n" + "</td>";
			html += "</tr>";
		}
		return html;
	}

	
	@GetMapping(path = "getListLoai", produces = "plain/text;charset=UTF-8")
	@ResponseBody
	public String listLoai(@RequestParam int idDT) {
		List<Loaisp> loai = cateSer.getLoaiByID(idDT);
		String html1 ="";
		for (Loaisp loaisp : loai) {
			html1 += "<option value='"+loaisp.getIdLoai()+"'>"+loaisp.getTenLoai()+"</option>";
		}
	
		return html1;
	}
	
	@GetMapping("DelSP")
	@ResponseBody
	public String delSPByIdSP(@RequestParam int idSP) {
		sanphamService.DelSPByID(idSP);
		return "";
	}

	@Autowired
	ServletContext context;

	@PostMapping("UploadFile")
	@ResponseBody
	public String uploadfiles(MultipartHttpServletRequest multipartHttpServletRequest) {

		String path_save_file = context.getRealPath("/resources/img/product/");
		Iterator<String> listName = multipartHttpServletRequest.getFileNames();
		MultipartFile mpf = multipartHttpServletRequest.getFile(listName.next());

		File file_save = new File(path_save_file + mpf.getOriginalFilename());
		try {
			mpf.transferTo(file_save);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * @param dataJson
	 */
	@PostMapping("AddPr")
	@ResponseBody
	public void AddProduct(@RequestParam String dataJson) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();

		
		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode jsonObject;
		try {
			SanPham sanpham = new SanPham();
			
			jsonObject = objectMapper.readTree(dataJson);
			
			DoiTuong dt = new DoiTuong();
			dt.setIdDoiTuong(jsonObject.get("doiTuong").asInt());
			
			Loaisp loai = new Loaisp();
			loai.setIdLoai(jsonObject.get("loaisp").asInt());
			
			JsonNode jsonChitietSP = jsonObject.get("chitietSPs");
			Set<ChiTietSP> listCTSP = new HashSet<>();
			for (JsonNode jsonNode : jsonChitietSP) {

				ChiTietSP ctsp = new ChiTietSP();

				MauSP mau = new MauSP();
				SizeSP size = new SizeSP();

				mau.setIdMau(jsonNode.get("mauSP").asInt());
				size.setIdSize(jsonNode.get("sizeSP").asInt());

				ctsp.setMauSP(mau);
				ctsp.setSizeSP(size);
				ctsp.setSoLuong(jsonNode.get("soluong").asInt());
				ctsp.setNgayNhap(dtf.format(now));
				
				listCTSP.add(ctsp);
			}
			
			sanpham.setChiTietSPs(listCTSP);
			sanpham.setDoiTuong(dt);
			sanpham.setLoaisp(loai);
			sanpham.setStatus(1);
			sanpham.setTenSP(jsonObject.get("tenSP").asText());
			sanpham.setGiaTien(jsonObject.get("giaTien").asInt());
			sanpham.setMoTa(jsonObject.get("moTa").asText());
			sanpham.setHinhSP(jsonObject.get("hinhSP").asText());
			
			sanphamService.Addproduct(sanpham);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
	
	@PostMapping("CapNhat")
	@ResponseBody
	public void CapNhatPr(@RequestParam String dataJson) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();

		
		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode jsonObject;
		try {
			SanPham sanpham = new SanPham();
			
			jsonObject = objectMapper.readTree(dataJson);
			
			DoiTuong dt = new DoiTuong();
			dt.setIdDoiTuong(jsonObject.get("doiTuong").asInt());
			
			Loaisp loai = new Loaisp();
			loai.setIdLoai(jsonObject.get("loaisp").asInt());
			
			JsonNode jsonChitietSP = jsonObject.get("chitietSPs");
			Set<ChiTietSP> listCTSP = new HashSet<>();
			for (JsonNode jsonNode : jsonChitietSP) {

				ChiTietSP ctsp = new ChiTietSP();

				MauSP mau = new MauSP();
				SizeSP size = new SizeSP();

				mau.setIdMau(jsonNode.get("mauSP").asInt());
				size.setIdSize(jsonNode.get("sizeSP").asInt());

				ctsp.setMauSP(mau);
				ctsp.setSizeSP(size);
				ctsp.setSoLuong(jsonNode.get("soluong").asInt());
				ctsp.setNgayNhap(dtf.format(now));
				
				listCTSP.add(ctsp);
			}
			
			sanpham.setChiTietSPs(listCTSP);
			sanpham.setDoiTuong(dt);
			sanpham.setLoaisp(loai);
			sanpham.setTenSP(jsonObject.get("tenSP").asText());
			sanpham.setGiaTien(jsonObject.get("giaTien").asInt());
			sanpham.setMoTa(jsonObject.get("moTa").asText());
			sanpham.setHinhSP(jsonObject.get("hinhSP").asText());
			sanpham.setIdSP(jsonObject.get("idSP").asInt());
			
			sanphamService.UpdatePr(sanpham);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
	
	@PostMapping(path = "GetSPByID", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Json_SanPham ListSPByID(@RequestParam int idSP) {
		
		Json_SanPham json_SanPham = new Json_SanPham();
		SanPham sanpham = sanphamService.getListSPByID(idSP);
		
		json_SanPham.setIdSP(sanpham.getIdSP());
		json_SanPham.setTenSP(sanpham.getTenSP());
		json_SanPham.setGiaTien(sanpham.getGiaTien());
		json_SanPham.setMoTa(sanpham.getMoTa());
		json_SanPham.setHinhSP(sanpham.getHinhSP());
		
		Loaisp loai = new Loaisp();
		DoiTuong dt = new DoiTuong();
		
		loai.setIdLoai(sanpham.getLoaisp().getIdLoai());
		loai.setTenLoai(sanpham.getLoaisp().getTenLoai());
		
		dt.setIdDoiTuong(sanpham.getDoiTuong().getIdDoiTuong());
		dt.setTenDoiTuong(sanpham.getDoiTuong().getTenDoiTuong());
		
		
		json_SanPham.setDoiTuong(dt);
		json_SanPham.setLoaisp(loai);
		
		Set<ChiTietSP> ctsp = new HashSet<>();
		for (ChiTietSP val : sanpham.getChiTietSPs()) {
			ChiTietSP ctsp1 = new ChiTietSP();
			ctsp1.setIdChiTietSP(val.getIdChiTietSP());
			
			MauSP mau = new MauSP();
			mau.setIdMau(val.getMauSP().getIdMau());
			mau.setTenMau(val.getMauSP().getTenMau());
			
			SizeSP size = new SizeSP();
			size.setIdSize(val.getSizeSP().getIdSize());
			size.setTenSize(val.getSizeSP().getTenSize());
			
			ctsp1.setMauSP(mau);
			ctsp1.setSizeSP(size);
			ctsp1.setSoLuong(val.getSoLuong());
			
			ctsp.add(ctsp1);
		}
		json_SanPham.setChiTietSPs(ctsp);
		
		
		return json_SanPham;		
	}

}
