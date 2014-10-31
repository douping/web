<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>SHO物流WEBシステム</title>
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
<SCRIPT>
			function doPageTurn(startIndex){
				var object = document.forms[0];
				object.action="hannyuProgInit";
				object.startIndex.value=startIndex;
				object.submit();
			}

			function doView(url,nou_ymd,rg,bin_no){

				window.open(encodeURI(encodeURI(url)),"搬入進捗管理詳細画面","location=no,status=no,scrollbars=yes,resizable=yes,top=0,left=0,width=1000,height=800");

			}

	</SCRIPT>
<style>
body, html {
  margin: 0;
 padding:0 !important;
 padding:124px 0 32px 0;
 width:100%;
 height:100%;
 overflow:hidden;
}
.header {
 background:#FFF;
 width:100%;
 height:140px;
 overflow:hidden;
 position:absolute;
 top:0;
 width:100%;
}
.main {
 height:100%;
 background:#FFF;
 overflow-y:auto;
}
.dbody {
 position:absolute!important;
 position:relative;
 top:160px!important;
 top:0;
 bottom:32px;
 width:100%;
 overflow:hidden;
 height:auto!important;
 height:100%;
 left: -3px;
}


.table_gray td{
	border:1px solid gray;
}
#footer{
 background:#FFF;
 width:100%;
 height:48px;
 letter-spacing:1px;
 text-align:center;
 clear:both;
 position:absolute;
 bottom:0;
 left:0;
}
.space_margin{
padding:10px 10px;
}

</style>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="10"
	marginheight="10" style="overflow-y: hidden;">

	<div class="header">
		<%@include file="../header.jsp"%>
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
								src="<%=request.getContextPath()%>//images/title_icn.gif"
								alt=" " width="14" height="14"></td>
							<td class="ContentsTitle">入荷照会</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="5"></td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="5"></td>
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
			<tr>
				<td height="10"></td>
			</tr>
		</table>
	</div>
	<div class="dbody">
		<div class="main">
		<s:form action="" onSubmit="return false;" method="post">
			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0" class="space_margin">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table border="0" cellspacing="2" cellpadding="0">
										<tr>
											<td class="tableNumber"><s:property
													value="page.getDataCount()" /></td>
											<td class="textS1">&nbsp;&nbsp;件のうち&nbsp;&nbsp;</td>
											<td class="tableNumber"><s:if test="page.list.isEmpty()">
											0
										</s:if> <s:else>
													<s:property value="page.getStartNo()" />
												</s:else></td>
											<td class="textS1">&nbsp;&nbsp;件目から&nbsp;&nbsp;</td>
											<td class="tableNumber"><s:property
													value="page.getStartOfNextPage()" /></td>
											<td class="textS1">&nbsp;&nbsp;件目までを表示</td>
										</tr>
									</table>
								</td>
								<td align="right">
									<table border="0" cellspacing="2" cellpadding="0">
										<tr>
											<td class="tableNumber"><s:if test="page.list.isEmpty()">
											0
										</s:if> <s:else>
													<s:property value="page.getCurrentPageNo()" />
												</s:else></td>
											<td nowrap class="textS1">&nbsp;&nbsp;/&nbsp;&nbsp;</td>
											<td nowrap class="textS1"><s:property
													value="page.getPageCount()" /></td>
											<td nowrap class="textS1">&nbsp;&nbsp;ページ</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="1" cellspacing="0" cellpadding="4"
							style="border-collapse: collapse" class="table_gray">

							<tr bgcolor="#6699FF">
								<td width="" align="center" class="ListTitle" nowrap>搬入日</td>
								<td width="" align="center" class="ListTitle" nowrap>管理工場</td>
								<td width="" align="center" class="ListTitle" nowrap>出荷拠点</td>
								<td width="" align="center" class="ListTitle" nowrap>便</td>
								<td width="" align="center" class="ListTitle" nowrap>特車区分</td>
								<td width="" align="center" class="ListTitle" nowrap>回数</td>
								<td width="" align="center" class="ListTitle" nowrap>便ID</td>
								<td width="" align="center" class="ListTitle" nowrap>便名</td>
								<td width="" align="center" class="ListTitle" nowrap>状況</td>
								<td width="" align="center" class="ListTitle" nowrap>予定箱数</td>
								<td width="" align="center" class="ListTitle" nowrap>搬入個数</td>
							</tr>
							<s:iterator value="page.list" status="index" id="row">
								<s:if test="#index.odd">
									<tr>
								</s:if>
								<s:else>
									<tr bgcolor="EEF1F5">
								</s:else>
								<td width="" align="center" class="textS3" nowrap><a
									href="javaScript:doView('hannyuProgDetailRefer.action?han_ymd=<s:property value="han_ymd"/>&kanri_kojo=<s:property value="kanri_kojo"/>&s_kyoten=<s:property value="s_kyoten"/>&bin_no=<s:property value="bin_no"/>&tokusya_kb=<s:property value="tokusya_kb"/>&tokusya_kai=<s:property value="tokusya_kai"/>&bin_id=<s:property value="bin_id"/>&bin_nm=<s:property value="bin_nm"/>&hanjou_fg=<s:property value="hanjou_fg"/>&siji_hako=<s:property value="siji_hako"/>&han_hako=<s:property value="han_hako"/>&hanjou_key=<s:property value="hanjou_key"/>')">
										<s:property value="han_ymd" />
								</a></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="kanri_kojo" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="s_kyoten" /></td>
								<td width="" align="center" class="textS2" nowrap><s:property
										value="bin_no" /></td>
								<td width="" align="center" class="textS2" nowrap><s:property
										value="tokusya_kb" /></td>
								<td width="" align="right" class="textS2" nowrap><s:property
										value="tokusya_kai" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="bin_id" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="bin_nm" /></td>
								<!--状況-->
								<s:if test='#row.hanjou_key == "2"'>
									<!--黄緑-->
									<td width="" bgcolor="#00FF00" align="center" class="textS2"
										nowrap><s:property value="hanjou_fg" /></td>
								</s:if>
								<s:elseif test='#row.hanjou_key == "3"'>
									<!--水色-->
									<td width="" bgcolor="#00FFCC" align="center" class="textS2"
										nowrap><s:property value="hanjou_fg" /></td>
								</s:elseif>
								<s:elseif test='#row.hanjou_key == "4"'>
									<!--オレンジ-->
									<td width="" bgcolor="#FFCC00" align="center" class="textS2"
										nowrap><s:property value="hanjou_fg" /></td>
								</s:elseif>
								<s:elseif test='#row.hanjou_key == "5"'>
									<!--オレンジ-->
									<td width="" bgcolor="#FFCC00" align="center" class="textS2"
										nowrap><s:property value="hanjou_fg" /></td>
								</s:elseif>
								<s:elseif test='#row.hanjou_key == "6"'>
									<!--黄色-->
									<td width="" bgcolor="#FFFF00" align="center" class="textS2"
										nowrap><s:property value="hanjou_fg" /></td>
								</s:elseif>
								<s:else>
									<td width="" align="center" class="textS2" nowrap><s:property
											value="hanjou_fg" /></td>
								</s:else>
								<td width="" align="right" class="textS2" nowrap><s:property
										value="siji_hako" /></td>
								<td width="" align="right" class="textS2" nowrap><s:property
										value="han_hako" /></td>
								</tr>
							</s:iterator>
							<tr bgcolor="#6699FF">
								<td width="" align="center" class="ListTitle" nowrap>搬入日</td>
								<td width="" align="center" class="ListTitle" nowrap>管理工場</td>
								<td width="" align="center" class="ListTitle" nowrap>出荷拠点</td>
								<td width="" align="center" class="ListTitle" nowrap>便</td>
								<td width="" align="center" class="ListTitle" nowrap>特車区分</td>
								<td width="" align="center" class="ListTitle" nowrap>回数</td>
								<td width="" align="center" class="ListTitle" nowrap>便ID</td>
								<td width="" align="center" class="ListTitle" nowrap>便名</td>
								<td width="" align="center" class="ListTitle" nowrap>状況</td>
								<td width="" align="center" class="ListTitle" nowrap>予定箱数</td>
								<td width="" align="center" class="ListTitle" nowrap>搬入個数</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td align="center">
						<table border="0" cellspacing="4" cellpadding="0">
							<tr>
								<td colspan="5"></td>
							</tr>
							<tr>
								<td valign="top" class="LowerNavi"><s:if
										test="page.isPreviousPageAvailable()">
										<a
											href="javascript:doPageTurn(<s:property value="page.getStartOfPreviousPage()"/>)">
											<span class="LowerNavi"> 前の<s:property
													value="page.pageMax" />件 <img
												src="<%=request.getContextPath()%>/images/arrow_left.gif"
												width="16" height="16" border="0">
										</span>
										</a>
									</s:if></td>
								<td valign="middle" class="LowerNavi2"></td>
								<td valign="top"><s:if test="page.isNextPageAvailable()">
										<a
											href="javascript:doPageTurn(<s:property value="page.getStartOfNextPage()"/>);">
											<span class="LowerNavi"> <img
												src="<%=request.getContextPath()%>/images/arrow_right.gif"
												width="16" height="16" border="0"> 次の<s:property
													value="page.getNextPageCount()" />件
										</span>
										</a>
									</s:if></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<input name="startIndex" type="hidden">
		</s:form>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>