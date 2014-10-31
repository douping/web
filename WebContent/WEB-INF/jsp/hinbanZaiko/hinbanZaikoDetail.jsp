<%@ page language="java" 
    contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />

    <title>SHO物流WEBシステム</title>
    <link href="<%=request.getContextPath()%>/css/yazaki.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/yazaki_text.css" rel="stylesheet" type="text/css">
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
 height:200px;
 overflow:hidden;
 position:absolute;
 top:0;
 width:100%;
}

.detail_body {
 position:absolute!important;
 position:relative;
 top:216px!important;
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
.space_margin{
padding:10px 10px;
}
.table_gray td{
	border:1px solid gray;
}
.no_border td{
	border: 0;
}
</style>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
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
				<td bgcolor="#E1020E" height="2"></td>
			</tr>
		</table>

<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr><td height="5"></td></tr>
    <tr>
        <td>
            <table border="0" cellspacing="5" cellpadding="0">
                <tr>
					<td><img src="<%=request.getContextPath()%>/images/title_icn.gif" alt=" " width="14" height="14"></td>
					<td class="ContentsTitle">品番別在庫管理 【詳細画面】</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr><td height="1"></td></tr>
    <tr>
        <td>

			<table width="100%"  border="1" cellspacing="4" cellpadding="0" style="border-collapse:collapse" class="table_gray">

		      	<tr>
		      		<td width="20%" bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">受入</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td width="25%" colspan="2" class="tableCont2"><s:property value="tk_uke" /></td>

					<td width="15%" bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
								<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
										<tr>
											<td class="Cont03textS1">メーカー背番</td>
										</tr>
									</table>
								</td>
							</tr>
		            	</table>
					</td>
		      		<td colspan="5" class="tableCont2"><s:property value="tk_seban" /></td>
				</tr>
		      	<tr>
		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">メーカー品番</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="2" class="tableCont2"><s:property value="tk_hin" /></td>

		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">収容数</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="5" class="tableCont2"><s:property value="syuyo_su" /></td>
				</tr>

		      	<tr>
		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">在庫数</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="2" class="tableCont2"><s:property value="zaiko_su" /></td>

		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">ロケ在庫数</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="5" class="tableCont2"><s:property value="loc_zaiko_su" /></td>

				</tr>

		      	<tr>
		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">引当可能在庫数</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="2" class="tableCont2"><s:property value="hiki_zaiko_su" /></td>

		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">不足総数</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="5" class="tableCont2"><s:property value="fusoku_su" /></td>

				</tr>

		      	<tr>
		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">管理工場</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="2" class="tableCont2"><s:property value="kanri_kojo" /></td>

		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">出荷拠点</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="5" class="tableCont2"><s:property value="s_kyoten" /></td>

				</tr>

		      	<tr>
		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">製造場所</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="2" class="tableCont2"><s:property value="seizo_ba" /></td>

		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">仕入背番</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="5" class="tableCont2"><s:property value="seban" /></td>

				</tr>

		      	<tr>
		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">当日搬入数</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="2" class="tableCont2"><s:property value="han_su" /></td>

		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">ロケ</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="5" class="tableCont2"><s:property value="location" /></td>

				</tr>

		      	<tr>
		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">最終納入日</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="2" class="tableCont2"><s:property value="lst_nou_ymd" /></td>

		      		<td bgcolor="#ECF6FF">
						<table  border="0" cellspacing="0" cellpadding="0" class="no_border">
			            	<tr>
			            		<td bgcolor="8EAFE4" width="2"></td>
			            		<td width="1"></td>
			            		<td bgcolor="#B5CEF5" width="1"></td>
			            		<td width="5"></td>
			            		<td>
									<table width="100%"  border="0" cellspacing="3" cellpadding="0">
					                	<tr>
					                  		<td class="Cont03textS1">最終搬入日</td>
										</tr>
				                  	</table>
								</td>
			        		</tr>
		            	</table>
					</td>
		      		<td colspan="5" class="tableCont2"><s:property value="lst_han_ymd" /></td>

				</tr>

			</table>

			<table width="100%" border="0" cellspacing="0" cellpadding="0"><tr><td height="5"></td></tr></table>

			</table>
        </td>
	<tr>
		<td bgcolor="#D9D9D9" colspan="6"></td>
	</tr>
	<tr>
		<td bgcolor="#D9D9D9"></td>
	</tr>
</table>
<table width="100%">
    <tr>
        <td bgcolor="#D9D9D9"></td>
    </tr>
</table>

</div>
<div class="detail_body">
<div class="main">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="space_margin">
		<form name="form">
		<b id="top"></b>
		<table width="100%">
		    <tr>
		        <td bgcolor="D9D9D9"></td>
		    </tr>
		</table>
		<tr>
			<td>
				<table width="100%" border="1" cellspacing="0" cellpadding="4" style="border-collapse:collapse" class="table_gray">

			        <tr bgcolor="#6699FF">
						<td width="" align="center" class="ListTitle" nowrap>予定日</td>
						<td width="" align="center" class="ListTitle" nowrap>予定時刻</td>
						<td width="" align="center" class="ListTitle" nowrap>相手先</td>
						<td width="" align="center" class="ListTitle" nowrap>受入</td>
						<td width="" align="center" class="ListTitle" nowrap>便</td>
						<td width="" align="center" class="ListTitle" nowrap>納入番号</td>
						<td width="" align="center" class="ListTitle" nowrap>入出庫</td>
						<td width="" align="center" class="ListTitle" nowrap>搬入数</td>
						<td width="" align="center" class="ListTitle" nowrap>納入数</td>
						<td width="" align="center" class="ListTitle" nowrap>理論在庫</td>
		    	    </tr>

					<s:iterator value="hinbanZaikoDetails" status="index">
								<s:if test="#index.odd">
									<tr>
								</s:if>
								<s:else>
									<tr bgcolor="#EEF1F5">
								</s:else>

							<td width="" align="center" class="textS2" nowrap><s:property value="yotei_ymd" /></td>
							<td width="" align="center" class="textS2" nowrap><s:property value="yotei_hms" /></td>
			                <td width="" align="left"   class="textS2" nowrap><s:property value="a_jigyo_cd" /></td>
			                <td width="" align="left"   class="textS2" nowrap><s:property value="tk_uke" /></td>
			                <td width="" align="left"   class="textS2" nowrap><s:property value="bin_no" /></td>
			                <td width="" align="left"   class="textS2" nowrap><s:property value="tp_noban" /></td>
			                <td width="" align="left"   class="textS2" nowrap><s:property value="nyusyu_kb" /></td>
			                <td width="" align="right"  class="textS2" nowrap><s:property value="han_su" /></td>
			                <td width="" align="right"  class="textS2" nowrap><s:property value="siji_su" /></td>
			                <td width="" align="right"  class="textS2" nowrap><s:property value="w_riron_zaiko" /></td>

						</tr>
					</s:iterator>

			        <tr bgcolor="#6699FF">
						<td width="" align="center" class="ListTitle" nowrap>予定日</td>
						<td width="" align="center" class="ListTitle" nowrap>予定時刻</td>
						<td width="" align="center" class="ListTitle" nowrap>相手先</td>
						<td width="" align="center" class="ListTitle" nowrap>受入</td>
						<td width="" align="center" class="ListTitle" nowrap>便</td>
						<td width="" align="center" class="ListTitle" nowrap>納入番号</td>
						<td width="" align="center" class="ListTitle" nowrap>入出庫</td>
						<td width="" align="center" class="ListTitle" nowrap>搬入数</td>
						<td width="" align="center" class="ListTitle" nowrap>納入数</td>
						<td width="" align="center" class="ListTitle" nowrap>理論在庫</td>
		    	    </tr>

				</table>
			</td>
		</tr>
	</table>
	<a href="#top"><span style="color:red">&nbsp&nbsp▲データトップへ</span></a>
	</div>
	</div>
	<div class="detail_footer"></div>
</body>
</html>