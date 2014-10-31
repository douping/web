<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ysbyCheck.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-1.9.0.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
        function doSearch(){

			var object = document.forms[0];

					//納入日のチェック
			if("" == object.nou_ymd.value){
				alert("MSG1400:"+'<s:text name="MSG1400"/>');
				return;
			}else if(!CheckDate(object.nou_ymd.value.substring(0,4), object.nou_ymd.value.substring(4,6), object.nou_ymd.value.substring(6))){
						alert("MSG1401:"+'<s:text name="MSG1401"/>');
						return;
					}
		        object.buttonType.value="1";
				window.setTimeout('document.forms[0].submit()', 10);

		}

        function doSearch1() {
            if (event.keyCode == 13) {
                doSearch();
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
	<s:form action="syukkaDataRefer" focus="downloadType" onSubmit="return false;"
		styleClass="default">
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
							<td class="ContentsTitle">出荷情報</td>
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
							<td width="80" class="SearchText" align="middle">検索データ</td>
							<td valign="middle" colspan="3">
								<s:select name="downloadType" theme="simple"
						list="#{'0':'TOPPS・受注実績','1':'TOPPS・出荷実績','6':'TOPPS・出荷ﾄﾚｰｻﾋﾞﾘﾃｨｰ','2':'順引・受注実績','3':'順引・出荷実績','4':'順引・出荷ﾄﾚｰｻﾋﾞﾘﾃｨｰ'}">
					</s:select> 
					<%--<select name="searchList" onchange="chgList()">
					               <s:if test=""></s:if>
									<option>TOPPS・受注実績</option>
									<option>TOPPS・出荷実績</option>
									<option>TOPPS・出荷ﾄﾚｰｻﾋﾞﾘﾃｨｰ</option>
									<option>順引・受注実績</option>
									<option>順引・出荷実績</option>
									<option>順引・出荷ﾄﾚｰｻﾋﾞﾘﾃｨｰ</option>
									<<option>順引・削除</option>
							</select>	--%>					

							</td>
						</tr>
						<tr>
							<td width="60" class="SearchText" align="middle" nowrap>納入日</td>
							<td valign="left" nowrap><input name="nou_ymd" type="text"
								class="textbox" style="width: 5em" title="YYYYMMDD"
								maxlength="8" value=<s:property value="nou_ymd"/>>～</td>
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
		<s:hidden name="startIndex" value="0" />
		<s:hidden name="orderBy" value="0" />
		<s:hidden name="buttonType" value="" />
	</s:form>
</body>
</html>