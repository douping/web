<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String kado_date1 = (String)request.getAttribute("kado_date1");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />
<title>SHO物流WEBシステム</title>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
<style>
body, html {
  margin: 0;
 padding:0 !important;
 padding:124px 0 32px 0;
 width:100%;
 height:100%;
 overflow:hidden;
}
.detail_header {
 background:#FFF;
 width:100%;
 height:120px;
 overflow:hidden;
 position:absolute;
 top:0;
 width:100%;
}

.detail_body {
 position:absolute!important;
 position:relative;
 top:140px!important;
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
 padding:0 10px 0 10px;
}
.detail_footer{
 background:#FFF;
 width:100%;
 height:20px;
 letter-spacing:1px;
 text-align:center;
 clear:both;
 position:absolute;
 bottom:0;
 left:0;
}

.table_gray td{
	border:1px solid gray;
}
</style>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" bottommargin="10"
	marginwidth="10" marginheight="10">
	<div class="detail_header">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<td valign="top"
						background="<%=request.getContextPath()%>/images/detail_back.gif"
						width="80">
						<table width="100%" border="0" cellpadding="0" cellspacing="3">
							<tbody>
								<tr>
									<td valign="top" bgcolor="205598">
										<table width="100%" border="0" cellspacing="1" cellpadding="1">
											<tbody>
												<tr>
													<td align="center" valign="top" bgcolor="AEC9FA"><a
														href="javascript:parent.close()"><span
															class="closeBTN">閉じる</span></a></td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td align="right" valign="top"><img
						src="<%=request.getContextPath()%>/images/head_ttl.png" alt="翔運輸"
						width="150" height="20"></td>
				</tr>
			</tbody>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="E1020E" height="2"></td>
			</tr>
		</table>
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
							<td class="ContentsTitle">納入進捗管理 【詳細画面】</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="1"></td>
			</tr>
			<tr>
				<td>
					<table width="90%" align="center" border="1" cellspacing="0"
						cellpadding="4" style="border-collapse: collapse;" class="table_gray">

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
						<tr>
							<!--納入日+出発時間で色変え Start-->
							<s:if test='nou_daytime < request.kado_date2'>
								<s:if test='w_syukka_kan !="出"'>
									<td width="" bgcolor="#FF99CC" align="center" class="textS2"
										nowrap><s:property value="nou_ymd" /></td>
									<td width="" bgcolor="#FF99CC" align="left" class="textS2"
										nowrap><s:property value="rg" /></td>
									<td width="" bgcolor="#FF99CC" align="left" class="textS2"
										nowrap><s:property value="bin_no" /></td>
									<td width="" bgcolor="#FF99CC" align="center" class="textS2"
										nowrap><s:property value="nou_tim" /></td>
								</s:if>
								<s:else>
									<td width="" align="center" class="textS2" nowrap><s:property
											value="nou_ymd" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="rg" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="bin_no" /></td>
									<td width="" align="center" class="textS2" nowrap><s:property
											value="nou_tim" /></td>
								</s:else>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap><s:property
										value="nou_ymd" /></td>
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
							<s:if test='w_topps_jyucyu == "Ｔ"'>
								<s:if test='ijou_kb == ""'>
									<td bgcolor="#FF9900" width="" align="center" class="textS2"
										nowrap>
								</s:if>
								<s:elseif test='ijou_kb == "00"'>
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
							<s:if test='w_hand_jyucyu == "手"'>
								<td bgcolor="#FFFF00" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_hand_jyucyu" />
							</td>
							<!--書-->
							<s:if test='w_siji_hakko == "書"'>
								<td bgcolor="#336600" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_siji_hakko" />
							</td>
							<!--中-->
							<s:if test='w_jyunbi_cyu == "中"'>
								<td bgcolor="#33CC00" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_jyunbi_cyu" />
							</td>
							<!--完-->
							<s:if test='w_jyunbi_kan == "完"'>
								<td bgcolor="#00CCFF" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_jyunbi_kan" />
							</td>
							<!--出-->
							<s:if test='w_syukka_kan == "出"'>
								<td bgcolor="#CC33FF" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:else>
								<td width="" align="center" class="textS2" nowrap>
							</s:else>
							<s:property value="w_syukka_kan" />
							</td>
							<!--引当-->
							<s:if test='hiki_fg == "▲"'>
								<td bgcolor="#FFFF00" width="" align="center" class="textS2"
									nowrap>
							</s:if>
							<s:elseif test='hiki_fg == "×"'>
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

					</table>

					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="5"></td>
						</tr>
					</table>
		</table>
		</td>
		<tr>
			<td bgcolor="D9D9D9" colspan="6"></td>
		</tr>
		<tr>
			<td bgcolor="D9D9D9"></td>
		</tr>
		</table>
		<table width="100%">
			<tr>
				<td bgcolor="D9D9D9"></td>
			</tr>
			<tr>
				<td height="10"></td>
			</tr>
		</table>
	</div>
	<div class="detail_body">
		<div class="main">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="space_margin">
			<form name="form">
				<div id="top"></div>
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table border="0" cellspacing="2" cellpadding="0">
										<tr>
											<td class="tableNumber"><s:property
													value="nonyuProgDetails.size()" /></td>
											<td class="textS1">&nbsp;&nbsp;件表示</td>
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
								<td width="" align="center" class="ListTitle" nowrap>追加</td>
								<td width="" align="center" class="ListTitle" nowrap>支給先</td>
								<td width="" align="center" class="ListTitle" nowrap>受入</td>
								<td width="" align="center" class="ListTitle" nowrap>メーカー背番</td>
								<td width="" align="center" class="ListTitle" nowrap>メーカー品番</td>
								<td width="" align="center" class="ListTitle" nowrap>枝番</td>
								<td width="" align="center" class="ListTitle" nowrap>仕入背番</td>
								<td width="" align="center" class="ListTitle" nowrap>収容数</td>
								<td width="" align="center" class="ListTitle" nowrap>納入番号</td>
								<td width="" align="center" class="ListTitle" nowrap>受注数</td>
								<td width="" align="center" class="ListTitle" nowrap>不足数</td>
								<td width="" align="center" class="ListTitle" nowrap>準備数</td>
								<td width="" align="center" class="ListTitle" nowrap>打切残数</td>
								<td width="" align="center" class="ListTitle" nowrap>ｵﾘｼﾞﾅﾙ納入日</td>
								<td width="" align="center" class="ListTitle" nowrap>ｵﾘｼﾞﾅﾙ便</td>
								<td width="" align="center" class="ListTitle" nowrap>ｵﾘｼﾞﾅﾙ指示数</td>
								<td width="" align="center" class="ListTitle" nowrap>ｵﾘｼﾞﾅﾙ枝番</td>
							</tr>

							<s:iterator value="nonyuProgDetails" status="index" id="row">
								<s:if test="#index.odd">
									<tr>
								</s:if>
								<s:else>
									<tr bgcolor="EEF1F5">
								</s:else>

								<td width="" align="center" class="textS2" nowrap><s:property
										value="tuika_fg" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="tk_kojo" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="tk_uke" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="tk_seban" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="tk_hin" /></td>
								<td width="" align="right" class="textS2" nowrap><s:property
										value="edaban" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="seban" /></td>
								<td width="" align="right" class="textS2" nowrap><s:property
										value="syuyo_su" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="tp_noban" /></td>
								<td width="" align="right" class="textS2" nowrap><s:property
										value="siji_su" /></td>
								<!--不足数 Start-->
								<s:if test='#row.hiki_fg == "2"'>
									<td width="" bgcolor="#FFFF00" align="right" class="textS2"
										nowrap><s:property value="fusoku_su" /></td>
								</s:if>
								<s:elseif test='#row.hiki_fg == "3"'>
									<td width="" bgcolor="#FF3300" align="right" class="textS2"
										nowrap><s:property value="fusoku_su" /></td>
								</s:elseif>
								<s:else>
									<td width="" align="right" class="textS2" nowrap><s:property
											value="fusoku_su" /></td>
								</s:else>
								<!--不足数 End-->
								<td width="" align="right" class="textS2" nowrap><s:property
										value="junbi_su" /></td>
								<!--打切残数 Start-->
								<s:if test='#row.uchi_fg == "2"'>
									<td width="" bgcolor="#FFFF00" align="right" class="textS2"
										nowrap><s:property value="uchi_zan_su" /></td>
								</s:if>
								<s:elseif test='#row.uchi_fg == "3"'>
									<td width="" bgcolor="#FF3300" align="right" class="textS2"
										nowrap><s:property value="uchi_zan_su" /></td>
								</s:elseif>
								<s:else>
									<td width="" align="right" class="textS2" nowrap><s:property
											value="uchi_zan_su" /></td>
								</s:else>
								<!--打切残数 End-->
								<td width="" align="center" class="textS2" nowrap><s:property
										value="org_nou_ymd" /></td>
								<td width="" align="left" class="textS2" nowrap><s:property
										value="org_bin_no" /></td>
								<td width="" align="right" class="textS2" nowrap><s:property
										value="org_siji_su" /></td>
								<td width="" align="right" class="textS2" nowrap><s:property
										value="org_edaban" /></td>
								</tr>
							</s:iterator>

							<tr bgcolor="#6699FF">
								<td width="" align="center" class="ListTitle" nowrap>追加</td>
								<td width="" align="center" class="ListTitle" nowrap>支給先</td>
								<td width="" align="center" class="ListTitle" nowrap>受入</td>
								<td width="" align="center" class="ListTitle" nowrap>メーカー背番</td>
								<td width="" align="center" class="ListTitle" nowrap>メーカー品番</td>
								<td width="" align="center" class="ListTitle" nowrap>枝番</td>
								<td width="" align="center" class="ListTitle" nowrap>仕入背番</td>
								<td width="" align="center" class="ListTitle" nowrap>収容数</td>
								<td width="" align="center" class="ListTitle" nowrap>納入番号</td>
								<td width="" align="center" class="ListTitle" nowrap>受注数</td>
								<td width="" align="center" class="ListTitle" nowrap>不足数</td>
								<td width="" align="center" class="ListTitle" nowrap>準備数</td>
								<td width="" align="center" class="ListTitle" nowrap>打切残数</td>
								<td width="" align="center" class="ListTitle" nowrap>ｵﾘｼﾞﾅﾙ納入日</td>
								<td width="" align="center" class="ListTitle" nowrap>ｵﾘｼﾞﾅﾙ便</td>
								<td width="" align="center" class="ListTitle" nowrap>ｵﾘｼﾞﾅﾙ指示数</td>
								<td width="" align="center" class="ListTitle" nowrap>ｵﾘｼﾞﾅﾙ枝番</td>
							</tr>

						</table>
					</td>
				</tr>
		</table>
	<a href="#top"><span style="color: red">&nbsp&nbsp▲データトップへ</span></a>
	</div>
	</div>
	<div class="detail_footer"></div>
</body>
</html>