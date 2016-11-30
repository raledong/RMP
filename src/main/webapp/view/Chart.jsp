<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*,com.cell.viewmodel.RiskAnalyseModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"></meta>
<title>风险分析</title>
 
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">


<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="/RMP/bootstrap/dist/css/bootstrap.min.css">
<!-- DateRangePicker -->
<link rel="stylesheet" type="text/css" media="all" href="/RMP/bootstrap/AdminLTE-2.3.7/plugins/daterangepicker/daterangepicker.css" />
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
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
      				<li><a href="/RMP/webpage/createRA"> 风险管理计划</a></li>
					<li><a href="#">风险分析</a></li>
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
					<h3 class="box-title">柱状图</h3>
					<!-- Date -->
					<s:form action="／RMP/webpage/analyseRisk" method="post" theme="simple">
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
            				<s:submit class="btn btn-default btn-sm bt-flat pull-right" value="confirm"/>
            			</div>
            		</s:form>
				</div>
				
				<div class="box-body">
				<div class="col-md-6">
				<h4>被识别最多：</h4>
				<div id="bar-chart" style="height: 300px;"></div>
				</div>
				<div class="col-md-6">
				<h4>演变成问题最多：</h4>
				<div id="bar-chart2" style="height: 300px;"></div>
				</div>
					
            	</div>
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
<!-- DataTables -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- InputMask -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/input-mask/jquery.inputmask.js"></script>
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/datepicker/bootstrap-datepicker.js"></script>
<!--ChartJS-->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/chartjs/Chart.min.js"></script>
<!-- FLOT CHARTS -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/flot/jquery.flot.min.js"></script>
<!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/flot/jquery.flot.resize.min.js"></script>
<!-- FLOT PIE PLUGIN - also used to draw donut charts -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/flot/jquery.flot.pie.min.js"></script>
<!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/flot/jquery.flot.categories.min.js"></script>
<!-- FastClick -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/dist/js/demo.js"></script>
<!--DateRangePicker-->
<script type="text/javascript" src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/daterangepicker/moment.min.js"></script>
<script type="text/javascript" src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/daterangepicker/daterangepicker.js"></script>
<!-- page script -->
<script language="javascript">
$(function () {
	
	$('#startTime').datepicker({
		  autoclose: true,
		  format: 'yyyy-mm-dd'
		  });
	  $('#endTime').datepicker({
		  autoclose: true,
		  format: 'yyyy-mm-dd'
		  });
	
	/*
     * BAR CHART
     * ---------
     */
     
     
    var bar_data = {
      data: [["${top5AcknowledgedRisks.get(0).getRiskType().getInfo()}", "${top5AcknowledgedRisks.get(0).getCount()}"], 
             ["${top5AcknowledgedRisks.get(1).getRiskType().getInfo()}","${top5AcknowledgedRisks.get(1).getCount()}"], 
             ["${top5AcknowledgedRisks.get(2).getRiskType().getInfo()}", "${top5AcknowledgedRisks.get(2).getCount()}"], 
             ["${top5AcknowledgedRisks.get(3).getRiskType().getInfo()}", "${top5AcknowledgedRisks.get(3).getCount()}"], 
             ["${top5AcknowledgedRisks.get(4).getRiskType().getInfo()}", "${top5AcknowledgedRisks.get(4).getCount()}"]],
      color: "#3c8dbc"
    };
    $.plot("#bar-chart", [bar_data], {
      grid: {
        borderWidth: 1,
        borderColor: "#f3f3f3",
        tickColor: "#f3f3f3"
      },
      series: {
        bars: {
          show: true,
          barWidth: 0.5,
          align: "center"
        }
      },
      xaxis: {
        mode: "categories",
        tickLength: 0
      }
    });
    
    var bar_data2 = {
    		data: [["${top5TroubledRisks.get(0).getRiskType().getInfo()}", "${top5TroubledRisks.get(0).getCount()}"], 
    	             ["${top5TroubledRisks.get(1).getRiskType().getInfo()}","${top5TroubledRisks.get(1).getCount()}"], 
    	             ["${top5TroubledRisks.get(2).getRiskType().getInfo()}", "${top5TroubledRisks.get(2).getCount()}"], 
    	             ["${top5TroubledRisks.get(3).getRiskType().getInfo()}", "${top5TroubledRisks.get(3).getCount()}"], 
    	             ["${top5TroubledRisks.get(4).getRiskType().getInfo()}", "${top5TroubledRisks.get(4).getCount()}"]],
    	      color: "#3c8dbc"
    	    };
    	    $.plot("#bar-chart2", [bar_data2], {
    	      grid: {
    	        borderWidth: 1,
    	        borderColor: "#f3f3f3",
    	        tickColor: "#f3f3f3"
    	      },
    	      series: {
    	        bars: {
    	          show: true,
    	          barWidth: 0.5,
    	          align: "center"
    	        }
    	      },
    	      xaxis: {
    	        mode: "categories",
    	        tickLength: 0
    	      }
    	    });
    /* END BAR CHART */
});
</script>
</body>
</html>