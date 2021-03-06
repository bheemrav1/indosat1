<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>myCare CMS</title>

    <!-- Bootstrap Core CSS -->
    <link href='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/vendor/bootstrap/css/bootstrap.css' rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/vendor/metisMenu/metisMenu.min.css' rel="stylesheet">

    <!-- Custom CSS -->
    <link href='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/dist/css/sb-admin-2.css' rel="stylesheet">

    <!-- Custom Fonts -->
    <link href='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/vendor/font-awesome/css/font-awesome.css' rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
   
        <div id="wrapper">
        

            <!-- Navigation -->
            <div class="row background-red padding-auto ">
                <div class="col-lg-12">
                    <img src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/images/logo_indosat.png' style="height: 40px;" class="img-responsive center-block">
                    <div class="text-center">Mobile Agent</div>
                    <form action="logout" method="post"> <div class="position-absolute-right"><button type="button"  id="logout" class="btn btn-default" style="width: 130%;background-color: #c2c2c2;">Keluar</button></div></form></div>
                </div>
            </div>

            <!-- /.navbar-header -->

        </nav>
		<form id="addForm" method="post" enctype="multipart/form-data"  action="addDevice">
        <div id="page-wrapper-custom">
            <div class="row padding-top-2-5">
                <!-- Left -->
                <div class="col-lg-6">
                    <!-- Nama Produk -->
                    <div class="row">
                        <div class="col-lg-4" style="font-size:20px">
                            Nama Produk
                        </div>

                        <div class="col-lg-8">
                            <input type="text" class="form-control" placeholder="Oppo F1 Plus" style="height: 30px;font-size:16px;" id="devicename" value='${list[0]["NAME"]}' required>
                        </div>
                    </div>
                    <!-- End Nama Produk -->

                    <!-- Brand -->
                    <div class="row padding-top-5">
                        <div class="col-lg-4" style="font-size:20px">
                            Brand
                        </div>

                        <div class="col-lg-8">
                            <input type="text" class="form-control" placeholder="Oppo Mobile" style="height: 30px;font-size:16px;" id="brand" value='${list[0]["MODEL"]}' required>
                        </div>
                    </div>
                    <!-- End Brand -->

                    <!-- Unggah Foto -->

                    <div class="row padding-top-5" style="font-size:20px">
                        <div class="col-lg-12" >
                            Unggah Foto:
                        </div>
                    </div>

                    <!-- Photo Upload Big -->
                    <div class="row padding-top-5" style="font-size:27px">
                        <div class="col-lg-6" >
                            <img src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/images/add-photo-big.png' id="img1" style="width:100%" class="img-responsive">
                            <input type="file" name="pic1" id="file1" style="display: none" required />
                        </div>

                        <div class="col-lg-6">
                        </div>

                    </div>

                    <!-- Three Photo Upload -->
                    <div class="row padding-top-2-5" style="font-size:27px">
                        <div class="col-lg-2" >
                            <img src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/images/add-photo-small.png' class="img-responsive" id="img2">
                            <input type="file" name="pic2" id="file2" style="display: none" required/>
                        </div>
                        <div class="col-lg-2" >
                            <img src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/images/add-photo-small.png' class="img-responsive" id="img3">
                            <input type="file" name="pic3" id="file3" style="display: none" required/>
                        </div>
                        <div class="col-lg-2" >
                            <img src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/images/add-photo-small.png' class="img-responsive" id="img4">
                            <input type="file" name="pic4" id="file4" style="display: none" required/>
                        </div>

                        <div class="col-lg-6">
                        </div>
                    </div>

                    <div class="row padding-top-5" style="font-size:20px">
                        <div class="col-lg-12" >
                            Ketersediaan Warna:
                        </div>
                    </div>

                    <div class="row padding-top-2-5" style="font-size:20px">
                        <div class="col-lg-7" >
                            <textarea class="form-control" rows="3" placeholder="Grey, White, Black, Rose Gold" style="font-size:16px"  id="color" value='${list[0]["COLOR"]}' required></textarea>
                        </div>
                    </div>

                    

                </div>

                <!-- Right -->
                <div class="col-lg-6">
                    <!-- Harga -->
                    <div class="row">
                        <div class="col-lg-4" style="font-size:20px">
                            Harga
                        </div>

                        <div class="col-lg-8">
                            <input type="number" class="form-control" placeholder="Oppo F1 Plus" style="height: 30px;font-size:16px;" value='${list[0]["PRICE"]}' id="price" required>
                        </div>
                    </div>
                    <!-- End Harga -->

                    <!-- Spesifikasi Detail -->
                    <div class="row padding-top-20">
                        <div class="col-lg-12" style="font-size:20px">
                            Spesifikasi Detail
                        </div>
                    </div>

                    <!-- Text Area Spesifikasi Detail -->
                    <div class="row padding-top-2-5">
                        <div class="col-lg-12" style="font-size:20px">
                            <textarea class="form-control" rows="20" placeholder="* Ukuran layar: 5,5 inci"  style="font-size:16px" id="details" value='${list[0]["DETAILS"]}' required></textarea>
                        </div>
                    </div>
                </div>
                <!-- End Row Big -->
            </div>
            
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  				<div class="modal-content" style="width:100px;height:120px;position:absolute;top:44%;left:41%;background-color: Gray">
    				 <img src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/images/spinner.gif' width="130" height="130" />
  			</div><!-- /.modal-content -->
			 </div><!-- /.modal -->  
			<div id="wait" style="display:none;width:100px;height:120px;position:absolute;top:44%;left:41%;padding:2px;"> <img src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/images/spinner.gif' width="130" height="130" /></div>
        
            <div class="row">
                <div class="col-lg-12 text-center padding-top-2-5">
                <a href="/MobileCMS/home"> <button type="button" class="btn btn-default" style="width:10%; background-color: #c2c2c2; margin-right:2%;">Batal</button></a>
                <input type="submit" class="btn btn-default" style="width:10%; background-color: #c2c2c2; margin-left:2%;" id="getDevice" value="Kirim" />
                </div>
            </div>
       </div>
		</form>
 
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->


    <!-- jQuery -->

    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/vendor/jquery/jquery.min.js'></script>
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/vendor/jquery.matchHeight-min.js'></script>

    <!-- Bootstrap Core JavaScript -->
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/vendor/bootstrap/js/bootstrap.js'></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/vendor/metisMenu/metisMenu.min.js'></script>

    <!-- Custom Theme JavaScript -->
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/dist/js/sb-admin-2.js'></script>
    <script>
    $(document).ready(function() {
    	$('#myModal').modal();
        /* logout from applciation*/
   	   /*****************START********************/	
         $('#logout').on('click', function() {
 	   		var value=confirm("Anda yakin  ingin keluar?")
 	   			if(value){
 	       			location.href="logout";
 	   			}
    		});
       /*****************END**********************/

		
		$("#img1").click(function(){
			$("#file1").click();
		});
		$('#file1').change( function(event) {
			var tmppath = URL.createObjectURL(event.target.files[0]);
				if(this.files[0].size>1500000){
		    		alert("File Size more then 2 kb");
				}
				$("#img1").fadeIn("fast").attr('src',tmppath);
		});
		$("#img2").click(function(){
			$("#file2").click();
		});
		$('#file2').change( function(event) {
			var tmppath = URL.createObjectURL(event.target.files[0]);
				if(this.files[0].size>1500000){
		    		alert("File Size more then 2 kb");
				}
			    $("#img2").fadeIn("fast").attr('src',tmppath);
		});
		$("#img3").click(function(){
			$("#file3").click();
		});
		$('#file3').change( function(event) {
			var tmppath = URL.createObjectURL(event.target.files[0]);
				if(this.files[0].size>1500000){
		    		alert("File Size more then 2 kb");
				}	
			    $("#img3").fadeIn("fast").attr('src',tmppath);
		});
		$("#img4").click(function(){
			$("#file4").click();
		});
		$('#file4').change( function(event) {
			var tmppath = URL.createObjectURL(event.target.files[0]);
				if(this.files[0].size>1500000){
		    		alert("File Size more then 2 kb");
				}
			    $("#img4").fadeIn("fast").attr('src',tmppath);
		}); 


		
		 $("#addForm").submit(function(e){
			 /*
			 var deviceName=$("#devicename").val();
			 var brand=$("#brand").val();
			 var color=$("#color").val();
			 var details=$("#details").val();
			 var file4=$("#file4").val();
			 var file3=$("#file3").val();
			 var file2=$("#file2").val();
			 var file1=$("#file1").val();
			 
			 	if (deviceName == null || deviceName == "") {
			        alert("Name must be filled out");
			        $("#devicename").focus();
			        return false;
			    }
			 	if (brand == null || brand == "") {
			        alert("Name must be filled out");
			        $("#brand").focus();
			        return false;
			    }
			 	if (color == null || color == "") {
			        alert("Name must be filled out");
			        $("#color").focus();
			        return false;
			    }
			 	if (details == null || details == "") {
			        alert("Name must be filled out");
			        $("#details").focus();
			        return false;
			    }
			 	if (file4 == null || file4 == "") {
			        alert("Name must be filled out");
			        return false;
			    }
			 	if (file3 == null || file3 == "") {
			        alert("Name must be filled out");
			        return false;
			    }
			 	if (file2 == null || file2 == "") {
			        alert("Name must be filled out");
			        return false;
			    }
			 	if (file1 == null || file1 == "") {
			        alert("Name must be filled out");
			        return false;
			    }
			    
			   */
		$("#wait").show();
            e.preventDefault();
            var fd = new FormData(this);
    	  	fd.append("pic1" ,$("#file1").val());
    	  	fd.append("pic2",$("#file2").val());
     	   	fd.append("pic3",$("#file3").val());
     	  	fd.append("pic4",$("#file4").val());
    	  	fd.append("devicename",$("#devicename").val());
    	  	fd.append("brand" , $("#brand").val());
    	  	fd.append("price" , $("#price").val());
    	  	fd.append("details", $("#details").val());
    	  	fd.append("color",$("#color").val());
    	  	console.log($("#file1").val());
    	  	console.log($("#file2").val());
    	  	console.log($("#file3").val());
    	  	console.log($("#file4").val());
			$.ajax({
				url : "addDevice",
				data : fd,
			   	contentType: false,
			    processData: false,
			    type: 'POST',
			    method:'POST',
			}).done(function(data) {
				if (null != data.Status && data.Status==="SUCCESS") {
					$("#wait").hide();
					$("#img1").attr("src",'/MobileCMS/cms_mobilecrm/images/add-photo-big.png');
					$("#img2").attr("src",'/MobileCMS/cms_mobilecrm/images/add-photo-small.png');
					$("#img3").attr("src",'/MobileCMS/cms_mobilecrm/images/add-photo-small.png');
					$("#img4").attr("src",'/MobileCMS/cms_mobilecrm/images/add-photo-small.png');
					$("#devicename").val('');
					$("#brand").val('');
					$("#price").val('');
					$("#details").val('');
					$("#color").val('');
 						alert("Record Successfully inserted.");
				}else{
					$("#wait").hide();
         				alert("This Device Already there.");
					} 
			});
			e.preventDefault(); //STOP default action
			e.stopPropagation();
		});

		 $('#logout').on('click', function() {
		    	$.ajax({
					url : "logout",
					method : "POST"
				}).done(function(list) {
				 });
			 }); 
		});
	</script>
	</body>
</html>