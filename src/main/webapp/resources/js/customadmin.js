

$(".sidebar-dropdown > a").click(function() {
		$(".sidebar-submenu").slideUp(300);
		if ($(this).parent().hasClass("active")) {
			$(".sidebar-dropdown").removeClass("active");
			$(this).parent().removeClass("active");
		} else {
			$(".sidebar-dropdown").removeClass("active");
			$(this).next(".sidebar-submenu").slideDown(300);
			$(this).parent().addClass("active");
		}
	});

	$("#close-sidebar").click(function() {
		$(".page-wrapper").removeClass("toggled");
	});
	$("#show-sidebar").click(function() {
		$(".page-wrapper").addClass("toggled");
	});
	

$(document).ready(function(){
	
	
	var idSP = 0;
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
	
	$("body").on("change","select#doituong", function(){
		var idDT = $(this).children("option:selected").val();
		$.ajax({
			url:"/springtest/apiAdmin/getListLoai",
			type:"GET",
			data:{				
				idDT:idDT
			},
			success: function(value){
				$("#loai").empty();
				$("#loai").append(value);
			}
		})
	})
	
	$("body").on("click",".page", function(){		
		$(".page").removeClass("active");
		$(this).addClass("active");
		var page = $(this).text();
		var startLimit = (page - 1)*5;
		$.ajax({
			url:"/springtest/apiAdmin/getListSP",
			type:"GET",
			data:{				
				startLimit:startLimit
			},
			success: function(value){
				var listBody = $("#listBody").find("tbody");
				listBody.empty();
				listBody.append(value);
			}
		})
		formatNumber();
	})
	
	$("body").on("click",".page", function(){		
		$(".page").removeClass("active");
		$(this).addClass("active");
		var page = $(this).text();
		var startLimit = (page - 1)*5;
		$.ajax({
			url:"/springtest/apiAdmin/getListSP",
			type:"GET",
			data:{				
				startLimit:startLimit
			},
			success: function(value){
				var listBody = $("#listBody").find("tbody");
				listBody.empty();
				listBody.append(value);
				formatNumber();
			}
		})
	})
	
	
	$("#checkall").change(function() {
		if(this.checked){
			$("#listBody input").each(function(){
				$(this).attr("checked", true);
			})
		} else{
			$("#listBody input").each(function(){
				$(this).attr("checked", false);
			})
		}
	})
	
	//Delete product
	$("#btnXoa").click(function() {
		$("#listBody > tbody input:checked").each(function(){
			var idSP = $(this).val();
			var This = $(this);
			$.ajax({
				url:"/springtest/apiAdmin/DelSP",
				type:"GET",
				data:{				
					idSP:idSP
				},
				success: function(value){
					This.closest("tr").remove();
				}
			})
		})
	})
	
	//upload file
	$("body").on("click",".btn-chitiet", function(){
		$(this).remove();
		
		var chititetspClone = $("#chitietsanpham").clone().removeAttr("id");

		$(".container_pr").append(chititetspClone);
	})
	
	var files = [];
	var hinh = "";
	$("#picture-pr").change(function(event) {
		files = event.target.files;
		hinh = files[0].name;
		forms = new FormData();
		forms.append("file", files[0]);
		$.ajax({
			url:"/springtest/apiAdmin/UploadFile",
			type:"POST",
			data:forms,
			contentType: false,
			processData: false,
			enctype:"multipart/form-data",
			success: function(value){
			}
		})
	})
	
	//Add product 
	
	$("body").on("click","#add",function(){
		$("#btnAdd").removeClass("hidden");
		$("#btnCapnhat").addClass("hidden");
	})
	
	$("body").on("click","#btnAdd",function(e){

		e.preventDefault();
		//$("#loader-add").addClass("spinner-border");
		var formData = $("#formData").serializeArray()
		json = {};
		arrayChiTiet = [];
		
		 $.each(formData, function(i, field){
			 
			 json[field.name] = field.value;
			 
			/* if(field.name == "doiTuong"){
				 objectDT = {};
				 objectDT["idDoiTuong"] = field.value;
				 json[field.name] = objectDT
			 }
			 
			 if(field.name == "loaisp"){
				 objectLoai = {};
				 objectLoai["idLoai"] = field.value;
				 json[field.name] = objectLoai;
			 }*/
			 
		 });
		 
		 
		 $(".container_pr > .chitietsanpham").each(function() {
			objectChiTiet = {};
			
			mauSP = $(this).find('select[name="sizeSP"]').val();
			sizeSP = $(this).find('select[name="mauSP"]').val();
			soluongSP = $(this).find('input[name="soluong"]').val();
			
			objectChiTiet["mauSP"] = mauSP;
			objectChiTiet["sizeSP"] = sizeSP;
			objectChiTiet["soluong"] = soluongSP;
			
			arrayChiTiet.push(objectChiTiet);
		})
		
		json["chitietSPs"] = arrayChiTiet;
		json["hinhSP"] = hinh;

		 
		$.ajax({
			url:"/springtest/apiAdmin/AddPr",
			type:"POST",
			data:{
				dataJson: JSON.stringify(json)
			},
			success: function(value){
				$('#formData').trigger("reset");
				
				$(".container_pr").html("");
				var chititetspClone = $("#chitietsanpham").clone().removeAttr("id");
				$(".container_pr").append(chititetspClone);
				//$("#loader-add").removeClass("spinner-border");
				$('#exampleModalLong').modal('hide')
			}
		})
		
		
	})
	
	$("body").on("click","#btnCancel",function(){
		$('#formData').trigger("reset");
		
		$(".container_pr").html("");
		var chititetspClone = $("#chitietsanpham").clone().removeAttr("id");
		$(".container_pr").append(chititetspClone);
	})
	
	//Show product update btnCancel
	$("body").on("click",".btnUpdate",function(){
		idSP = $(this).attr("data-sp");
		
		$("#btnCapnhat").removeClass("hidden");
		$("#btnAdd").addClass("hidden");
		
		$.ajax({
			url:"/springtest/apiAdmin/GetSPByID",
			type:"POST",
			data:{
				idSP: idSP
			},
			success: function(value){				
				$("#tenSP").val(value.tenSP);
				$("#giaTien").val(value.giaTien);
				$("#moTa").val(value.moTa);
				$("#doituong").val(value.doiTuong.idDoiTuong);
				$("#loai").val(value.loaisp.idLoai);
				
				$(".container_pr").html("");
			
				for(var i=0; i<value.chiTietSPs.length; i++){
					
					
					var chititetspClone = $("#chitietsanpham").clone().removeAttr("id");
					
					
					
					chititetspClone.find("#size").val(value.chiTietSPs[i].mauSP.idMau);
					
					chititetspClone.find("#color").val(value.chiTietSPs[i].sizeSP.idSize);
					
					chititetspClone.find("#soluong").val(value.chiTietSPs[i].soLuong);
					
					if(i < (value.chiTietSPs.length)-1){
						chititetspClone.find(".btn-chitiet").remove();
					}
					
					$(".container_pr").append(chititetspClone);
				}
				
				$('#exampleModalLong').modal('show')
			}
		})
	})
	
	//Update pr
	//btnCapnhat
	
	$("body").on("click","#btnCapnhat",function(e){
		
		e.preventDefault();
		
		var formData = $("#formData").serializeArray()
		json = {};
		arrayChiTiet = [];
		
		 $.each(formData, function(i, field){			 
			 json[field.name] = field.value;
		 });
		 
		 $(".container_pr > .chitietsanpham").each(function() {
				objectChiTiet = {};
				
				mauSP = $(this).find('select[name="sizeSP"]').val();
				sizeSP = $(this).find('select[name="mauSP"]').val();
				soluongSP = $(this).find('input[name="soluong"]').val();
				
				objectChiTiet["mauSP"] = mauSP;
				objectChiTiet["sizeSP"] = sizeSP;
				objectChiTiet["soluong"] = soluongSP;
				
				arrayChiTiet.push(objectChiTiet);
			})
			json["idSP"] = idSP;
			json["chitietSPs"] = arrayChiTiet;
			json["hinhSP"] = hinh;
			
			$.ajax({
				url:"/springtest/apiAdmin/CapNhat",
				type:"POST",
				data:{
					dataJson: JSON.stringify(json)
				},
				success: function(value){
					$('#exampleModalLong').modal('hide')
				}
			})
			$('#exampleModalLong').modal('hide')
	})
	
})