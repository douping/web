<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />
<title>SHO物流WEBシステム</title>
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript">
	function doSearch() {
		var obj = document.forms[0];
		if(obj.oppswd.value == '' && obj.chgoppswd.value == '' ) {
			alert('MSG1200:'+'<s:text name="MSG1200"/>'+'\n'+'MSG1201:'+'<s:text name="MSG1201"/>');
			return;
		} else if(obj.oppswd.value == '') {
			alert('MSG1200:'+'<s:text name="MSG1200"/>');
			return;
		} else if(obj.chgoppswd.value == ''){
			alert('MSG1201:'+'<s:text name="MSG1201"/>');
			return;
		}
		obj.submit();
	}
</script>
<style>
	body, html {
  margin: 0;
 padding:0 !important;
 padding:124px 0 32px 0;
 width:100%;
 height:100%;
 overflow-x: hidden;
 overflow:hidden;
}
</style>
</head>
<%@include file="../header.jsp"%>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
	marginheight="0">

	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="5"></td>
		</tr>
		<tr>
			<td>
				<table border="0" cellspacing="5" cellpadding="0">
					<tr>
						<td><img
							src="<%=request.getContextPath()%>/images/title_icn.gif" alt=" "
							width="14" height="14"></td>
						<td class="ContentsTitle">パスワード変更</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="5"></td>
		</tr>
		<tr>
			<td><s:form action="passwordRefer" method="post">
					<table border="0" cellspacing="0" cellpadding="1">
						<tr>
							<td width="80" class="SearchText" align="middle">ユーザーＩＤ</td>
							<td valign="left"><input name="opcode" type="text"
								class="textbox" style="width: 9em" maxlength="17"
								value='<s:property value="opcode"/>' readonly></td>
						</tr>
						<tr>
							<td width="80" class="SearchText" align="middle">パスワード</td>
							<td valign="left"><input name="oppswd" type="password"
								class="textbox" style="width: 9em" maxlength="8"></td>
						</tr>
						<tr>
							<td width="80" class="SearchText" align="middle">変更パスワード</td>
							<td valign="left"><input name="chgoppswd" type="password"
								class="textbox" style="width: 9em" maxlength="8"></td>
						</tr>
						<tr>
							<td colspan="2" style="color: red;"><s:fielderror /></td>
						</tr>
						<%-- <tr>
							<s:textfield name="opcode" label="ユーザーＩＤ" readonly="true" />
						</tr>
						<tr>
							<s:password name="oppswd" label="パスワード" style="width: 9em"
								maxlength="8" />
						</tr>
						<tr>
							<s:password name="chgoppswd" label="変更パスワード" style="width: 9em"
								maxlength="8" />
						</tr>
						<tr>
							<div style="color: red;">
								<s:fielderror />
							</div>
						</tr> --%>
					</table>

					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="5"></td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="3" align="left">
						<tr>
							<td width=10></td>
							<td valign="top" bgcolor="205598" width=80>
								<table width="100%" border="0" cellspacing="1" cellpadding="1">
									<tr>
										<td align="center" valign="center" bgcolor="6699FF" height=28><a
											href="javascript:doSearch()"><span class="closeBTN">更新</span></a></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</s:form>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="5"></td>
					</tr>
				</table></td>
		</tr>
	</table>
	<table width="100%">
		<tr>
			<td bgcolor="D9D9D9"></td>
		</tr>
	</table>
</body>

<s:if test='#request.judgeRslt =="success"'>
	<%@include file="passwordSuccess.jsp"%>
</s:if>
<s:elseif test='#request.judgeRslt =="failure"'>
	<%@include file="passwordFailure.jsp"%>
</s:elseif>
