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
                    <form action="" method="post"> <div class="position-absolute-right"><button id="logout" type="button" class="btn btn-default" style="width: 130%;background-color: #c2c2c2;">Keluar</button></div></form></div>
            </div>
            <!-- /.navbar-header -->
        </nav>
        <div id="page-wrapper-custom">
            <!-- Header -->
            <div class="row padding-top-2-5">
                <h3>Daftar Perangkat</h3>
            </div>
            <!-- Buttons -->
            <div class="row text-center-vertical" style="padding-top:40px;">
                <div class="col-lg-6 no-padding">
                    <img id="refresh_img" src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/images/refresh.png'> 
                    <span style="padding-left:10px;" id="refresh"><b>Refresh</b></span>
                </div>
                <div class="col-lg-6 "><form action="device_page" method="post">
                      <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 90px;background-color: #c2c2c2;" id="Pilihan" disabled>Pilihan
                      <span class="caret"></span></button>
                      <ul class="dropdown-menu">
                        <li><a href="#" id="edit">Ubah</a></li>
                        <li><a href="#" id="remove">Hapus</a></li>
                      </ul>
                    <a href='/MobileCMS/device_page'><button type="button" class="btn btn-default" style="width: 90px;background-color: #c2c2c2;" >Tambahan</button></a>
   					 <button type="button" class="btn btn-default"  style="width: 90px;background-color: #c2c2c2;" id="kirim" disabled>Kirim</button></form>
                </div>
            </div>

            <!-- Table -->
            <div class="row" style="padding-top:20px">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead style="background-color: #ff0000;color: #fff;">
                            <tr>
                                <th></th>
                                <th>No</th>
                                <th>Nama Produk</th>
                                <th>Brand</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody class="tbody">
                        </tbody>
                    </table>
                </div>
                <!-- <div class="holder"> </div> -->
            </div>
            <!-- End Table -->

        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm//vendor/jquery/jquery.min.js'></script>
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm//vendor/jquery/jPages.min.js'></script>
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm//vendor/jquery/Pagination.js'></script>
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/vendor/jquery.matchHeight-min.js'></script>
    <!-- Bootstrap Core JavaScript -->
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm//vendor/bootstrap/js/bootstrap.js'></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm//vendor/metisMenu/metisMenu.min.js'></script>
    <!-- Custom Theme JavaScript -->
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm//dist/js/sb-admin-2.js'></script>
    <script type="text/javascript">
     $(document).ready(function (){
    	startRefresh();
    	loadDetails();
    	$('#kirim').attr('disabled',true);
    	$('#Pilihan').attr('disabled',true);

        var click="";
	    $('#edit').on('click', function() {
	    	 $('#kirim').removeAttr('disabled');
	    	 click="edit";
	    	 //location.href = 'add_device.jsp';
		 });
		 
	    $('#remove').on('click', function() {
	    	$('#kirim').removeAttr('disabled');
	    	click="remove";
		 });
	    $(document).on('click', '.check', function(){
	    	enableButton();
	    });

	    $('#kirim').on('click', function() {
	        var values=[];
	        var i=0;
	        
	    	$('[name=case]:checked').each(function () {
	        	var $item = $(this).closest("tr");
		    	var name = $item.find("td:nth-child(3)").text();
	             values[i]=name;
	             i++;
	        });
		    
			    if(click==="edit"){
				    for(i=0;i<=values.length-1;i++){
			    		var win = window.open('editDeviceDetails?name='+values[i], '_blank');
				    }
			 		//location.href="editDeviceDetails?name="+values[0];
			    }
			    else if(click==="remove" && values[0]!=""){
				     console.log("name 2: "+values);
				 	
			    	$.ajax({
		  				url : "deleteDeviceDetails",
		  				data : {
							"name":values.toString(),
						},
		  				method : "POST"
		  			}).done(function(data) {
		  				if (null != data.Status && data.Status === "SUCCESS") {
							alert("Record Deleted Successfully");	
		  					loadDetails();
		  			    	$('#kirim').attr('disabled',true);
		  			    	$('#Pilihan').attr('disabled',true);	  					
		  				}else {
							alert("Record Deleted Unsuccessfully");
							loadDetails();	
						    }
				    });
				}
			    else{
					alert("Please select checkbox");
				    } 	
		 });

	    $(document).on('click', '.edit', function(){
	    	var $item = $(this).closest("tr");
	    	var name = $item.find("td:nth-child(3)").text();
	    	location.href="editDeviceDetails?name="+name;

	    	/* $.ajax({
				url : "/MobileCMS/editDeviceDetails?name="+name,
				method : "POST"
			}).done(function(list) {
				console.log("Success");
			 }); */
		 });
		 
	   /*  $("div.holder").jPages({
	    containerID: "table",
	    perPage: 15,
	    keyBrowse: true,
	    scrollBrowse: true
	    }); */
	    
    });
     function startRefresh() {
 	    setTimeout(startRefresh,30000);
 	    loadDetails();
 	}

     $(document).on('click', '#refresh', function(){
    		$("#refresh_img").attr("src",'/MobileCMS/cms_mobilecrm/images/loader.gif');
     	 	    setTimeout(startRefresh,30000);
    	 	    loadDetails();
    		$("#refresh_img").attr("src",'/MobileCMS/cms_mobilecrm/images/refresh.png');
    		
     });

     /* logout from applciation*/
	   /*****************START********************/	
      $('#logout').on('click', function() {
	   		var value=confirm("Anda yakin  ingin keluar?")
	   			if(value){
	       			location.href="logout";
	   			}
 		});
 	 /*****************END**********************/

     
 	function enableButton() {
 		var n = $( "input:checked" ).length;
 		if(n>1){
 			$('#Pilihan').removeAttr('disabled');
 	 	}else{
 	 		$('#Pilihan').attr('disabled',true);
 	 	 }
	 } 
 	function loadDetails() {
	    var list_data = [];
			$.ajax({
				url : "getdetails",
				method : "POST",
			}).done(function(list) {
				if (null != list.Status && list.Status === "SUCCESS") {
					list_data= list.data;
   				}
			
			var thead=thead+'</tr>';
			$(".table tbody").html("");
			var tbody = '';
			for(var i=0;i<list_data.length;i++){
				obj =list_data[i];
				tbody = tbody+'<tr>';
						tbody=tbody+'<td><input name="case" type = "checkbox" class="text-center check"/></td>';
						tbody=tbody+'<td><span class="'+obj.NO+'">'+obj.NO+'</span></td>';
						tbody=tbody+'<td><span class="'+obj.NAME+'">'+obj.NAME+'</span></td>';
						tbody=tbody+'<td><span class="'+obj.BRAND+'">'+obj.BRAND+'</span></td>';
						tbody=tbody+'<td><input type = "button" class="btn btn-default edit" style="width: 90px;background-color: #c2c2c2;" value="Edit"/></td>';
				tbody = tbody+'<tr>';
			}
			$(".table tbody").html(tbody);

		});
    }

    </script>
</body>
</html>
