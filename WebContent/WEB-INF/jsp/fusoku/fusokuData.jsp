<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>SHO����WEB�V�X�e��</title>
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
<SCRIPT>
			function doPageTurn(startIndex){
				document.getElementById("startIndex").value = startIndex;
				document.forms[0].submit();
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
.main {
 height:100%;
 background:#FFF;
 overflow-y:auto;
}
#footer{
 background:#FFF;
 width:100%;
 height:22px;
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
.table_gray td{
	border:1px solid gray;
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
							<td class="ContentsTitle">�s���Ɖ�</td>
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
		<s:form action="fusokuInit" method="post">

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
												<td class="textS1">&nbsp;&nbsp;���̂���&nbsp;&nbsp;</td>
												<td class="tableNumber"><s:if
														test="page.list.isEmpty()">
											0
										</s:if> <s:else>
														<s:property value="page.getStartNo()" />
													</s:else></td>
												<td class="textS1">&nbsp;&nbsp;���ڂ���&nbsp;&nbsp;</td>
												<td class="tableNumber"><s:property
														value="page.getStartOfNextPage()" /></td>
												<td class="textS1">&nbsp;&nbsp;���ڂ܂ł�\��</td>
											</tr>
										</table>
									</td>
									<td align="right">
										<table border="0" cellspacing="2" cellpadding="0">
											<tr>
												<td class="tableNumber"><s:if
														test="page.list.isEmpty()">
											0
										</s:if> <s:else>
														<s:property value="page.getCurrentPageNo()" />
													</s:else></td>
												<td nowrap class="textS1">&nbsp;&nbsp;/&nbsp;&nbsp;</td>
												<td nowrap class="textS1"><s:property
														value="page.getPageCount()" /></td>
												<td nowrap class="textS1">&nbsp;&nbsp;�y�[�W</td>
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
									<td width="" align="center" class="ListTitle" nowrap>�[����</td>
									<td width="" align="center" class="ListTitle" nowrap>RG</td>
									<td width="" align="center" class="ListTitle" nowrap>��</td>
									<td width="" align="center" class="ListTitle" nowrap>���</td>
									<td width="" align="center" class="ListTitle" nowrap>���[�J�[�i��</td>
									<td width="" align="center" class="ListTitle" nowrap>���e��</td>
									<td width="" align="center" class="ListTitle" nowrap>�s����</td>
									<td width="" align="center" class="ListTitle" nowrap>�w����</td>
									<td width="" align="center" class="ListTitle" nowrap>���[�J�[�w��</td>
									<td width="" align="center" class="ListTitle" nowrap>�Ǘ��H��</td>
									<td width="" align="center" class="ListTitle" nowrap>�o�׋��_</td>
									<td width="" align="center" class="ListTitle" nowrap>�����ꏊ</td>
									<td width="" align="center" class="ListTitle" nowrap>���P�[�V����</td>
								</tr>
								<s:iterator value="page.list" status="index" id="row">
									<s:if test="#index.odd">
										<tr>
									</s:if>
									<s:else>
										<tr bgcolor="EEF1F5">
									</s:else>

									<td width="" align="center" class="textS2" nowrap><s:property
											value="nou_ymd" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="rg" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="bin_no" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="tk_uke" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="tk_hin" /></td>
									<td width="" align="right" class="textS2" nowrap><s:property
											value="syuyo_su" /></td>
									<td width="" align="right" class="textS2" nowrap><s:property
											value="fusoku_su" /></td>
									<td width="" align="right" class="textS2" nowrap><s:property
											value="siji_su" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="tk_seban" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="kanri_kojo" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="s_kyoten" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="seizo_ba" /></td>
									<td width="" align="left" class="textS2" nowrap><s:property
											value="location" /></td>
									</tr>
								</s:iterator>
								<tr bgcolor="#6699FF">
									<td width="" align="center" class="ListTitle" nowrap>�[����</td>
									<td width="" align="center" class="ListTitle" nowrap>RG</td>
									<td width="" align="center" class="ListTitle" nowrap>��</td>
									<td width="" align="center" class="ListTitle" nowrap>���</td>
									<td width="" align="center" class="ListTitle" nowrap>���[�J�[�i��</td>
									<td width="" align="center" class="ListTitle" nowrap>���e��</td>
									<td width="" align="center" class="ListTitle" nowrap>�s����</td>
									<td width="" align="center" class="ListTitle" nowrap>�w����</td>
									<td width="" align="center" class="ListTitle" nowrap>���[�J�[�w��</td>
									<td width="" align="center" class="ListTitle" nowrap>�Ǘ��H��</td>
									<td width="" align="center" class="ListTitle" nowrap>�o�׋��_</td>
									<td width="" align="center" class="ListTitle" nowrap>�����ꏊ</td>
									<td width="" align="center" class="ListTitle" nowrap>���P�[�V����</td>
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
												<span class="LowerNavi"> �O��<s:property
														value="page.pageMax" />�� <img
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
													width="16" height="16" border="0"> ����<s:property
														value="page.getNextPageCount()" />��
											</span>
											</a>
										</s:if></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<s:if test="!page.isPageNotEmpty()">
				<table>
					<tr>
						<td><img src="<%=request.getContextPath()%>/images/ex.gif"></td>
						<td><font color="red">MSG1600:<s:text
									name="MSG1600" />
						</font></td>
					</tr>
				</table>
			</s:if>
			<input type="hidden" id="startIndex" name="startIndex">
		
		</s:form>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>