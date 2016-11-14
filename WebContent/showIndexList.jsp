<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<br />
<s:iterator var="item" value="allNews" status="st">
	<s:if test="#st.count<=4">
        &nbsp;&nbsp;&nbsp;
    <a href="${item.url}">
			${item.title} &nbsp;&nbsp;${item.newsId} </a>
		<br />
	</s:if>
</s:iterator>
