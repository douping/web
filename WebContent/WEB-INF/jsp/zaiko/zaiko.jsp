<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ysbyCheck.js"></script>
<script type="text/javascript">
//ダウンロード
function doDownload(type) {

    var object = document.forms[0];

	if ((document.forms[0])){

		
			//過去在庫検索
			if( type == '2' ){

				//処理日の入力チェック
				if(object.syori_ymd.value == ""){
					alert("MSG1300:"+'<s:text name="MSG1300"/>');
					return;
				}

				//処理日の日付チェック
				if(!CheckDate(object.syori_ymd.value.substring(0,4), object.syori_ymd.value.substring(4,6), object.syori_ymd.value.substring(6))){
					alert("MSG1301:"+'<s:text name="MSG1301"/>');
					return;
				}
			}
			object.action="zaikoCSVDownload.action";
			object.downloadType.value=type;
            //object.buttonType.value="1";
            object.submit();
	}
}

	
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
	<s:form action="" method="post" onSubmit="return false;">
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
							<td class="ContentsTitle">在庫情報</td>
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
							<td width="60" class="SearchText" align="middle">処理日</td>
							<td valign="left"><input name="syori_ymd" type="text"
								class="textbox" style="width: 5em" title="YYYYMMDD"
								maxlength="8" autofocus></td>
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
										<td align="center" valign="top" bgcolor="6699FF"><a
											href="javascript:doDownload('1')"><span class="closeBTN">現在庫Download</span></a></td>
									</tr>
								</table>
							</td>
							<td width=10></td>
							<td valign="top" bgcolor="205598" width=80>
								<table width="100%" border="0" cellspacing="1" cellpadding="1">
									<tr>
										<td align="center" valign="top" bgcolor="6699FF"><a
											href="javascript:doDownload('2')"><span class="closeBTN">過去在庫Download</span></a></td>
									</tr>
								</table>
							</td>
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
		<table width="100%">
			<tr>
				<td bgcolor="D9D9D9"></td>
			</tr>
		</table>
		<s:hidden name="downloadType" />
	</s:form>
</body>
</html>