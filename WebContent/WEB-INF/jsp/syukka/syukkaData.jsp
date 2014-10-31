<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<title>SHO物流WEBシステム</title>
<link href="<%=request.getContextPath()%>/css/yazaki.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/yazaki_text.css"
	rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/jquery-1.9.0.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
		
		//対象データ選択時
		function setList(selectObj) {
			var $obj = $('.checkFlg');
			$obj.each(function(i) {
				if (selectObj.options[0].selected == true) {
					//ALL
					$(this).prop('checked', true);
	
				} else if (selectObj.options[1].selected == true) {
					//未受信
					if ($(this).next().val() == '済') {
						$(this).prop('checked', false);
					} else {
						$(this).prop('checked', true);
					}
	
				} else if( selectObj.options[2].selected == true ) {
					//クリア
					$(this).prop('checked', false);
				} 
			});
		}
		
		
		//ダウンロード
		function doDownload(downFlg) {

			var object = document.forms[1];
			var $obj = $('.checkFlg');
			var flag = false;
			$obj.each(function(i) {
				if($(this).prop('checked')) {
					flag = true;
				}
			});
			if(!flag){
				alert("MSG1402:"+'<s:text name="MSG1402"/>');
				return;
			}
			
			//ダウンロードボタンによって、フラグを変える 
			if( downFlg == '1' ){
				object.downFlg.value = "1";
			}else{
				object.downFlg.value = "2";
			}


			object.action="syukkaUpdate";
			object.submit();

		}
		
		function reDownload(){
			
				var object = document.forms[1];
	
				var str = object.checkFlag.value;
				
				var arr = str.split(',');
				var $obj = $('.checkFlg');
				$obj.each(function(i) {
					for(var j = 0; j < arr.length-1; j++){
						if(i==arr[j]){
							$(this).prop('checked', true);	
						}
					}
					
				});

				//ダウンロード処理コール
				object.action="syukkaCSVDownload";
				object.submit();
		}
		
		//だとデータが存在しない場合、functionが無効になる為
		function reDownload_chk(){
			var reSearchFlg = document.getElementById("reSearchFlg").value;
			
			if(reSearchFlg == '1'){
				reDownload();
			} 
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
 top:240px!important;
 top:0;
 bottom:32px;
 width:100%;
 overflow:hidden;
 height:auto!important;
 height:100%;
 left: -3px;
}

#footer{
 background:#FFF;
 width:100%;
 height:15px;
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
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="10"
	marginheight="10" onLoad="javascript:reDownload_chk();">
	<div class="header">
		<%@include file="syukkaSearchList.jsp"%>
	</div>
	<div class="dbody">
		<s:form action="syukkaDataRefer">
			<table width="50%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td><s:if test="syukkaList.size>0"><a name="top"></a>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>

								<td valign="top" bgcolor="205598" width=80>
									<table width="100%" border="0" cellspacing="1" cellpadding="1">
										<tr>
											<td align="center" valign="center" bgcolor="6699FF" height=28>
												<a href="javascript:doDownload('1')"><span
													class="closeBTN">Download</span></a>
											</td>
										</tr>
									</table>
								</td>
								<td valign="top" width=10></td>
								<td valign="top" bgcolor="205598" width=100>
									<table width="100%" border="0" cellspacing="1" cellpadding="1">
										<tr>
											<td align="center" valign="center" bgcolor="6699FF" height=28>
												<a href="javascript:doDownload('2')"><span
													class="closeBTN">差分Download</span></a>
											</td>
										</tr>
									</table>
								</td>
								<td align="right">
									<table border="0" cellspacing="2" cellpadding="0">
										<tr>
											<td class="tableNumber"><s:property value="dataCount" /></td>
											<td class="textS1">&nbsp;&nbsp;件&nbsp;&nbsp;</td>
										</tr>
									</table>
								</td>
							</tr>
						</table></s:if></td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="1" cellspacing="0" cellpadding="4"
							style="border-collapse: collapse" class="table_gray">

							<tr bgcolor="#6699FF">

								<td width="10%"><select name="checklist"
									onchange="setList(this);">
										<option>ALL</option>
										<option>未受信</option>
										<option selected>クリア</option>
								</select></td>
								<td width="10%" align="center" class="ListTitle2" nowrap>受信状態</td>
								<td width="15%" align="center" class="ListTitle2" nowrap>納入日</td>
								<td width="10%" align="center" class="ListTitle2" nowrap>便No</td>
								<td width="10%" align="center" class="ListTitle2" nowrap>得意先受入</td>
								<td width="10%" align="center" class="ListTitle2" nowrap>RG</td>
							</tr>
							<s:iterator value="syukkaList" status="index">
								<s:if test="#index.odd">
									<tr>
								</s:if>
								<s:else>
									<tr bgcolor="EEF1F5">
								</s:else>


								<td align="center" class="textS2" nowrap><input
									name="checkFlg" type="checkbox" class="checkFlg"
									value='<s:property value="nou_ymd"/>,<s:property value="bin_no"/>,<s:property value="tk_uke"/>,<s:property value="rg"/>,<s:property value="#index.index"/>'>
									<input name="sendValue" type="hidden" class="sendValue"
									value='<s:property value="jyushin"/>'></td>
								<td align="center" class="textS2" nowrap><s:property
										value="jyushin" /></td>
								<td align="center" class="textS2" nowrap><s:property
										value="nou_ymd" /></td>
								<td align="center" class="textS2" nowrap><s:property
										value="bin_no" /></td>
								<td align="center" class="textS2" nowrap><s:property
										value="tk_uke" /></td>
								<td align="center" class="textS2" nowrap><s:property
										value="rg" /></td>

								</tr>

							</s:iterator>
							<tr bgcolor="#6699FF">
								<td width="" align="center" class="ListTitle2" nowrap></td>
								<td width="" align="center" class="ListTitle2" nowrap>受信状態</td>
								<td width="" align="center" class="ListTitle2" nowrap>納入日</td>
								<td width="" align="center" class="ListTitle2" nowrap>便No</td>
								<td width="" align="center" class="ListTitle2" nowrap>得意先受入</td>
								<td width="" align="center" class="ListTitle2" nowrap>RG</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<input type="hidden" name="downFlg"
				value='<s:property value="downFlg"/>'>
			<input type="hidden" name="downloadType"
				value='<s:property value="downloadType"/>'>
			<input type="hidden" name="buttonType"
				value='<s:property value="buttonType"/>' />
			<input type="hidden" name="reSearchFlg" id="reSearchFlg"
				value='<s:property value="reSearchFlg"/>'>
			<input type="hidden" name="checkFlag"
				value='<s:property value="checkFlag"/>'>
			<s:hidden name="sSosinCheck" />
			<input type="hidden" name="nou_ymd"
				value='<s:property value="nou_ymd"/>'>
			<!--<a href="#top"><span style="color:red">&nbsp&nbsp▲データトップへ</span></a>-->
		</s:form>
	</div>
	<div id="footer"></div>
</body>
</html>