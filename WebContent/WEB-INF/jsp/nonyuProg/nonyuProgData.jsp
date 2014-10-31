<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS" import="java.net.URLDecoder"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String kado_date1 = (String)request.getAttribute("kado_date1");
	String kado_date2 = (String)request.getAttribute("kado_date2");
	String sCheckData = (String)request.getAttribute("checkData");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />
<title>SHO物流WEBシステム</title>
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/jquery-1.9.0.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function doView(url,parameter){
		var ajaxUrl = "checkHasDetail.action?"+parameter;
		var getDetailUrl = url+parameter;
		$.ajax({
             type: "POST",
             url: ajaxUrl,
             //data: {username:$("#username").val(), content:$("#content").val()},
             dataType: "json",
             success: function(data){
                        if(data == true){
                        	alert('MSG1700:'+'<s:text name="MSG1700"/>');
                        }else{
                        	window.open(encodeURI(encodeURI(getDetailUrl)),"納入進捗管理詳細画面","location=no,status=no,scrollbars=yes,resizable=yes,top=0,left=0,width=1000,height=800");            	
                        }
                      }
         });
		}		
	
			
	
			function doPageTurn(startIndex){
	        	var object = document.forms[0];
				document.getElementById("startIndex").value = startIndex;
				object.action="nonyuProgSearch";
				object.submit();
			}
			
			function doSearch(){
				var object =  document.forms[0];
				object.startIndex.value = 0;
	        	object.submit();
	        }
			
	</script>
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
	marginheight="10" scroll="NO">
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
							<td class="ContentsTitle">出荷照会</td>
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
						action="nonyuProgSearch" method="post" onSubmit="return false;">
						<input type="hidden" name="startIndex" id="startIndex">
						<table border="0" cellspacing="0" cellpadding="1">
							<tr>
								<td width="70" class="SearchText" align="middle">RG</td>
								<td valign="left"><input name="rg" type="text"
									class="textbox" style="width: 3em" maxlength="4"
									value='<s:property value="rg"/>' autofocus></td>
								<td width="70" class="SearchText" align="middle">並び順</td>
								<td class="tableCont1">
									<!--<select name="sort_fg">
							<option value="0" selected>納入日・RG・便</option>
							<option value="1">納入日・出発時間・RG・便</option>
						</select>--> <s:select name="sort_fg"
										list="#{'0':'納入日・RG・便','1':'納入日・出発時間・RG・便'}" theme="simple"
										class="tableCont1"></s:select>
								</td>
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
						style="border-collapse: collapse" class="table_gray">

						<tr bgcolor="#6699FF">
							<td width="" align="center" class="ListTitle" nowrap>納入日</td>
							<td width="" align="center" class="ListTitle" nowrap>RG</td>
							<td width="" align="center" class="ListTitle" nowrap>便</td>
							<td width="" align="center" class="ListTitle" nowrap>出発時間</td>
							<td width="" align="center" class="ListTitle" nowrap>受注区分</td>
							<td width="" align="center" class="ListTitle" nowrap>追</td>
							<td width="" align="center" class="ListTitle" nowrap>Ｔ</td>
							<td width="" align="center" class="ListTitle" nowrap>手</td>
							<td width="" align="center" class="ListTitle" nowrap>書</td>
							<td width="" align="center" class="ListTitle" nowrap>中</td>
							<td width="" align="center" class="ListTitle" nowrap>完</td>
							<td width="" align="center" class="ListTitle" nowrap>出</td>
							<td width="" align="center" class="ListTitle" nowrap>引当</td>
							<td width="" align="center" class="ListTitle" nowrap>指示箱数</td>
							<td width="" align="center" class="ListTitle" nowrap>不足箱数</td>
							<td width="" align="center" class="ListTitle" nowrap>準備箱数</td>
							<td width="" align="center" class="ListTitle" nowrap>積載容積</td>
						</tr>
						<s:iterator value="page.list" status="index" id="row">
							<s:if test="#index.odd">
								<tr>
							</s:if>
							<s:else>
								<tr bgcolor="EEF1F5">
							</s:else>
							<!--納入日+出発時間で色変え Start-->
							<s:if test='#row.nou_daytime < request.kado_date2'>
								<s:if test='#row.w_syukka_kan !="出"'>
									<td width="" bgcolor="#FF99CC" align="center" class="textS3"
										nowrap><a
										href="javaScript:doView('nonyuProgDetailRefer.action?','nou_ymd=<s:property value="nou_ymd"/>&rg=<s:property value="rg"/>&bin_no=<s:property value="bin_no"/>&noujou_fg=<s:property value="noujou_fg"/>&nou_tim=<s:property value="nou_tim"/>&juchu_kb_name=<s:property value="juchu_kb_name"/>&tuika_fg=<s:property value="tuika_fg"/>&w_topps_jyucyu=<s:property value="w_topps_jyucyu"/>&w_hand_jyucyu=<s:property value="w_hand_jyucyu"/>&w_siji_hakko=<s:property value="w_siji_hakko"/>&w_jyunbi_cyu=<s:property value="w_jyunbi_cyu"/>&w_jyunbi_kan=<s:property value="w_jyunbi_kan"/>&w_syukka_kan=<s:property value="w_syukka_kan"/>&hiki_fg=<s:property value="hiki_fg"/>&siji_hako=<s:property value="siji_hako"/>&fusoku_hako=<s:property value="fusoku_hako"/>&junbi_hako=<s:property value="junbi_hako"/>&seki_vol=<s:property value="seki_vol"/>&juchu_kb=<s:property value="juchu_kb"/>&ijou_kb=<s:property value="ijou_kb"/>&hikiyokusi_fg=<s:property value="hikiyokusi_fg"/>&hikiate=<s:property value="hikiate"/>&nou_daytime=<s:property value="nou_daytime"/>')">
											<s:property value="nou_ymd" />
									</a></td>
									<td width="" bgcolor="#FF99CC" align="left" class="textS2"
										nowrap><s:property value="rg" /></td>
									<td width="" bgcolor="#FF99CC" align="left" class="textS2"
										nowrap><s:property value="bin_no" /></td>
									<td width="" bgcolor="#FF99CC" align="center" class="textS2"
										nowrap><s:property value="nou_tim" /></td>
								</s:if>
								<s:else>
									<td width="" align="center" class="textS3" nowrap><a
										href="javaScript:doView('nonyuProgDetailRefer.action?','nou_ymd=<s:property value="nou_ymd"/>&rg=<s:property value="rg"/>&bin_no=<s:property value="bin_no"/>&noujou_fg=<s:property value="noujou_fg"/>&nou_tim=<s:property value="nou_tim"/>&juchu_kb_name=<s:property value="juchu_kb_name"/>&tuika_fg=<s:property value="tuika_fg"/>&w_topps_jyucyu=<s:property value="w_topps_jyucyu"/>&w_hand_jyucyu=<s:property value="w_hand_jyucyu"/>&w_siji_hakko=<s:property value="w_siji_hakko"/>&w_jyunbi_cyu=<s:property value="w_jyunbi_cyu"/>&w_jyunbi_kan=<s:property value="w_jyunbi_kan"/>&w_syukka_kan=<s:property value="w_syukka_kan"/>&hiki_fg=<s:property value="hiki_fg"/>&siji_hako=<s:property value="siji_hako"/>&fusoku_hako=<s:property value="fusoku_hako"/>&junbi_hako=<s:property value="junbi_hako"/>&seki_vol=<s:property value="seki_vol"/>&juchu_kb=<s:property value="juchu_kb"/>&ijou_kb=<s:property value="ijou_kb"/>&hikiyokusi_fg=<s:property value="hikiyokusi_fg"/>&hikiate=<s:property value="hikiate"/>&nou_daytime=<s:property value="nou_daytime"/>')">
											<s:property value="nou_ymd" />
									</a></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="rg" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="bin_no" /></td>
									<td width="" align="center" class="textS2" nowrap><s:property
											value="nou_tim" /></td>
								</s:else>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS3" nowrap><a
									href="javaScript:doView('nonyuProgDetailRefer.action?','nou_ymd=<s:property value="nou_ymd"/>&rg2=<s:property value="rg"/>&rg=<s:property value="rg"/>&bin_no=<s:property value="bin_no"/>&noujou_fg=<s:property value="noujou_fg"/>&nou_tim=<s:property value="nou_tim"/>&juchu_kb_name=<s:property value="juchu_kb_name"/>&tuika_fg=<s:property value="tuika_fg"/>&w_topps_jyucyu=<s:property value="w_topps_jyucyu"/>&w_hand_jyucyu=<s:property value="w_hand_jyucyu"/>&w_siji_hakko=<s:property value="w_siji_hakko"/>&w_jyunbi_cyu=<s:property value="w_jyunbi_cyu"/>&w_jyunbi_kan=<s:property value="w_jyunbi_kan"/>&w_syukka_kan=<s:property value="w_syukka_kan"/>&hiki_fg=<s:property value="hiki_fg"/>&siji_hako=<s:property value="siji_hako"/>&fusoku_hako=<s:property value="fusoku_hako"/>&junbi_hako=<s:property value="junbi_hako"/>&seki_vol=<s:property value="seki_vol"/>&juchu_kb=<s:property value="juchu_kb"/>&ijou_kb=<s:property value="ijou_kb"/>&hikiyokusi_fg=<s:property value="hikiyokusi_fg"/>&hikiate=<s:property value="hikiate"/>&nou_daytime=<s:property value="nou_daytime"/>')">
										<s:property value="nou_ymd" />
								</a></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="rg" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="bin_no" /></td>
								<td width="" align="center" class="textS2" nowrap><s:property
										value="nou_tim" /></td>
							</s:else>
							<!--納入日+出発時間で色変え End-->

							<td width="" align="left" class="textS2" nowrap><s:property
									value="juchu_kb_name" /></td>
							<td width="" align="center" class="textS2" nowrap><s:property
									value="tuika_fg" /></td>
							<!--Ｔ-->
							<s:if test='#row.w_topps_jyucyu == "Ｔ"'>
								<s:if test='#row.ijou_kb == ""'>
									<td bgcolor="#FF9900" width="" align="center" class="textS2"
										nowrap>
								</s:if>
								<s:elseif test='#row.ijou_kb == "00"'>
									<td bgcolor="#FF9900" width="" align="center" class="textS2"
										nowrap>
								</s:elseif>
								<s:else>
									<td bgcolor="#FF3300" width="" align="center" class="textS2"
										nowrap>
								</s:else>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_topps_jyucyu" />
							</td>
							<!--手-->
							<s:if test='#row.w_hand_jyucyu == "手"'>
								<td bgcolor="#FFFF00" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_hand_jyucyu" />
							</td>
							<!--書-->
							<s:if test='#row.w_siji_hakko == "書"'>
								<td bgcolor="#336600" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_siji_hakko" />
							</td>
							<!--中-->
							<s:if test='#row.w_jyunbi_cyu == "中"'>
								<td bgcolor="#33CC00" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_jyunbi_cyu" />
							</td>
							<!--完-->
							<s:if test='#row.w_jyunbi_kan == "完"'>
								<td bgcolor="#00CCFF" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_jyunbi_kan" />
							</td>
							<!--出-->
							<s:if test='#row.w_syukka_kan == "出"'>
								<td bgcolor="#CC33FF" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_syukka_kan" />
							</td>
							<!--引当-->
							<s:if test='#row.hiki_fg == "▲"'>
								<td bgcolor="#FFFF00" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:elseif test='#row.hiki_fg == "×"'>
								<td bgcolor="#FF3300" width="" align="center" class="textS2"
									nowrap>
							</s:elseif>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="hikiate" />
							</td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="siji_hako" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="fusoku_hako" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="junbi_hako" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="seki_vol" /></td>
							</tr>
						</s:iterator>
						<tr bgcolor="#6699FF">
							<td width="" align="center" class="ListTitle" nowrap>納入日</td>
							<td width="" align="center" class="ListTitle" nowrap>RG</td>
							<td width="" align="center" class="ListTitle" nowrap>便</td>
							<td width="" align="center" class="ListTitle" nowrap>出発時間</td>
							<td width="" align="center" class="ListTitle" nowrap>受注区分</td>
							<td width="" align="center" class="ListTitle" nowrap>追</td>
							<td width="" align="center" class="ListTitle" nowrap>Ｔ</td>
							<td width="" align="center" class="ListTitle" nowrap>手</td>
							<td width="" align="center" class="ListTitle" nowrap>書</td>
							<td width="" align="center" class="ListTitle" nowrap>中</td>
							<td width="" align="center" class="ListTitle" nowrap>完</td>
							<td width="" align="center" class="ListTitle" nowrap>出</td>
							<td width="" align="center" class="ListTitle" nowrap>引当</td>
							<td width="" align="center" class="ListTitle" nowrap>指示箱数</td>
							<td width="" align="center" class="ListTitle" nowrap>不足箱数</td>
							<td width="" align="center" class="ListTitle" nowrap>準備箱数</td>
							<td width="" align="center" class="ListTitle" nowrap>積載容積</td>
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