<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- 显示限定条数的订阅新闻 -->
<s:iterator var="item" value="favNews" status="st">
	<s:if test="#st.count<=10">
        &nbsp;&nbsp;&nbsp;
        <p>
        <s:date name="publishTime"></s:date>
		<s:if test="source != null">
			  来源：<s:property value="source"></s:property>
		</s:if>
		<p>
		<a class="pp-title" href="${item.url}"> ${item.title}</a>
		<p>
	</s:if>
</s:iterator>