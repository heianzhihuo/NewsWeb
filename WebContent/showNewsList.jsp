<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sx:head />
<title><s:property value="queryTopicName"></s:property></title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Express News Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- for bootstrap working -->
<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- web-fonts -->
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet' type='text/css'>
<script src="js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			nav : true,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--/script-->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 900);
		});
	});
</script>
</head>
<body>
	<!-- header-section-starts-here -->
	<!-- header-section-starts-here -->
	<div class="header-bottom">
		<div class="logo text-center">
			<a href="index.jsp"><img src="images/logo.jpg" alt="" /></a>
		</div>
		<div class="navigation">
			<nav class="navbar navbar-default" role="navigation">
			<div class="wrap">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

				</div>
				<!--/.navbar-header-->

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="index.jsp">首页</a></li>
					</ul>
					<ul class="nav navbar-nav">
						<li class="active"><a href="showSubscribtion">我的订阅</a></li>
					</ul>
					<sx:div href="showTopicList.action"></sx:div>
					<div class="search">
						<!-- start search-->
						<div class="search-box">
							<div id="sb-search" class="sb-search">
								<s:form theme="simple" action="searchNews">
									<s:textfield class="sb-search-input" type="search" id="search"
										name="keyWords"></s:textfield>
									<s:textfield class="sb-search-submit" type="submit"></s:textfield>
									<span class="sb-icon-search"> </span>
								</s:form>
							</div>
						</div>
						<!-- search-scripts -->
						<script src="js/classie.js"></script>
						<script src="js/uisearch.js"></script>
						<script>
							new UISearch(document.getElementById('sb-search'));
						</script>
						<!-- //search-scripts -->
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!--/.navbar-collapse--> <!--/.navbar-->
		</div>
	</div>
	</div>
	<!-- header-section-ends-here -->
	<div class="wrap">
		<div class="move-text">
			<div class="breaking_news">
				<h2>时间</h2>
			</div>
			<div class="marquee">
				<div class="marquee1" id="time1"></div>
				<script>
					setInterval(
							"document.getElementById('time1').innerHTML = new Date().toLocaleString();",
							1000);
				</script>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<script type="text/javascript" src="js/jquery.marquee.min.js"></script>
			<script>
				$('.marquee').marquee({
					pauseOnHover : true
				});
				//@ sourceURL=pen.js
			</script>
		</div>
	</div>
	<!-- content-section-starts-here -->
	<div class="main-body">
		<div class="wrap">
			<ol class="breadcrumb">
				<li><a href="index.jsp">首页</a></li>
				<li class="active"><s:property value="queryTopicName"></s:property></li>
			</ol>
			<div class="col-md-8 content-left">
				<div class="articles sports">
					<h3 class="title-head">
						<s:property value="queryTopicName"></s:property>
					</h3>

					<!-- 列出所有新闻标题 -->
					<div class="article">
						<s:iterator var="item" value="allNews" status="st">
							<p>
								<s:if test="#item.picture == null ">
									<p>
										<s:date name="publishTime"></s:date>
										<s:if test="source != null">
			  来源：<s:property value="source"></s:property>
										</s:if>
									<p>
									<p>
										<a class="title" target="_blank" href="${item.url}"> ${item.title} </a>
									<p>
								</s:if>
						</s:iterator>
						<div class="clearfix"></div>
					</div>

					<div class="clearfix"></div>
				</div>
			</div>

		</div>

		<div class="col-md-4 side-bar">
			<div class="first_half">
				<div class="newsletter">
					<h1 class="side-title-head">个人中心</h1>
					<%
						HttpSession s = request.getSession();
					%>
					<%
						String username = null;
						if (s != null)
							username = (String) s.getAttribute("username");
					%>
					<%
						if (username != null) {
					%>
					<a href="Logout">退出登录</a> <a href="Subscribe">订阅管理</a>
					<%
						} else {
					%>
					<a href="login.jsp">登录</a> <a href="register.jsp">注册</a>
					<%
						}
					%>
				</div>

				<div class="list_vertical">
					<section class="accordation_menu">
					<div>
						<input id="label-1" name="lida" type="radio" checked /> <label
							for="label-1" id="item1"><i class="ferme"> </i>订阅新闻<i
							class="icon-plus-sign i-right1"></i><i
							class="icon-minus-sign i-right2"></i></label>
						<div class="content" id="a1">
							<div class="scrollbar" id="style-2">
								<div class="force-overflow">
									<div class="popular-post-grids">
										<s:url var="getSubscribtion" action="showSubscribtionList">
										</s:url>
										<sx:div theme="ajax" href="%{getSubscribtion}">
										</sx:div>
									</div>
								</div>
							</div>
						</div>
					</div>

					</section>
				</div>

			</div>

			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>

	<!-- content-section-ends-here -->
	<!-- footer-section-starts-here -->
	<di v class="footer">
	<div class="footer-top">
		<div class="wrap">
			<div class="col-md-3 col-xs-6 col-sm-4 footer-grid">
				<h4 class="footer-head">关于我们</h4>
				<p>1. 新闻由机器选取每30分钟自动更新</p>
				<p>2. 新闻搜索源于中国新闻网，系统自动分类排序</p>
			</div>
			<div class="col-md-2 col-xs-6 col-sm-2 footer-grid">
				<h4 class="footer-head">类别</h4>
				<ul class="cat">
					<li><a href="getNewsList.action?queryTopicId=7">财经</a></li>
					<li><a href="getNewsList.action?queryTopicId=8">科技</a></li>
					<li><a href="getNewsList.action?queryTopicId=6">娱乐</a></li>
					<li><a href="getNewsList.action?queryTopicId=3">社会</a></li>
					<li><a href="getNewsList.action?queryTopicId=10">文化</a></li>
					<li><a href="getNewsList.action?queryTopicId=9">生活</a></li>
				</ul>
			</div>
			<div class="col-md-3 col-xs-12 footer-grid">
				<h4 class="footer-head">联系我们</h4>
				<span class="hq">工大软设新闻网站小组</span>
				<address>
					<ul class="location">
						<li><span class="glyphicon glyphicon-map-marker"></span></li>
						<li>哈尔滨工业大学A02公寓</li>
						<div class="clearfix"></div>
					</ul>
					<ul class="location">
						<li><span class="glyphicon glyphicon-earphone"></span></li>
						<li>18245032253</li>
						<div class="clearfix"></div>
					</ul>
					<ul class="location">
						<li><span class="glyphicon glyphicon-envelope"></span></li>
						<li>704385759@qq.com</a></li>
						<div class="clearfix"></div>
					</ul>
				</address>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="footer-bottom">
		<div class="wrap">
			<div class="copyrights col-md-6">
				<p>Copyright &copy; 2016.Company name All rights reserved.</p>
				<!-- <a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p> -->
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- footer-section-ends-here --> <script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
			wrapID: 'toTop', // fading element id
			wrapHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
			 */
			$().UItoTop({
				easingType : 'easeOutQuart'
			});
		});
	</script> <a href="#to-top" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span></a> <!---->
</body>
</html>