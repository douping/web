<%@ page language="java" import="java.util.*,java.io.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SHO物流WEBシステム</title>
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
	marginheight="0">

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td valign="top"><img
				src="<%=request.getContextPath()%>/images/head_ttl.png" alt="翔運輸"
				hspace="10"></td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td bgcolor="E1020E" height="2"></td>
		</tr>
	</table>
	<br>
	<br>
	<center>
		<table>
			<tr>
				<td><img src="./images/ex.gif"></td>
				<td><font color="red">
						MSG1102：<s:text name="MSG1102" />
				</font></td>
			</tr>
		</table>
		<br> <br>

		<table border="0" align="center" cellpadding="0" cellspacing="6">
			<tr>
				<td><span style="font-size: 13pt"> <a
						href="index.action"><B>再ログイン</B></a>
				</span></td>
			</tr>
		</table>
		<br> <br>
		<table border="0" align="center" cellpadding="0" cellspacing="6">
			<tr>
				<td align="center" class="Copyright"><span
					style="font-size: 10pt">翔運輸株式会社</span><br> Copyright 2005
					SYO-UNYU Co.,Ltd.<br> All Rights Reserved.</td>
			</tr>
		</table>
	</center>
</body>
</html>

