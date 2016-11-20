<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><cite></cite>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"></meta>
<title>项目</title>
 
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
          <a href="#" class="navbar-brand"><b>RiskManage</b></a>
        </div>

        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">
            <!-- User Account Menu -->
            <li class="dropdown user user-menu">
              <!-- Menu Toggle Button -->
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <!-- The user image in the navbar-->
                <img src="" class="user-image" alt="User Image">
                <!-- hidden-xs hides the username on small devices so only the image appears. -->
                <span class="hidden-xs">Alexander Pierce</span>
              </a>
              <ul class="dropdown-menu">
                <!-- The user image in the menu -->
                <li class="user-header">
                  <img src="" class="img-circle" alt="User Image">

                  <p>
                    Alexander Pierce - Web Developer
                    <small>Member since Nov. 2012</small>
                  </p>
                </li>
                
                <!-- Menu Footer-->
                <li class="user-footer">
                  <div class="pull-right">
                    <a href="#" class="btn btn-default btn-flat">Sign out</a>
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
      				<li><a href="#"><i class="fa fa-dashboard"></i> 项目</a></li>
      			</ol>
      		</small>
      	</h1>
      </section>

      <!-- Main content -->
      <section class="content">
      <div class="row">
        <div class="nav-tabs-custom" style="cursor: move;">
          <ul class="nav nav-tabs pull-right ui-sortable-handle">
            <li class>
              <a href="#bar-chart" data-toggle="tab" aria-expanded="false">柱状图</a>
            </li>
            <li class="active">
              <a href="#pie-chart" data-toggle="tab" aria-expanded="true">饼状图</a>
            </li>
            <li class="pull-left header">
              <i class="fa fa-bar-chart"></i>
               风险统计
            </li>
            <li class="pull-left">
              <form action="ChartAction?method=refreshChart" method="get" name="dateForm" id="dateForm">
                <input type="text" style="width:200px;" class="form-control" name="dateRange" id="dateRange" onChange="changeDate();">
              </form>
            </li>
          </ul>
          <script type="text/javascript">
		    $(document).ready(function() {
				$('#dateRange').daterangepicker({
					format: 'YYYY/MM/DD HH:mm:ss'
				});
            });
		  </script>
          
          <div class="tab-content no-padding">
            <div class="chart tab-pane" id="bar-chart" style="position:relative;">
              <canvas id="barChart" style="height: 230px; width: 652px;" height="287" width="815"></canvas>
              <B><p align="center">识别最多的风险</p></B>
              <canvas id="barChart2" style="height: 230px; width: 652px;" height="287" width="815"></canvas>
              <B><p align="center">引发问题最多的风险</p></B>
            </div>
            
            <div class="chart tab-pane active" id="pie-chart" style="position:relative;">
              <canvas id="pieChart" style="height: 326px; width: 652px;" height="407" width="815"></canvas>
              <B><p align="center">识别最多的风险</p></B>
              <canvas id="pieChart2" style="height: 326px; width: 652px;" height="407" width="815"></canvas>
              <B><p align="center">引发问题最多的风险</p></B>
            </div>
          </div>
          <%--<div class="box">
            <div class="box-header">
              <h3 class="box-title">风险图表</h3>
              
            </div>
            <!-- /.box-header -->
            
            
            
            <div class="box-body">
              <table id="projects" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>编号</th>
                  <th>名称</th>
                  <th>描述</th>
                  <th>创建时间</th>
                  <th>创建者</th>
                  <th>Risks</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="projectList" id="project">
                	<tr>
                		<td><s:property value="id"/></td>
                		<td><s:property value="name"/></td>
                		<td><s:property value="description"/></td>
                		<td><s:property value="createdAt"/></td>
                		<td><s:property value="createdBy"/></td>
                		<td><a href="/RMP/view/manageRisk" onclick="setValue(<s:property value="id"/>)">manageRisks</a></td>
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
            					<div class="form-group col-xs-12">
            						<s:label class="control-label col-md-2" value="项目名称："/>
            						<div class="col-md-10">
            							<input id="projectName" name="projectName" type="text" class="form-control"/>
            						</div>
            					</div>
            					<div class="form-group col-xs-12">
            						<s:label class="control-label col-md-2" value="项目描述:"/>
            						<div class="col-md-10">
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
            
            
            
            
        </div><!-- /.box -->--%>
        
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
<!--ChartJS-->
<script src="/RMP/bootstrap/AdminLTE-2.3.7/plugins/chartjs/Chart.min.js"></script>
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
<script>
  $(function () {
    $("#projects").DataTable();
  });
/*   function setValue(num){
	  var p=document.getElementById('projectId');
	  p.value=num;
  }; */
</script>
<script>
$(function () {
	  $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
     // 获取已激活的标签页的名称
     var activeTab = $(e.target)[0].hash;
     if(activeTab=="#bar-chart") initBar();//加载图表
     if(activeTab=="#pie-chart") initPie();
     });
});

  function changeDate() {
	  $('#dateForm').submit();
  }
  
  function initPie(){
	  var acknowledged = "${requestScope.acknowledged}";
	  var troubled = "${requestScope.troubled}";
	  var colorset = ["#f56954", "00a65a", "#f39c12", "#00c0ef", "#3c8dbc", "d2d6de"];
	  var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
	  var pieChart = new Chart(pieChartCanvas);
	  var PieData = [];
	  for(var e in acknowledged) {
		  var tmp = {
		  value: e.count,
		  color: colorset[i],
		  highlight: colorset[i],
		  label: e.riskType
		  };
		  PieData.push(tmp);
	  }
	  
	  var pieOptions = {
		//Boolean - Whether we should show a stroke on each segment
		segmentShowStroke: true,
		//String - The colour of each segment stroke
		segmentStrokeColor: "#fff",
		//Number - The width of each segment stroke
		segmentStrokeWidth: 2,
		//Number - The percentage of the chart that we cut out of the middle
		percentageInnerCutout: 50, // This is 0 for Pie charts
		//Number - Amount of animation steps
		animationSteps: 100,
		//String - Animation easing effect
		animationEasing: "easeOutBounce",
		//Boolean - Whether we animate the rotation of the Doughnut
		animateRotate: true,
		//Boolean - Whether we animate scaling the Doughnut from the centre
		animateScale: false,
		//Boolean - whether to make the chart responsive to window resizing
		responsive: true,
		// Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
		maintainAspectRatio: true,
	  };
	  //Create pie or douhnut chart
	  // You can switch between pie and douhnut using the method below.
	  pieChart.Doughnut(PieData, pieOptions); 
	  
	  var pieChartCanvas2 = $("#pieChart2").get(0).getContext("2d");
	  var pieChart2 = new Chart(pieChartCanvas2);
	  var PieData2 = [];
	  for(var e in acknowledged) {
		  var tmp = {
		  value: e.count,
		  color: colorset[i],
		  highlight: colorset[i],
		  label: e.riskType
		  };
		  PieData2.push(tmp);
	  }
	  var pieOptions2 = {
		//Boolean - Whether we should show a stroke on each segment
		segmentShowStroke: true,
		//String - The colour of each segment stroke
		segmentStrokeColor: "#fff",
		//Number - The width of each segment stroke
		segmentStrokeWidth: 2,
		//Number - The percentage of the chart that we cut out of the middle
		percentageInnerCutout: 50, // This is 0 for Pie charts
		//Number - Amount of animation steps
		animationSteps: 100,
		//String - Animation easing effect
		animationEasing: "easeOutBounce",
		//Boolean - Whether we animate the rotation of the Doughnut
		animateRotate: true,
		//Boolean - Whether we animate scaling the Doughnut from the centre
		animateScale: false,
		//Boolean - whether to make the chart responsive to window resizing
		responsive: true,
		// Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
		maintainAspectRatio: true,
	  };
	  //Create pie or douhnut chart
	  // You can switch between pie and douhnut using the method below.
	  pieChart2.Doughnut(PieData2, pieOptions2); 
	  };

  function initBar(){
	  var acknowledged = "${requestScope.acknowledged}";
	  var troubled = "${requestScope.troubled}";
	  var barChartCanvas = $("#barChart").get(0).getContext("2d");
	  var barChart = new Chart(barChartCanvas);
	  var acLabel=[];
	  var acData = [];
	  for(var e in acknowledged) {
		  acLabel.push(e.riskType);
		  acData.push(e.count);
	  }
	  var barChartData = {
		labels: acLabel,
		datasets: [
		  {
			label: "识别次数",
			fillColor: "rgba(60,141,188,0.9)",
			strokeColor: "rgba(60,141,188,0.8)",
			pointColor: "#3b8bba",
			pointStrokeColor: "rgba(60,141,188,1)",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(60,141,188,1)",
			data: acData
		  }
		]
	  };
	  barChartData.datasets[0].fillColor = "#00a65a";
	  barChartData.datasets[0].strokeColor = "#00a65a";
	  barChartData.datasets[0].pointColor = "#00a65a";
	  var barChartOptions = {
		//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
		scaleBeginAtZero: true,
		//Boolean - Whether grid lines are shown across the chart
		scaleShowGridLines: true,
		//String - Colour of the grid lines
		scaleGridLineColor: "rgba(0,0,0,.05)",
		//Number - Width of the grid lines
		scaleGridLineWidth: 1,
		//Boolean - Whether to show horizontal lines (except X axis)
		scaleShowHorizontalLines: true,
		//Boolean - Whether to show vertical lines (except Y axis)
		scaleShowVerticalLines: true,
		//Boolean - If there is a stroke on each bar
		barShowStroke: true,
		//Number - Pixel width of the bar stroke
		barStrokeWidth: 2,
		//Number - Spacing between each of the X value sets
		barValueSpacing: 5,
		//Number - Spacing between data sets within X values
		barDatasetSpacing: 1,
		//Boolean - whether to make the chart responsive
		responsive: true,
		maintainAspectRatio: true
	  };

	  barChartOptions.datasetFill = false;
	  barChart.Bar(barChartData, barChartOptions);
	  
	  
	  var barChartCanvas2 = $("#barChart2").get(0).getContext("2d");
	  var barChart2 = new Chart(barChartCanvas2);
	  var acLabel2 = [];
	  var acData2 = [];
	  for(var e in troubled) {
		  acLabel2.push(e.riskType);
		  acData2.push(e.count);
	  }
	  var barChartData2 = {
		labels: acLabel2,
		datasets: [
		  {
			label: "引发问题次数",
			fillColor: "rgba(60,141,188,0.9)",
			strokeColor: "rgba(60,141,188,0.8)",
			pointColor: "#3b8bba",
			pointStrokeColor: "rgba(60,141,188,1)",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(60,141,188,1)",
			data: acData2
		  }
		]
	  };
	  barChartData2.datasets[0].fillColor = "#00a65a";
	  barChartData2.datasets[0].strokeColor = "#00a65a";
	  barChartData2.datasets[0].pointColor = "#00a65a";
	  var barChartOptions2 = {
		//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
		scaleBeginAtZero: true,
		//Boolean - Whether grid lines are shown across the chart
		scaleShowGridLines: true,
		//String - Colour of the grid lines
		scaleGridLineColor: "rgba(0,0,0,.05)",
		//Number - Width of the grid lines
		scaleGridLineWidth: 1,
		//Boolean - Whether to show horizontal lines (except X axis)
		scaleShowHorizontalLines: true,
		//Boolean - Whether to show vertical lines (except Y axis)
		scaleShowVerticalLines: true,
		//Boolean - If there is a stroke on each bar
		barShowStroke: true,
		//Number - Pixel width of the bar stroke
		barStrokeWidth: 2,
		//Number - Spacing between each of the X value sets
		barValueSpacing: 5,
		//Number - Spacing between data sets within X values
		barDatasetSpacing: 1,
		//Boolean - whether to make the chart responsive
		responsive: true,
		maintainAspectRatio: true
	  };
  
	  barChartOptions2.datasetFill = false;
	  barChart2.Bar(barChartData2, barChartOptions2);
	  };
</script>
</body>
</html>