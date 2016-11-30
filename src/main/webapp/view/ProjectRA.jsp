<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"></meta>
<title>项目经理首页</title>
 
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">


<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="/RMP/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- jvectormap -->
<link rel="stylesheet" href="/RMP/bootstrap/AdminLTE-2.3.7/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
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
				</div>
				<!-- /.navbar-custom-menu -->
			</div>
			<!-- /.container-fluid -->
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
					<li><a href="#"><i class="fa fa-dashboard"></i> Projects&RA</a></li>
				</ol>
			</small>
		</h1>
		</section>
		
		
		<!-- Main content -->
		<section class="content">
		<div class="row">
		<div class="col-xs-12">
			<div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#projects" data-toggle="tab">Projects</a></li>
              <li><a href="#ra" data-toggle="tab">RA</a></li>
            </ul>
            <div class="tab-content">
            	<div class="active tab-pane" id="projects">
            	<div class="box">
            		<div class="box-header">
            			<h3 class="box-title">项目列表</h3>
            		</div><!-- /.box-header -->
            		
            		
            		<div class="box-body">
            		<table id="projects" class="table table-bordered table-striped">
					<thead>
					<tr>
						<th>编号</th>
						<th>名称</th>
						<th>创建时间</th>
						<th>创建者</th>
						<th>描述</th>
						<th>Risks</th>
					</tr>
					</thead>
					<tbody>
					<s:iterator value="projectList" id="project">
					<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="name"/></td>
						<td><s:property value="createdAt"/></td>
						<td><s:property value="createdBy"/></td>
						<td><s:property value="description"/></td>
						<td><a href="/RMP/view/manageRisk?projectId=${id }">manageRisks</a></td>
                	</tr>
                	</s:iterator>
                	</tbody>
                	</table>
                	</div><!-- /.box-body -->
                	
                	
                	<div class="box-footer">
                	<button type="button" class="btn btn-default btn-sm bt-flat pull-right" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i>Add New Project</button>
                	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                	<div class="modal-dialog" role="document">
                	<div class="modal-content">
                		<div class="modal-header">
                			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span></button>
                			<h4 class="modal-title" id="myModalLabel">添加项目</h4>
                		</div>
                		
                		<div class="modal-body">
                		<div class="panel panel-blue" style="background:#fff;">
                			<div class="panel-body">
                			<s:form action="/RMP/webpage/addProject" method="post" theme="simple">
                				<div class="form-group col-md-12">
                					<s:label class="control-label col-md-3" value="项目名称："/>
                					<div class="col-md-9">
                						<input id="projectName" name="projectName" type="text" class="form-control"/>
                					</div>
                				</div>
            					<div class="form-group col-md-12">
            						<s:label class="control-label col-md-3" value="项目描述:"/>
            						<div class="col-md-9">
            							<input id="projectDescription" name="projectDescription" type="text" class="form-control"/>
                					</div>
                				</div>
                				
                				
                				<s:submit class="btn btn-info pull-right" value="add"/>
                				
                			</s:form>
                			</div>
                		</div>
                		</div><!-- /.modal-body -->
                	</div><!-- /.modal-content -->
                	</div><!-- /.modal-dialog -->
                	</div>
                	</div><!-- /.box-footer -->
                </div><!-- /.box -->
                </div><!-- /.tab-pane -->
                
                
                <div class="tab-pane" id="ra">
              	<div class="box">
              		<div class="box-header">
              			<h3 class="box-title">风险管理计划列表</h3>
              		</div><!-- /.box-header -->
              		
              		
              		<div class="box-body">
					<table id="plans" class="table table-bordered table-striped">
					<thead>
					<tr>
						<th>编号</th>
						<th>创建时间</th>
						<th>创建者</th>
						<th>计划详情</th>
					</tr>
					</thead>
					<tbody>
					<s:iterator value="planModelList" id="planModel">
					<tr>
						<td><s:property value="riskPlan.getId()"/></td>
						<td><s:property value="riskPlan.getCreatedAt()"/></td>
						<td><s:property value="riskPlan.getCreatedBy()"/></td>
						<td>
						<table class="table table-hover table-bordered">
						<thead>
						<tr>
							<td>编号</td>
							<td>类型</td>
							<td>内容</td>
							<td>可能性</td>
							<td>影响程度</td>
							<td>触发器／阈值</td>
						</tr>
						</thead>
						<tbody>
							<s:iterator value="riskPlanItemList" id="riskPlanItem">
							<tr>
								<td class="active"><s:property value="id"/></td>
								<td class="success"><s:property value="typeId"/></td>
								<td class="warning"><s:property value="info"/></td>
								<td class="active"><s:property value="probability"/></td>
								<td class="success"><s:property value="impact"/></td>
								<td class="warning"><s:property value="trigger"/></td>
							</tr>
							</s:iterator>
						</tbody>
						</table>
						</td>
                	</tr>
                	</s:iterator>
                	</tbody>
                	</table>
                	</div><!-- /.box-body -->
                	
                	
                	<div class="box-footer">
                		<a href="/RMP/view/createRA" class="btn btn-default btn-sm bt-flat pull-right"><i class="fa fa-plus"></i>Create A RA</a>
                	</div><!-- /.box-footer -->
                
                </div><!-- /.box -->
                </div><!-- /.tab-pane -->
                
                </div><!-- /.tab-content -->
                
                </div><!-- /.nav-tabs-custom -->
                </div><!-- /.col -->
                </div><!-- /.row -->
                
                
                </section><!-- /.content -->
		
	</div><!-- /.container -->
	</div><!-- /.content-wrapper -->

</div><!-- ./wrapper -->

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
<script src="/RMP/bootstrap/AdminLTE-2.3.7/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
	  $("#projects").DataTable();
	  $("#plans").DataTable();
  });
</script>
</body>
</html>