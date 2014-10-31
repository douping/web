<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>SHO物流WEBシステム</title>
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript">
		function doPageTurn(startIndex){
			document.getElementById("startIndex").value = startIndex;
			document.forms[0].submit();
		}
		
		function doView(url){
            window.open(url,'品番別在庫管理詳細画面','location=no,status=no,scrollbars=yes,resizable=yes,width=800,height=800');
		}
		
		function doSearch(){
			document.getElementById("startIndex").value = 0;
			document.forms[0].submit();
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
.header {
 background:#FFF;
 width:100%;
 height:210px;
 overflow:hidden;
 position:absolute;
 top:0;
 width:100%;
}

.dbody {
 position:absolute!important;
 position:relative;
 top:212px!important;
 top:0;
 bottom:32px;
 width:100%;
 overflow:hidden;
 height:auto!important;
 height:100%;
 left: -3px;
}
.main {
 height:100%;
 background:#FFF;
 overflow-y:auto;
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
	marginheight="10">
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
								src="<%=request.getContextPath()%>/images/title_icn.gif" alt=" "
								width="14" height="14"></td>
							<td class="ContentsTitle">在庫照会</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="5"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="currentPageStartIndex"
					id="currentPageStartIndex"
					value='<s:property value="page.getStartIndex()"/>'> <s:form
						action="hinbanZaikoSearch" method="post" onSubmit="return false;">
						<input type="hidden" name="startIndex" id="startIndex">
						<table border="0" cellspacing="0" cellpadding="1">
							<tr>
								<td width="80" class="SearchText" align="middle">メーカー品番</td>
								<td valign="left"><input name="tk_hin" type="text" autofocus
									class="textbox" style="width: 8em" maxlength="25"
									value='<s:property value="tk_hin"/>'></td>
								<td width="70" class="SearchText" align="middle">受入</td>
								<td valign="left"><input name="tk_uke" type="text"
									class="textbox" style="width: 5em" maxlength="5"
									value='<s:property value="tk_uke"/>'></td>
								<td width="70" class="SearchText" align="middle">仕入先背番</td>
								<td valign="left"><input name="seban" type="text"
									class="textbox" style="width: 8em" maxlength="10"
									value='<s:property value="seban"/>'></td>
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
		<table width="100%" style="margin-bottom: 1em;">
			<tr>
				<td bgcolor="D9D9D9"></td>
			</tr>
		</table>
	</div>
	<div class="dbody">
	    <div class="main">
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
						style="border-collapse: collapse;border:1px solid gray;" class="table_gray">

						<tr bgcolor="#6699FF">
							<td width="" align="center" class="ListTitle" nowrap>受入</td>
							<td width="" align="center" class="ListTitle" nowrap>メーカー背番</td>
							<td width="" align="center" class="ListTitle" nowrap>メーカー品番</td>
							<td width="" align="center" class="ListTitle" nowrap>収容数</td>
							<td width="" align="center" class="ListTitle" nowrap>在庫数</td>
							<td width="" align="center" class="ListTitle" nowrap>ロケ在庫数</td>
							<td width="" align="center" class="ListTitle" nowrap>引当可能在庫数</td>
							<td width="" align="center" class="ListTitle" nowrap>不足総数</td>
							<td width="" align="center" class="ListTitle" nowrap>管理工場</td>
							<td width="" align="center" class="ListTitle" nowrap>出荷拠点</td>
							<td width="" align="center" class="ListTitle" nowrap>製造場所</td>
							<td width="" align="center" class="ListTitle" nowrap>仕入背番</td>
							<td width="" align="center" class="ListTitle" nowrap>当日搬入数</td>
							<td width="" align="center" class="ListTitle" nowrap>ロケ</td>
							<td width="" align="center" class="ListTitle" nowrap>最終納入日</td>
							<td width="" align="center" class="ListTitle" nowrap>最終搬入日</td>
						</tr>
						<s:iterator value="page.list" status="index">
							<s:if test="#index.odd">
								<tr>
							</s:if>
							<s:else>
								<tr bgcolor="EEF1F5">
							</s:else>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="tk_uke" /></td>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="tk_seban" /></td>
							<td width="" align="left" class="textS3" nowrap><a
								href="javaScript:doView('hinbanZaikoDetailRefer.action?tk_uke=<s:property value="tk_uke"/>&tk_seban=<s:property value="tk_seban"/>&tk_hin=<s:property value="tk_hin"/>&syuyo_su=<s:property value="syuyo_su"/>&zaiko_su=<s:property value="zaiko_su"/>&loc_zaiko_su=<s:property value="loc_zaiko_su"/>&hiki_zaiko_su=<s:property value="hiki_zaiko_su"/>&fusoku_su=<s:property value="fusoku_su"/>&kanri_kojo=<s:property value="kanri_kojo"/>&s_kyoten=<s:property value="s_kyoten"/>&seizo_ba=<s:property value="seizo_ba"/>&seban=<s:property value="seban"/>&han_su=<s:property value="han_su"/>&location=<s:property value="location"/>&lst_nou_ymd=<s:property value="lst_nou_ymd"/>&lst_han_ymd=<s:property value="lst_han_ymd"/>')">
									<s:property value="tk_hin" />
							</a></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="syuyo_su" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="zaiko_su" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="loc_zaiko_su" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="hiki_zaiko_su" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="fusoku_su" /></td>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="kanri_kojo" /></td>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="s_kyoten" /></td>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="seizo_ba" /></td>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="seban" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="han_su" /></td>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="location" /></td>
							<td width="" align="center" class="textS2" nowrap><s:property
									value="lst_nou_ymd" /></td>
							<td width="" align="center" class="textS2" nowrap><s:property
									value="lst_han_ymd" /></td>
						</s:iterator>

						<tr bgcolor="#6699FF">
							<td width="" align="center" class="ListTitle" nowrap>受入</td>
							<td width="" align="center" class="ListTitle" nowrap>メーカー背番</td>
							<td width="" align="center" class="ListTitle" nowrap>メーカー品番</td>
							<td width="" align="center" class="ListTitle" nowrap>収容数</td>
							<td width="" align="center" class="ListTitle" nowrap>在庫数</td>
							<td width="" align="center" class="ListTitle" nowrap>ロケ在庫数</td>
							<td width="" align="center" class="ListTitle" nowrap>引当可能在庫数</td>
							<td width="" align="center" class="ListTitle" nowrap>不足総数</td>
							<td width="" align="center" class="ListTitle" nowrap>管理工場</td>
							<td width="" align="center" class="ListTitle" nowrap>出荷拠点</td>
							<td width="" align="center" class="ListTitle" nowrap>製造場所</td>
							<td width="" align="center" class="ListTitle" nowrap>仕入背番</td>
							<td width="" align="center" class="ListTitle" nowrap>当日搬入数</td>
							<td width="" align="center" class="ListTitle" nowrap>ロケ</td>
							<td width="" align="center" class="ListTitle" nowrap>最終納入日</td>
							<td width="" align="center" class="ListTitle" nowrap>最終搬入日</td>
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
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>