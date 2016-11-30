<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"></meta>
<title>风险管理计划</title>
 
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">


<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="/RMP/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- daterange picker -->
<link rel="stylesheet" href="/RMP/bootstrap/AdminLTE-2.3.7/plugins/daterangepicker/daterangepicker.css">
<!-- bootstrap datepicker -->
<link rel="stylesheet" href="/RMP/bootstrap/AdminLTE-2.3.7/plugins/datepicker/datepicker3.css">
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
					<li><a href="/RMP/webpage/showProjects"><i class="fa fa-dashboard"></i> Projects&RA</a></li>
					<li><a href="#">风险管理计划</a></li>
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
					<h3 class="box-title">风险分析</h3>
					<a class="btn btn-default btn-sm bt-flat pull-right" href="/RMP/webpage/showChart"><i class="fa fa-eye"></i>查看分析图</a>
				</div><!-- /.box-header -->
				
				<div class="box-body">
					<!-- Date -->
					<s:form action="／RMP/webpage/analyse" method="post" theme="simple">
					<div class="row">
					<div class="form-group col-md-6">
						<label>StartDate:</label>
						<div class="input-group date">
							<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
							<input type="text" class="form-control pull-right" id="startTime" name="startTime">
						</div>
					</div>
					<div class="form-group col-md-6">
						<label>EndDate:</label>
						<div class="input-group date">
							<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
							<input type="text" class="form-control pull-right" id="endTime" name="endTime">
						</div>
					</div>
					</div>
					<div class="row col-md-12">
					<s:submit class="btn btn-default btn-sm bt-flat pull-right" value="analyse"/>
					</div>
					</s:form>
					<div class="row col-md-12">
					<div class="form-group">
						<label>识别最多的风险：</label>
						<p>风险编号：${mostAcknowledgedRisk.getRiskType().getId() }</p>
						<p>风险内容：${mostAcknowledgedRisk.getRiskType().getInfo() }</p>
						<p>风险创建者：${mostAcknowledgedRisk.getRiskType().getCreatedBy() }</p>
						<p>风险被识别次数：${mostAcknowledgedRisk.getCount() }</p>
					</div>
					</div>
					<div class="row col-md-12">
					<div class="form-group">
						<label>演变成问题最多的风险：</label>
						<p>风险编号：${mostTroubledRisk.getRiskType().getId() }</p>
						<p>风险内容：${mostTroubledRisk.getRiskType().getInfo() }</p>
						<p>风险创建者：${mostTroubledRisk.getRiskType().getCreatedBy() }</p>
						<p>风险演变成问题次数：${mostTroubledRisk.getCount() }</p>
					</div>
					</div>
				</div><!-- /.box-body -->
				
				<div class="box-footer">
					<a class="btn btn-default btn-sm bt-flat pull-left" href="/RMP/webpage/importMostAcknowledgedRisk"><i class="fa fa-download"></i>导入识别最多的风险</a>
					<a class="btn btn-default btn-sm bt-flat pull-right" href="/RMP/webpage/importMostTroubledRisk"><i class="fa fa-download"></i>导入演变成问题最多的风险</a>
				</div><!-- /.box-footer -->
				
			</div><!-- /.box -->
		</div><!-- /.col -->
		</div><!-- /.row -->
		
		
		
		<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">风险管理计划</h3>
				</div><!-- /.box-header -->
				
				
				
				<div class="box-body">
				<table id="risks" class="table table-bordered table-striped">
                <thead>
                	<tr>
                		<th>编号</th>
                		<th>风险类型</th>
                		<th>风险内容</th>
                		<th>可能性</th>
                		<th>影响程度</th>
                		<th>触发器／阈值</th>
                		<th>Modify</th>
                	</tr>
                </thead>
                <tbody>
                <s:iterator value="riskPlanItemList" id="riskPlanItem">
                	<tr>
                		<td><s:property value="id"/></td>
                		<td><s:property value="typeId"/></td>
                		<td><s:property value="info"/></td>
                		<td><s:property value="probability"/></td>
                		<td><s:property value="impact"/></td>
                		<td><s:property value="trigger"/></td>
                		<td>
                			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${id }"><span class="glyphicon glyphicon-edit"></span></button>
                			<div class="modal fade" id="${id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                			<div class="modal-dialog" role="document">
                			<div class="modal-content">
                				<div class="modal-header">
                					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span></button>
                					<h4 class="modal-title" id="myModalLabel">RA中risk条目详情</h4>
                				</div>
                				
                				<div class="modal-body">
                				<div class="panel panel-blue" style="background:#fff;">
                					<div class="panel-body">
                						<s:form action="/RMP/view/modRiskPlanItem" method="post" theme="simple">
                							<div class="row form-group col-md-12">
                								<s:label class="control-label col-md-3" value="risk编号:"/>
                								<div class="col-md-9">
                									<input class="form-control" id="riskId" name="riskId" type="text" value="${id}">
                								</div>
                							</div>
                							<div class="row form-group col-md-12">
                								<s:label class="control-label col-md-3" value="risk类型:"/>
                								<div class="col-md-9">
                									<input class="form-control" id="riskTypeId" name="riskTypeId" type="text" value="${typeId}">
                								</div>
                							</div>
                							<div class="row form-group col-md-12">
                								<s:label class="control-label col-md-3" value="risk内容:"/>
                								<div class="col-md-9">
                									<input id="riskInfo" name="riskInfo" type="text" class="form-control" value="${info}"/>
                								</div>
                							</div>
                							<div class="row form-group col-md-12">
                								<s:label class="control-label col-md-3" value="risk可能性:"/>
                								<div class="col-md-9">
                									<input id="riskProbability" name="riskProbability" type="text" class="form-control" value="${probability}"/>
                								</div>
                							</div>
                							<div class="row form-group col-md-12">
                								<s:label class="control-label col-md-3" value="risk影响程度:"/>
                								<div class="col-md-9">
                									<input id="riskImpact" name="riskImpact" type="text" class="form-control" value="${impact}"/>
                								</div>
                							</div>
                							<div class="row form-group col-md-12">
                								<s:label class="control-label col-md-3" value="risk触发器:"/>
                								<div class="col-md-9">
                									<input id="riskTrigger" name="riskTrigger" type="text" class="form-control" value="${trigger}"/>
                								</div>
                							</div>
                							
                							<s:submit class="btn btn-primary pull-right col-md-2 row " value="mod"/>
                						</s:form>
                					</div>
                				</div>
                				</div><!-- /.modal-body -->
                			</div><!-- /.modal-content -->
                			</div><!-- /.modal-dialog -->
                			</div>
                		</td>
                	</tr>
                </s:iterator>
                </tbody>
                </table>
                </div><!-- /.box-body -->
                
                
                
                <div class="box-footer">
                	<button type="button" class="btn btn-default btn-sm bt-flat pull-left" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i>AddRiskPlanItem</button>
                	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                	<div class="modal-dialog" role="document">
                	<div class="modal-content">
                		<div class="modal-header">
                			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span></button>
                			<h4 class="modal-title" id="myModalLabel">添加计划风险条目</h4>
                		</div>
                		
                		<div class="modal-body">
                		<div class="panel panel-blue" style="background:#fff;">
                			<div class="panel-body">
                			<s:form action="/RMP/webpage/addRiskPlanItem" method="post" theme="simple">
                				<div class="form-group col-md-12">
                				<label>风险类型</label>
                				<select id="riskTypeId" name="riskTypeId" class="form-control" >
                					<s:iterator value="riskTypeList" id="riskType">
                						<option value=${riskType.id }>${riskType.info }</option>
                					</s:iterator>
                				</select>
                				</div>
                				
                				<div class="form-group col-md-12">
                				<label>风险内容</label>
                				<input type="text" id="riskInfo" name="riskInfo" class="form-control"/>
                				</div>
                				
                				<div class="form-group col-md-12">
                				<label>可能性</label>
                				<select id="riskProbability" name="riskProbability" class="form-control" >
                					<option value="low">low</option>
                					<option value="medium">medium</option>
                					<option value="high">high</option>
                				</select>
                				</div>
                				
                				<div class="form-group col-md-12">
                				<label>影响程度</label>
                				<select id="riskImpact" name="riskImpact" class="form-control" >
                					<option value="low">low</option>
                					<option value="medium">medium</option>
                					<option value="high">high</option>
                				</select>
                				</div>
                				
                				<div class="form-group col-md-12">
                				<label>触发器／阈值</label>
                				<input type="text" id="riskTrigger" name="riskTrigger" class="form-control"/>
                				</div>
                				
                				
                				<s:submit class="btn btn-info pull-right" value="add"/>
                				
                			</s:form>
                			</div>
                		</div>
                		</div><!-- /.modal-body -->
                	</div><!-- /.modal-content -->
                	</div><!-- /.modal-dialog -->
                	</div>
                	<a href="/RMP/webpage/saveRA" class="btn btn-default btn-sm bt-flat pull-right"><i class="fa fa-plus"></i>Save RA</a>
                </div><!-- /.box-footer -->
          
			</div><!-- /.box -->
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
<!-- InputMask -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/input-mask/jquery.inputmask.js"></script>
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/datepicker/bootstrap-datepicker.js"></script>
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
	  $("#risks").DataTable();
	  $('#startTime').datepicker({
		  autoclose: true,
		  format: 'yyyy-mm-dd'
		  });
	  $('#endTime').datepicker({
		  autoclose: true,
		  format: 'yyyy-mm-dd'
		  });
  });
</script>
</body>
</html>