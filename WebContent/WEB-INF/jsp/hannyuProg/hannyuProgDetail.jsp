<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String name1 = (String)request.getAttribute("name1");
	String name2 = (String)request.getAttribute("name2");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SHO物流WEBシステム</title>
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
<SCRIPT>
		<!--

		//-->
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
				<td valign="top" background="../images/detail_back.gif" width="80">
					<table width="100%" border="0" cellpadding="0" cellspacing="3">
						<tbody>
							<tr>
								<td valign="top" bgcolor="205598">
									<table width="100%" border="0" cellspacing="1" cellpadding="1">
										<tbody>
											<tr>
												<td align="center" valign="top" bgcolor="AEC9FA"><a
													href="javascript:parent.close()"><span class="closeBTN">閉じる</span></a></td>
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
						<td class="ContentsTitle">搬入進捗管理 【詳細画面】</td>
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
					cellpadding="4" style="border-collapse: collapse" class="table_gray">

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
					<tr>
						<td width="" align="center" class="textS2" nowrap><s:property
								value="han_ymd" /></td>
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
						<s:if test='hanjou_key == "2"'>
							<!--黄緑-->
							<td width="" bgcolor="#00FF00" align="center" class="textS2"
								nowrap><s:property value="hanjou_fg" /></td>
						</s:if>
						<s:elseif test='hanjou_key == "3"'>
							<!--水色-->
							<td width="" bgcolor="#00FFCC" align="center" class="textS2"
								nowrap><s:property value="hanjou_fg" /></td>
						</s:elseif>
						<s:elseif test='hanjou_key == "4"'>
							<!--オレンジ-->
							<td width="" bgcolor="#FFCC00" align="center" class="textS2"
								nowrap><s:property value="hanjou_fg" /></td>
						</s:elseif>
						<s:elseif test='hanjou_key == "5"'>
							<!--オレンジ-->
							<td width="" bgcolor="#FFCC00" align="center" class="textS2"
								nowrap><s:property value="hanjou_fg" /></td>
						</s:elseif>
						<s:elseif test='hanjou_key == "6"'>
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
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="5"></td>
					</tr>
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
												value="hannyuProgDetails.size()" /></td>
										<td class="textS1">&nbsp;&nbsp;件目までを表示</td>
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
							<td width="" align="center" class="ListTitle" nowrap>メーカー品番</td>
							<td width="" align="center" class="ListTitle" nowrap>収容数</td>
							<td width="" align="center" class="ListTitle" nowrap>仕入先背番</td>
							<td width="" align="center" class="ListTitle" nowrap><%=name1%></td>
							<td width="" align="center" class="ListTitle" nowrap><%=name2%></td>
							<td width="" align="center" class="ListTitle" nowrap>搬入数</td>
							<td width="" align="center" class="ListTitle" nowrap>搬入箱数</td>
							<td width="" align="center" class="ListTitle" nowrap>差</td>
							<td width="" align="center" class="ListTitle" nowrap>出荷拠点</td>
							<td width="" align="center" class="ListTitle" nowrap>製造場所</td>
						</tr>

						<s:iterator value="hannyuProgDetails" status="index" id="row">
							<s:if test="#index.odd">
								<tr>
							</s:if>
							<s:else>
								<tr bgcolor="EEF1F5">
							</s:else>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="tk_hin" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="syuyo_su" /></td>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="seban" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="siji_su" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="siji_hako" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="han_su" /></td>
							<td width="" align="right" class="textS2" nowrap><s:property
									value="han_hako" /></td>
							<s:if test='sa > 0'>
								<td width="" bgcolor="#FF3300" align="right" class="textS2"
									nowrap><s:property value="sa" /></td>
							</s:if>
							<s:else>
								<td width="" align="right" class="textS2" nowrap><s:property
										value="sa" /></td>
							</s:else>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="s_kyoten" /></td>
							<td width="" align="left" class="textS2" nowrap><s:property
									value="seizo_ba" /></td>
							</tr>
						</s:iterator>

						<tr bgcolor="#6699FF">
							<td width="" align="center" class="ListTitle" nowrap>メーカー品番</td>
							<td width="" align="center" class="ListTitle" nowrap>収容数</td>
							<td width="" align="center" class="ListTitle" nowrap>仕入先背番</td>
							<td width="" align="center" class="ListTitle" nowrap><%=name1%></td>
							<td width="" align="center" class="ListTitle" nowrap><%=name2%></td>
							<td width="" align="center" class="ListTitle" nowrap>搬入数</td>
							<td width="" align="center" class="ListTitle" nowrap>搬入箱数</td>
							<td width="" align="center" class="ListTitle" nowrap>差</td>
							<td width="" align="center" class="ListTitle" nowrap>出荷拠点</td>
							<td width="" align="center" class="ListTitle" nowrap>製造場所</td>
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