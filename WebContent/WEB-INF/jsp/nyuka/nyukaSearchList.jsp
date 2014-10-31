<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ysbyCheck.js"></script>
<script type="text/javascript">
	function doSearch() {

		var object = document.forms[0];

		//搬入日のチェック
		if(object.han_ymd.value == "") {
			alert("MSG1500:"+'<s:text name="MSG1500"/>');
			return;
		}else if (!CheckDate(object.han_ymd.value.substring(0, 4),
				object.han_ymd.value.substring(4, 6), object.han_ymd.value
						.substring(6))) {
			alert("MSG1501:"+'<s:text name="MSG1501"/>');
			return;
		}

		object.action = "nyukaDataRefer";

		window.setTimeout('document.forms[0].submit()', 10);

	}

	function doSearch1() {
		if (event.keyCode == 13) {
			doSearch();
		}
	}

	//ダウンロードより遷移した場合
	function download() {

	}

	function top_test(filename) {
		alert("top_test=" + filename);
		doSearch();
	}
	
//-->
</script>
<title>SHO物流WEBシステム</title>
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
<style>
	body, html {
  margin: 0;
 padding:0 !important;
 width:100%;
 height:100%;
 overflow-x: hidden;
 overflow:hidden;
}
</style>	
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="10"
	marginheight="10" scroll="NO">
	<%@include file="../header.jsp"%>
	<s:form action="nyukaDataRefer" focus="han_ymd"
		onSubmit="return false;" styleClass="default">

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
							<td class="ContentsTitle">入荷情報</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="5"></td>
			</tr>
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="1">
						<tr>
							<td width="60" class="SearchText" align="middle" nowrap>搬入日</td>
							<td valign="left" nowrap><input name="han_ymd" type="text"
								class="textbox" style="width: 5em" title="YYYYMMDD" autofocus
								maxlength="8" value='<s:property value="han_ymd"/>'></td>
						</tr>
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
											href="javascript:doSearch()"><span class="closeBTN">検索</span></a></td>
									</tr>
								</table>
							</td>
							<td width=10></td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="5"></td>
						</tr>
					</table>
				</td>

			</tr>
		</table>
		<table width="100%" style="margin-bottom: 1em;">
			<tr>
				<td bgcolor="D9D9D9"></td>
			</tr>
		</table>

	</s:form>
</body>
</html>