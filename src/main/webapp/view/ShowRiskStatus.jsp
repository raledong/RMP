<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"></meta>
<title>风险状态</title>
 
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="/RMP/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet" href="/RMP/bootstrap/AdminLTE-2.3.7/plugins/datatables/dataTables.bootstrap.css">
<!-- Theme style -->
<link rel="stylesheet" href="/RMP/bootstrap/AdminLTE-2.3.7/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="/RMP/bootstrap/AdminLTE-2.3.7/dist/css/skins/_all-skins.min.css">

</head>



 
  
  
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">

  <header class="main-header">
  	<nav class="navbar navbar-static-top">
  		<div class="container">
  			<div class="navbar-header">
  				<a href="#" class="navbar-brand"><b>RiskManageProject</b></a>
  			</div>
  			
  			<!-- Navbar Right Menu -->
  			<div class="navbar-custom-menu">
  				<ul class="nav navbar-nav">
  				<!-- User Account Menu -->
  					<li class="dropdown user user-menu">
  						<!-- Menu Toggle Button -->
  						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
  							<span class="hidden-xs">Manager</span>
  						</a>
  						<ul class="dropdown-menu">
  							<!-- The user image in the menu -->
  							<li class="user-header">
  								<img alt="User Image" src="/RMP/bootstrap/AdminLTE-2.3.7/dist/img/user2-160x160.jpg">
  								<p>Manager - Web Developer
  									<small>Member since Nov. 2012</small>
  								</p>
  							</li>
  							<!-- Menu Footer-->
  							<li class="user-footer">
  								<div class="pull-right">
  									<a href="/RMP/view/Login.jsp" class="btn btn-default btn-flat">Sign out</a>
  								</div>
  							</li>
  						</ul>
  					</li>
  				</ul>
  			</div><!-- /.navbar-custom-menu -->
  		</div><!-- /.container -->
  	</nav>
  </header>
  
  
  
  
  
  <!-- Full Width Column -->
  <div class="content-wrapper">
    <div class="container">
      <!-- Content Header (Page header) -->
      <section class="content-header">
      	<h1>
      		<small>
      			<ol class="breadcrumb pull-right">
      				<li><a href="/RMP/webpage/showProjects"><i class="fa fa-dashboard"></i> Projects&RA</a></li>
      				<li><a href="/RMP/webpage/manageRisk"> 项目风险</a></li>
      				<li class="active"> 风险状态</li>
      			</ol>
      		</small>
      	</h1>
      </section>

      <!-- Main content -->
      <section class="content">
      <div class="row">
      	<div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">风险${riskId}的状态</h3>
            </div><!-- /.box-header -->
            
            <div class="box-body">
              <table class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>编号</th>
                  <th>描述</th>
                  <th>状态</th>
                  <th>创建时间</th>
                  <th>创建者</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="riskStatusList" id="riskStatus">
                	<tr>
                		<td><s:property value="id"/></td>
                		<td><s:property value="info"/></td>
                		<td><s:property value="isHappened"/></td>
                		<td><s:property value="createdAt"/></td>
                		<td><s:property value="createdBy"/></td>
                	</tr>
                </s:iterator>
                </tbody>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
    </div>
    <!-- /.container -->
  </div>
  <!-- /.content-wrapper -->

</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/RMP/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/RMP/bootstrap/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/RMP/bootstrap/dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    $("#risks").DataTable();
  });
</script>
</body>
</html>