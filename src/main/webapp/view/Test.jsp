<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
      <section class="col-xs-12 connectedSortable ui-sortable">
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
              <form action="#" method="get" name="dateForm" id="dateForm">
                <input type="text" style="width:200px;" class="form-control" name="dateRange" id="dateRange">
              </form>
            </li>
          </ul>
          
          <script type="text/javascript">
		    $(document).ready(function() {
				$('#dateRange').daterangepicker({
					format: 'yyyy/MM/dd HH:mm:ss'
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
      </div><!-- /.col -->
      </section>
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
	  initPie();
	  $('#dateRange').daterangepicker();
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
  /*
  function initPie(){
	  var acknowledged = "${requestScope.acknowledged}";
	  var acknowledged = "${requestScope.acknowledged}";
	  var colorset = ["#f56954", "00a65a", "#f39c12", "#00c0ef", "#3c8dbc", "d2d6de"];
	  var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
	  var pieChart = new Chart(pieChartCanvas);
	  
	  var PieData = [];
	  for(var i = 0; i < 6; i++) {
		  var tmp = {
		  value: i+1,
		  color: colorset[i],
		  highlight: colorset[i],
		  label: "Label"+i
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
		//String - A legend template
	  };
	  //Create pie or douhnut chart
	  // You can switch between pie and douhnut using the method below.
	  pieChart.Doughnut(PieData, pieOptions); 
	  
	  var pieChartCanvas2 = $("#pieChart2").get(0).getContext("2d");
	  var pieChart2 = new Chart(pieChartCanvas2);
	  var PieData2 = [
	  {
        value: 700,
        color: "#f56954",
        highlight: "#f56954",
        label: "Chrome"
      },
      {
        value: 500,
        color: "#00a65a",
        highlight: "#00a65a",
        label: "IE"
      },
      {
        value: 400,
        color: "#f39c12",
        highlight: "#f39c12",
        label: "FireFox"
      },
      {
        value: 600,
        color: "#00c0ef",
        highlight: "#00c0ef",
        label: "Safari"
      },
      {
        value: 300,
        color: "#3c8dbc",
        highlight: "#3c8dbc",
        label: "Opera"
      },
      {
        value: 100,
        color: "#d2d6de",
        highlight: "#d2d6de",
        label: "Navigator"
      }
	  ];
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
		//String - A legend template
	  };
	  //Create pie or douhnut chart
	  // You can switch between pie and douhnut using the method below.
	  pieChart2.Doughnut(PieData2, pieOptions2); 
	  };
  
  function initBar(){
	  var barChartCanvas = $("#barChart").get(0).getContext("2d");
	  var barChart = new Chart(barChartCanvas);
	  var tmpLabel = [];
	  var tmpData = [];
	  var tmpData2 = [];
	  for(var i = 0; i < 7; i++) {
		  var tmp = "Label"+i;
		  tmpLabel.push(tmp);
		  tmpData.push(i+1);
		  tmpData2.push((i+1)*2);
	  }
	  var barChartData = {
		labels: tmpLabel,
		datasets: [
		  {
			label: "Electronics",
			fillColor: "rgba(210, 214, 222, 1)",
			strokeColor: "rgba(210, 214, 222, 1)",
			pointColor: "rgba(210, 214, 222, 1)",
			pointStrokeColor: "#c1c7d1",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(220,220,220,1)",
			data: tmpData
		  },
		  {
			label: "Digital Goods",
			fillColor: "rgba(60,141,188,0.9)",
			strokeColor: "rgba(60,141,188,0.8)",
			pointColor: "#3b8bba",
			pointStrokeColor: "rgba(60,141,188,1)",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(60,141,188,1)",
			data: tmpData2
		  }
		]
	  };
	  barChartData.datasets[1].fillColor = "#00a65a";
	  barChartData.datasets[1].strokeColor = "#00a65a";
	  barChartData.datasets[1].pointColor = "#00a65a";
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
		//String - A legend template
		//Boolean - whether to make the chart responsive
		responsive: true,
		maintainAspectRatio: true
	  };
  
	  barChartOptions.datasetFill = false;
	  barChart.Bar(barChartData, barChartOptions);
	  
	  var barChartCanvas2 = $("#barChart2").get(0).getContext("2d");
	  var barChart2 = new Chart(barChartCanvas2);
	  var barChartData2 = {
		labels: ["January", "February", "March", "April", "May", "June", "July"],
		datasets: [
		  {
			label: "Electronics",
			fillColor: "rgba(210, 214, 222, 1)",
			strokeColor: "rgba(210, 214, 222, 1)",
			pointColor: "rgba(210, 214, 222, 1)",
			pointStrokeColor: "#c1c7d1",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(220,220,220,1)",
			data: [65, 59, 80, 81, 56, 55, 40]
		  },
		  {
			label: "Digital Goods",
			fillColor: "rgba(60,141,188,0.9)",
			strokeColor: "rgba(60,141,188,0.8)",
			pointColor: "#3b8bba",
			pointStrokeColor: "rgba(60,141,188,1)",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(60,141,188,1)",
			data: [28, 48, 40, 19, 86, 27, 90]
		  }
		]
	  };
	  barChartData2.datasets[1].fillColor = "#00a65a";
	  barChartData2.datasets[1].strokeColor = "#00a65a";
	  barChartData2.datasets[1].pointColor = "#00a65a";
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
		//String - A legend template
		//Boolean - whether to make the chart responsive
		responsive: true,
		maintainAspectRatio: true
	  };
  
	  barChartOptions2.datasetFill = false;
	  barChart2.Bar(barChartData2, barChartOptions2);
	  };*/
	  
	  
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
		  label: e.riskType.info
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
		  label: e.riskType.info
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
		  acLabel.push(e.riskType.info);
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
		  acLabel2.push(e.riskType.info);
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