<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />

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

			} else if (selectObj.options[2].selected == true) {
				//クリア
				$(this).prop('checked', false);
			}
		});
	}
	
	
	//ダウンロード(実際にはreDownloadで行う)
	function doDownload() {

		var object = document.forms[1];

		var $obj = $('.checkFlg');
		var flag = false;
		$obj.each(function(i) {
			if($(this).prop('checked')){
				flag = true;
			}
		});
		if(!flag){
			alert("MSG1502:"+'<s:text name="MSG1502"/>');
			return;
		}
		object.action="nyukaUpdate";
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
		object.action="nyukaCSVDownload";
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
 height:200px;
 overflow:hidden;
 position:absolute;
 top:0;
 width:100%;
}

.dbody {
 position:absolute!important;
 position:relative;
 top:210px!important;
 top:0;
 bottom:0px;
 width:100%;
 overflow:hidden;
 height:auto!important;
 height:100%;
 left: -3px;
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

.table_gray td{
	border:1px solid gray;
}
</style>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="10"
	marginheight="10" onLoad="javascript:reDownload_chk();">
	<div class="header">
		<%@include file="nyukaSearchList.jsp"%>
	</div>
	<div class="dbody">
		<s:form action="nyukaDataRefer">

			<table width="50%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td><s:if test="dataCount != 0">

							<a name="top"></a>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>

									<td valign="top" bgcolor="205598" width=80>
										<table width="100%" border="0" cellspacing="1" cellpadding="1">
											<tr>
												<td align="center" valign="center" bgcolor="6699FF"
													height=28><a href="javascript:doDownload()"><span
														class="closeBTN">Download</span></a></td>
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
							</table>
						</s:if></td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="1" cellspacing="0" cellpadding="4"
							style="border-collapse: collapse" class="table_gray">

							<tr bgcolor="#6699FF">

								<td width="10%"><select name="checklist"
									onchange="setList(this)">
										<option>ALL</option>
										<option>未受信</option>
										<option selected>クリア</option>
								</select></td>
								<td width="10%" align="center" class="ListTitle2" nowrap>受信状態</td>
								<td width="10%" align="center" class="ListTitle2" nowrap>便No</td>
							</tr>

							<s:iterator value="nyukas" status="index">
								<s:if test="#index.odd">
									<tr>
								</s:if>
								<s:else>
									<tr bgcolor="EEF1F5">
								</s:else>

								<td align="center" class="textS2" nowrap><input
									name="checkFlg" class="checkFlg" type="checkbox"
									class="checkFlg"
									value='<s:property value="bin_no"/>,<s:property value="#index.index"/>'>
									<input name="sendValue" type="hidden"
									value='<s:property value="jyushin"/>'></td>
								<td align="center" class="textS2" nowrap><s:property
										value="jyushin" /></td>
								<td align="center" class="textS2" nowrap><s:property
										value="bin_no" /></td>

								</tr>
							</s:iterator>
							<tr bgcolor="#6699FF">
								<td width="" align="center" class="ListTitle2" nowrap></td>
								<td width="" align="center" class="ListTitle2" nowrap>受信状態</td>
								<td width="" align="center" class="ListTitle2" nowrap>便No</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<input type="hidden" name="reSearchFlg" id="reSearchFlg"
				value='<s:property value="reSearchFlg"/>'>
			<input type="hidden" name="checkFlag"
				value='<s:property value="checkFlag"/>'>
			<input type="hidden" name="han_ymd"
				value='<s:property value="han_ymd"/>'>
		</s:form>
	</div>
	<div id="footer"></div>
</body>
</html>