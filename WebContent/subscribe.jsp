<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>订阅</title>
<sx:head />
</head>
<body>
	<s:form action="Subscribe" method="post" theme="simple">
		<label>请选择：</label>
		<s:checkboxlist list="topicList" name="favoriteList" listKey = "topicId" listValue="topicName"  value="0"	>
		</s:checkboxlist>
		<%-- list="#{'1':'Java','2':'Python','3':'Jsp','4':'PHP'}" --%>
		<%-- <s:checkboxlist list="#{'Java','Python','Jsp','PHP'}"
			name="favorite" listKey="key" listValue="value" value="0"></s:checkboxlist>

		<input type="checkbox"  checked name="favorite" value="5"
			id="Subscribe_favorite-5" />
		<label for="Subscribe_favorite-5" class="checkboxLabel">C++</label> --%>
		<s:submit value="确定" type="button" />
	</s:form>

</body>
</html>