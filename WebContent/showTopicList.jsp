<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<ul class="nav navbar-nav">
	<s:iterator var="item" value="topicList" status="st">
		<li class="active"><a
			href="getNewsList.action?queryTopicId=${item.topicId}">${item.topicName}</a></li>
	</s:iterator>
</ul>
