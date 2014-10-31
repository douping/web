//曜日変換
function getDay(day){
	switch(day){
		case 0:
			return "日";
			break;
		case 1:
			return "月";
			break;
		case 2:
			return "火";
			break;
		case 3:
			return "水";
			break;
		case 4:
			return "木";
			break;
		case 5:
			return "金";
			break;
		case 6:
			return "土";
			break;
		default:
			return "";
			break;
	}
}

function CheckDate(nYear, nMonth, nDay) //nYearに年度,　nMonthに月, nDayに日付を渡してください。
{
	var dtCal = new Date;
	var strDate;
	var nMonthCount = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

	//年度のチェック （ここでは4桁チェック)
	if (nYear.length != 4)
	{
		//alert ("正しい年を入力してください。");
		return false;
	}
	//月のチェック
	if ((nMonth < 1) || (nMonth > 12))
	{
		//alert ("正しい月を入力してください。");
		return false;
	}

	dtCal.setYear(nYear);
	dtCal.setMonth(nMonth-1);
	var nDayCount = nMonthCount[nMonth-1];
	if ((nMonth == 2)&&(((nYear%4 == 0)&&(nYear%100 != 0))||(nYear%400 == 0)))
	{
		nDayCount = 29;
	}

	//日付チェック
	if ((nDay < 1) || (nDay > nDayCount))
	{
		//alert ("正しい日付を入力してください。");
		//alert ("ご参考に→"+nYear+"年"+nMonth+"月は"+nDayCount+"日までです。");
		return false;
	}
//	alert ("指定の日付は存在します。");
	return true;
}

//時刻をチェック nn:nn
function CheckTime(nTime)
{
	txt = nTime;
	data = txt.match(/^([01]?[0-9]|2[0-3]):([0-5][0-9])$/);
	if(!data){
		//alert("時刻が不正です");
		return false;
	}
	return true;
}



//システム日付を取得 yymmdd
function getSystemDay(){
            dd = new Date();
            yy = dd.getYear().toString();
            mm = dd.getMonth() + 1;
            dd = dd.getDate();
            if (yy < 2000) { yy += 1900; }
            if (mm < 10) { mm = "0" + mm; }
            if (dd < 10) { dd = "0" + dd; }
			return yy.substring(2,4) + mm + dd;
}

//品目No入力チェック
function chkHinmokuNo(Obj){
	cnt = 0;
	if( Obj.hinmokuNo1.value != "" ){
		cnt = cnt + 1;
	}
	if( Obj.hinmokuNo2.value != "" ){
		cnt = cnt + 1;
	}
	if( Obj.hinmokuNo3.value != "" ){
		cnt = cnt + 1;
	}
	if( Obj.hinmokuNo4.value != "" ){
		cnt = cnt + 1;
	}
	if( Obj.hinmokuNo5.value != "" ){
		cnt = cnt + 1;
	}
	if( Obj.hinmokuNo6.value != "" ){
		cnt = cnt + 1;
	}
	if(cnt == 0){
		return false;
	}else{
		return true;
	}
}


//数量チェック
function chkSuuryo(Obj){
	if( Obj.hinmokuNo1.value != "" ){
		if( Obj.suuryo1.value == "" || parseInt(Obj.suuryo1.value) == 0 ){
			return false;
		}
	}
	if( Obj.hinmokuNo2.value != "" ){
		if( Obj.suuryo2.value == "" || parseInt(Obj.suuryo2.value) == 0 ){
			return false;
		}
	}
	if( Obj.hinmokuNo3.value != "" ){
		if( Obj.suuryo3.value == "" || parseInt(Obj.suuryo3.value) == 0 ){
			return false;
		}
	}
	if( Obj.hinmokuNo4.value != "" ){
		if( Obj.suuryo4.value == "" || parseInt(Obj.suuryo4.value) == 0 ){
			return false;
		}
	}
	if( Obj.hinmokuNo5.value != "" ){
		if( Obj.suuryo5.value == "" || parseInt(Obj.suuryo5.value) == 0 ){
			return false;
		}
	}
	if( Obj.hinmokuNo6.value != "" ){
		if( Obj.suuryo6.value == "" || parseInt(Obj.suuryo6.value) == 0 ){
			return false;
		}
	}
	return true;
}


//単価チェック
function chkTanka(Obj){
	if( Obj.hinmokuNo1.value != "" ){
		if( Obj.tekiyo1.value == "" || Obj.tekiyo1.value.match(/[^0-9.]/) != null ){
			return false;
		}
	}
	if( Obj.hinmokuNo2.value != "" ){
		if( Obj.tekiyo2.value == "" || Obj.tekiyo2.value.match(/[^0-9.]/) != null ){
			return false;
		}
	}
	if( Obj.hinmokuNo3.value != "" ){
		if( Obj.tekiyo3.value == "" || Obj.tekiyo3.value.match(/[^0-9.]/) != null ){
			return false;
		}
	}
	if( Obj.hinmokuNo4.value != "" ){
		if( Obj.tekiyo4.value == "" || Obj.tekiyo4.value.match(/[^0-9.]/) != null ){
			return false;
		}
	}
	if( Obj.hinmokuNo5.value != "" ){
		if( Obj.tekiyo5.value == "" || Obj.tekiyo5.value.match(/[^0-9.]/) != null ){
			return false;
		}
	}
	if( Obj.hinmokuNo6.value != "" ){
		if( Obj.tekiyo6.value == "" || Obj.tekiyo6.value.match(/[^0-9.]/) != null ){
			return false;
		}
	}
	return true;
}
