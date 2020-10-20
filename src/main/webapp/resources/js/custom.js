$(document).ready(function(){
	$(window).scroll(function() {    
	    var scroll = $(window).scrollTop();

	    if (scroll >= 10) {
	        $(".header").addClass("sticky");
	    } else {
	        $(".header").removeClass("sticky");
	    }
	});
	
	$("#btnLogin").click(function(){
		var uname = $("#uname").val();
		var psw = $("#psw").val();
		$.ajax({
			url:"/springtest/api/KiemTraDangNhap",
			type:"GET",
			data:{
				uname:uname,
				psw:psw
			},
			success: function(value){
				if(value == "true"){
					link = window.location.href;
					linkRef = link.replace("login","");
					window.location = linkRef;
				} else {
					$("#Kqua").text("Đăng nhập thất bại");
				}
			}
		})
	});
	
	$("#dangki").click(function(){
		$("#containerLogin").hide();
		$("#containerSignup").show();
		$("#dangnhap").css("display","block");
		$("#dangki").hide();
	});
	
	$("#dangnhap").click(function(){
		$("#containerLogin").show();
		$("#containerSignup").hide();
		$("#dangnhap").css("display","none");
		$("#dangki").show();
	});
	
	
	$(".btn_cart").click(function(){
		var idCTSP = $(this).attr("data-idCTSP");
		var idcolor = $(this).closest("tr").find(".colorPr").attr("data-color");
		var color = $(this).closest("tr").find(".colorPr").text();
		
		var idsize = $(this).closest("tr").find(".sizePr").attr("data-size");
		var size = $(this).closest("tr").find(".sizePr").text();
		
		var count = $("#count").val();
		
		var price = $("#price").attr("data-price"); 
		
		var nameProduct = $("#namePrd").attr("data-namePr");
		var idPr = $("#namePrd").attr("data-idSP");
		
		//alert(color+"  "+idcolor+"  "+count+"  "+nameProduct+"  "+price+"  "+size+" "+idPr);
		//$(this).parent().parent().
		$.ajax({
			url:"/springtest/api/AddCart",
			type:"GET",
			data:{
				idSP:idPr,
				idMau:idcolor,
				idSize:idsize,
				tenSP:nameProduct,
				giaSP:price,
				tenMau:color,
				tenSize:size,
				soluongSP:count,
				idCTSP: idCTSP
			},
			success: function(value){
				if(value != null){
					$("#show_cart").find("div").css("display","block");
					$(".soluongSP").text(value);
				}	
			}
		})/*.done(function(){
			$.ajax({
				url:"/springtest/api/LaySoLuong",
				type:"GET",
				success: function(value){
					if(value != null){
						$("#show_cart").find("div").css("display","block");
						$(".soluongSP").text(value);
					}	
				}
			})
		});*/
	});
	
	
	
	//Tăng số lượng giỏ hàng
	$(".inc").click(function(){
		
			var soluong = $(this).closest("tr").find(".price_total").val();
			
			var giatien = $(this).closest("tr").find(".price_prd").attr("data-price");
			
			var tong = (parseInt(soluong)+1) * parseInt(giatien);
			
			$(this).closest("tr").find(".total-pr").text("VNĐ " + tong);
			GanTong(true);	
			formatNumber();

			var soluongSp = parseInt(soluong) + 1;
			var idSP = $(this).closest("tr").find(".idSP").attr("data-idSP");
			var idMau =  $(this).closest("tr").find(".color_pr").attr("data-mau");
			var idSize =  $(this).closest("tr").find(".size_pr").attr("data-size");
			
			$.ajax({
				url:"/springtest/api/updatecart",
				type:"GET",
				data:{
					idSP:idSP,
					idMau:idMau,
					idSize:idSize,
					soluongSP:soluongSp
				},
				success: function(value){
						
				}
			});	
	});
	
	//Giảm số lượng giỏ hàng
	$(".dec").click(function(){

			var soluong = $(this).closest("tr").find(".price_total").val();
			var giatien = $(this).closest("tr").find(".price_prd").attr("data-price");
			if(soluong == 0){
				var tong = parseInt(soluong) * parseInt(giatien);
			}
			else{
				var tong = (parseInt(soluong)-1) * parseInt(giatien);
			}
			
			
			$(this).closest("tr").find(".total-pr").text("VNĐ "+tong);
			GanTong(true);
			formatNumber();
			
			var soluongSp = parseInt(soluong) - 1;
			var idSP = $(this).closest("tr").find(".idSP").attr("data-idSP");
			var idMau =  $(this).closest("tr").find(".color_pr").attr("data-mau");
			var idSize =  $(this).closest("tr").find(".size_pr").attr("data-size");
			
			$.ajax({
				url:"/springtest/api/updatecart",
				type:"GET",
				data:{
					idSP:idSP,
					idMau:idMau,
					idSize:idSize,
					soluongSP:soluongSp
				},
				success: function(value){
						
				}
			});
		
	});
	
	
	//Số lượng change
	$(".price_total").change(function(){
		var soluong = $(this).closest("tr").find(".price_total").val();
		var giatien = $(this).closest("tr").find(".price_prd").attr("data-price");
		
		var tong = parseInt(soluong) * parseInt(giatien);
		
		$(this).closest("tr").find(".total-pr").text("VNĐ "+tong);
		GanTong(true);
		var soluongSp = parseInt(soluong);
		var idSP = $(this).closest("tr").find(".idSP").attr("data-idSP");
		var idMau =  $(this).closest("tr").find(".color_pr").attr("data-mau");
		var idSize =  $(this).closest("tr").find(".size_pr").attr("data-size");
		formatNumber();
		$.ajax({
			url:"/springtest/api/updatecart",
			type:"GET",
			data:{
				idSP:idSP,
				idMau:idMau,
				idSize:idSize,
				soluongSP:soluongSp
			},
			success: function(value){
					
			}
		});
	});
	
	//Tính tổng
	function GanTong(isEventChange){
		var tongtien = 0;
		$(".total-pr").each(function() {
			var giatien = $(this).text().replace('VNĐ','');
			var giatien1 = giatien.replace('.','');
			tongtien = tongtien + parseInt(giatien1);
			$("#total").text("VNĐ "+tongtien);
			$("#total1").text("VNĐ "+tongtien);
			$("#totals").text("VNĐ "+tongtien);
		})
	}
	
	//Xóa giỏ hàng
	$(".btn-del").click(function(){
		
		var self = $(this);
		var idSP = $(this).closest("tr").find(".idSP").attr("data-idSP");
		var idMau =  $(this).closest("tr").find(".color_pr").attr("data-mau");
		var idSize =  $(this).closest("tr").find(".size_pr").attr("data-size");
		$.ajax({
			url:"/springtest/api/delcart",
			type:"GET",
			data:{
				idSP:idSP,
				idMau:idMau,
				idSize:idSize,
			},
			success: function(value){
				self.closest("tr").remove();
				GanTong(true);
				formatNumber();
			}
		});
	});
	
	//Formart money
	formatNumber();
	function formatNumber() {
		$(".price").each(function() {
			var nStr = $(this).text();
			var decSeperate = ",";
			var groupSeperate = ".";
	        x = nStr.split(decSeperate);
	        x1 = x[0];
	        x2 = x.length > 1 ? '.' + x[1] : '';
	        var rgx = /(\d+)(\d{3})/;
	        while (rgx.test(x1)) {
	            x1 = x1.replace(rgx, '$1' + groupSeperate + '$2');
	        }
	        $(this).text(x1 + x2);
		})
    }
	
	getStatusProduct();
	
	function getStatusProduct() {
		$(".statusPr").each(function(){
			var idSP = $(this).attr("data-idsp");
			var This = $(this);
			$.ajax({
				url:"/springtest/api/statusPr",
				type:"GET",
				data:{
					idSP:idSP
				},
				success: function(value){
					if(value == 0){
						This.addClass("stockout");
						This.text("out of stock");
					} else {
						This.addClass("new");
						This.text("new");
					}
				}
			})
		})
	}
	
})