<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻网</title>
<sx:head />
</head>
<body>

	<span class="tt"> &nbsp;《${queryTopicName}》栏目新闻&nbsp;&nbsp; </span>
	<s:iterator var="item" value="subNews">
		<span> <a href="${item.url}">${item.title}</a>
		</span>
	</s:iterator>

	<div>
		<table width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td><span>热点新闻</span></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

	<div>
		<table width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td>
								<!-- 显示新闻列表 --> <s:url var="getlist" action="showIndexList">
									<s:param name="queryTopicId" value="1" />
								</s:url> <sx:div theme="ajax"  href="%{getlist}"></sx:div>


								<div align="right">
									<a href="getNewsList.action?queryTopicId=1">更多...</a>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td>&nbsp;</td>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>