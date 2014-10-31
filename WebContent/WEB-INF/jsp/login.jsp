<%@ page language="java"
	import="java.util.*,java.io.*,ysbk_web.utility.CustomizedPropertyPlaceholderConfigurer"
	contentType="text/html; charset=Shift_JIS" pageEncoding="Shift_JIS"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />
<%
    String fileAddr = (String) CustomizedPropertyPlaceholderConfigurer
					.getContextProperty("information.txt");
	String s = null; //ファイルから取得文字列
	String ss = "";
	try {
		BufferedReader bread = new BufferedReader(new FileReader(
				new File(fileAddr)));
		while ((s = bread.readLine()) != null) {
			ss = ss + s + "\n";
		}
		bread.close();
	} catch (Exception e) {
		System.out.println(e.toString());
	}
%>
<title>SHO物流WEBシステム</title>
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
<SCRIPT>
	window.onload = function(){
		var oInput = document.forms[0];
		oInput.opcode.focus();
	}
	function doLogin() {
		var obj = document.forms[0];
		if(obj.opcode.value == '' && obj.oppswd.value == '' ) {
			alert('MSG1100:'+'<s:text name="MSG1100"/>'+'\n'+'MSG1101:'+'<s:text name="MSG1101"/>');
			return;
		} else if(obj.opcode.value == '') {
			alert('MSG1100:'+'<s:text name="MSG1100"/>');
			return;
		} else if(obj.oppswd.value == ''){
			alert('MSG1101:'+'<s:text name="MSG1101"/>');
			return;
		} else {
			obj.submit();	
		}
		
	}
</SCRIPT>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
	marginheight="0">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td valign="middle"><img src="./images/head_ttl.png" alt="翔運輸"
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
	<form action="login" method="post">
		<table border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td width="3" align="left" valign="top" bgcolor="#99BBE9"></td>
				<td bgcolor="#6699FF" height="30" align="center"><B><span
						style="font-size: 13pt; color: #663300">ユーザー認証</span></B></td>
				<td width="3" align="right" valign="top" bgcolor="#99BBE9"></td>
			</tr>
			<tr>
				<td align="left" valign="bottom" bgcolor="EBF1FC"><img
					src="<%=request.getContextPath()%>/images/login_r3.gif" alt=" "
					width="3" height="3"></td>
				<td bgcolor="EBF1FC">
					<table width="100%" border="0" cellspacing="10" cellpadding="0">
						<div style="color: red;">
							<s:fielderror />
						</div>
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="8" cellpadding="0">
									<tr>
										<td class="loginText" style="color: #1C5A6A;">ユーザーID</td>
									</tr>
									<tr>
										<td nowrap class="loginText" style="color: #1C5A6A;">パスワード</td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellspacing="6" cellpadding="0">
									<tr>
										<td class="textbox"><input name="opcode" type="text"></td>
									</tr>
									<tr>
										<td class="textbox"><input name="oppswd" type="password"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<table width="40%" border="0" cellpadding="0" cellspacing="3">
									<tr>
										<td valign="top" bgcolor="205598">
											<table width="100%" border="0" cellspacing="1"
												cellpadding="1">
												<tr>

													<td align="center" valign="top" bgcolor="AEC9FA"
														class="closeBTN"><a href="javascript:doLogin();">ログイン</a></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
				<td align="right" valign="bottom" bgcolor="EBF1FC"></td>
			</tr>
		</table>
	</form>

	<br>
	<br>
	<table border="0" align="center" cellpadding="0" cellspacing="6">
		<tr>
			<td align="center"><span style="font-size: 20pt"><B>Information</B></span>
				<br> <textarea name="MSG" cols=60 rows=10 readonly><%=ss%></textarea></td>
		</tr>
	</table>
	<table border="0" align="center" cellpadding="0" cellspacing="6">
		<tr>
			<td align="center" class="Copyright"><span
				style="font-size: 10pt">翔運輸株式会社</span> <br> Copyright 2006
				SHO-UNYU Co.,Ltd. <br>All Rights Reserved.</td>
		</tr>
	</table>
</body>
</html>