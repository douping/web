<%@ page language="java" contentType="text/html;charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<script type="text/javascript">
//�e�@�\�֑J��
function send(str){
	if (str == 'zaiko') {
		window.location.href="../zaiko/zaikoInit.action";
	}else if (str == 'syukka') {
		window.location.href="../syukka/syukkaInit.action";
	}else if (str == 'nyuka') {
		window.location.href="../nyuka/nyukaInit.action";
	}else if (str == 'hinbanZaiko') {
		window.location.href="../hinbanZaiko/hinbanZaikoInit.action";
	}else if (str == 'fusoku') {
		window.location.href="../fusoku/fusokuInit.action";
	}else if (str == 'nonyu') {
		window.location.href="../nonyuProg/nonyuProgInit.action";
	}else if (str == 'hannyu') {
		window.location.href="../hannyuProg/hannyuProgInit.action";
	}else if (str == 'password') {
		window.location.href="../password/passwordInit.action";
	}else if (str == 'logout') {
		window.location.href="../logout.action";
	}
	
}
</script>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<img src='<%=request.getContextPath()%>/images/head_ttl.png' alt="�ĉ^�A"
			hspace="10">
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td bgcolor="E1020E" height="2"></td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center" bgcolor="DFEEFF">
			<table border="0" align="center" cellpadding="0" cellspacing="3">
				<tr>
					<td width="110">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext" nowrap>�Ɖ�</td>
							</tr>
						</table>
					</td>
					<td width="80">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext"><a
									href="javascript:send('hinbanZaiko')">�݌ɏƉ�</a></td>
							</tr>
						</table>
					</td>
					<td width="80">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext" nowrap><a
									href="javascript:send('nonyu')">�o�׏Ɖ�</a></td>
							</tr>
						</table>
					</td>
					<td width="80">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext" nowrap><a
									href="javascript:send('hannyu')">���׏Ɖ�</a></td>
							</tr>
						</table>
					</td>
					<td width="80">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext"><a
									href="javascript:send('fusoku')">�s���Ɖ�</a></td>
							</tr>
						</table>
					</td>
					<td width="50">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext"></td>
							</tr>
						</table>
					</td>
					<td width="100" align="right">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext"><a
									href="javascript:send('logout')">���O�A�E�g</a></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center" bgcolor="DFEEFF">
			<table border="0" align="center" cellpadding="0" cellspacing="3">
				<tr>
					<td width="110">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext" nowrap>�_�E�����[�h</td>
							</tr>
						</table>
					</td>
					<td width="80">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext" nowrap><a
									href="javascript:send('zaiko')">�݌ɏ��</a></td>
							</tr>
						</table>
					</td>
					<td width="80">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext"><a
									href="javascript:send('syukka')">�o�׏��</a></td>
							</tr>
						</table>
					</td>
					<td width="80">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext"><a
									href="javascript:send('nyuka')">���׏��</a></td>
							</tr>
						</table>
					</td>
					<td width="80">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext"></td>
							</tr>
						</table>
					</td>
					<td width="50">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext"></td>
							</tr>
						</table>
					</td>
					<td width="100" align="right">
						<table border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td align="left" valign="middle" class="menutext" nowrap><a
									href="javascript:send('password')">�p�X���[�h�ύX</a></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>