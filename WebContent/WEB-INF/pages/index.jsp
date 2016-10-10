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
                    <img src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/images/logo_indosat.png' style="height: 40px;' class="img-responsive center-block">
                    <div class="text-center">Mobile Agent</div>
                    <!-- <div class="position-absolute-right"><button type="button" class="btn btn-default" style="width: 130%;background-color: #c2c2c2;">Keluar</button></div> -->
                </div>
            </div>


            <!-- /.navbar-header -->



        </nav>

        <div id="page-wrapper-custom">
            <!-- Header Body -->
            <div class="row padding-top-5">
                <div class="col-lg-6 col-lg-offset-3 text-center">
                    <h2>Selamat Datang</h2>
                    <h2>di Product Information Catalogue</h2>
                </div>
            </div>

            <!-- Box -->
            <div class="row padding-top-5">
                <div class="col-lg-4 col-lg-offset-4 background-grey-box">
                    <div class="row" style="padding:70px 0">
                        <div class="col-lg-12">
                			<div>
							<%-- 	<c:out value="${msg}" escapeXml="false" />   --%>
							<c:set var="msg" value="${msg}" />
							</div>
                            <form action="login" method="post" id="loginform">
                            <!-- ID -->
                            <div class="row">
                                <div class="col-lg-10 col-lg-offset-1">
                                    <input type="text" class="form-control" placeholder="ID Pengguna" name="userid" id="userid" required>
                                </div>
                            </div>

                            <!-- Password -->
                            <div class="row margin-top-form">
                                <div class="col-lg-10 col-lg-offset-1">
                                    <input type="password" class="form-control" placeholder="Kata Sandi" name="password" id="password" required>
                                </div>
                            </div>

							<div class="row margin-top-form">
                                <div class="col-lg-10 col-lg-offset-1">
                                    <input type="hidden" class="form-control" placeholder="Kata Sandi" name="systemCookies" id="systemCookies" >
                                </div>
                            </div>
                            <!-- Ingatkan Saya -->
                            <div class="row margin-top-form-small">
                               <div class="col-lg-10 col-lg-offset-1">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="" name="remember" id="remember"">Ingatkan Saya
                                    </label>
                                </div>
                            </div>
                            </div>
                            <!-- Lupa Kata Sandi -->
                            <div class="row margin-top-form">
                               <div class="col-lg-12 text-center">
                                <a href="#" data-toggle="modal" data-target="#forgetPassword">Lupa kata sandi?</a>
                            </div>
                            </div>

                            <!-- Masuk -->
                            <div class="row margin-top-form">
                               	<div class="col-lg-12 text-center">
                                	<button type="submit" class="btn btn-default" style="width: 30%;background-color: #898989;">Masuk</button>
                           		</div>
                            </div>
						</form>
                    </div>
                </div>
					<div class="modal fade" id="forgetPassword" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="viewModalLabel">Enter User Id / Email</h4>
							      </div>
							      <div class="modal-body">
							        <form>
							        	
							        <div class="form-group">
							            <label for="recipient-name" class="control-label">MSISDN Number:</label>
							            <input type="text" class="form-control"  id="msisdn">
							          </div>
							          	
							          <div class="form-group">
							            <label for="recipient-name" class="control-label">UserId / Email:</label>
							            <input type="email" class="form-control"  id="emailId">
							          </div>
							        </form>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal" id="userDetails">SEND</button>
							      </div>
							    </div>
							  </div>
							</div>
            </div>
        </div>
        <!-- End Box -->
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
    <script src='<c:out value="${pageContext.request.contextPath}"/>/cms_mobilecrm/vendor/jquery/jquery.cookie.js' type="text/javascript"></script>
    <script>

    $(document).ready(function (){
    	$('#userDetails').attr('disabled',true);
    	$("#emailId").val('');
    	$("#msisdn").val('');
    	var list1="${msg}";
    	console.log(list1);
    	if(list1==="Login_Fail"){
			alert("Maaf, Login gagal \n    Mohan Masukan \n  email/kata sandi yang benar");
			console.log(list1);
        }
        
    	
    	$('#emailId').keypress(function(e) {
    	 var email=$("#emailId").val();
    	 var msisdn=$("#msisdn").val();
			if(email.length>10||msisdn.length>10){        	
    			$('#userDetails').removeAttr('disabled');
			}else{
				$('#userDetails').attr('disabled',true);
			}
		 });
    	$('#msisdn').keypress(function() {
       	 var email=$("#emailId").val();
    	 var msisdn=$("#msisdn").val();
			if(email.length>10||msisdn.length>10){        	
    			$('#userDetails').removeAttr('disabled');
			}else{
				$('#userDetails').attr('disabled',true);
			}
    	});
	    $('#userDetails').on('click', function() {
	    	var email = $("#emailId").val();
	    	var msisdn = $("#msisdn").val();
	    	$.ajax({
				url : "forgot",
				data:{"userId":email,"msisdn":msisdn},
				method : "POST"
			}).done(function(list) {
				if(null != list && list.Status === "SUCCESS"){
					$("#emailId").val('');
			    	$("#msisdn").val('');
					alert("Check your mail box for the password.");
				}else if (null != list && list.Status === "FAILTURE"){
					alert("Emai ID Or MSISDN Not Found.");
				}	
			 });
		 });

	    $('#userid').val($.cookie('userid')).change();
	    //alert($('#password').val($.cookie('password')).change());  
	    $('#remember').click(function()
	     {
		     $('#systemCookies').val('yes');
	/*	         var userid = $('#userid').val();
	         var password = $('#password').val();    
	         //alert(userid);        
	         // set cookies to expire in 14 days
	         $.cookie('userid', userid, { expires: 14 });
	         $.cookie('password', password, { expires: 14 });        
	  */               
	     });
	 });
    </script>
	<script>

	</script>   
</body>

</html>

//commit
