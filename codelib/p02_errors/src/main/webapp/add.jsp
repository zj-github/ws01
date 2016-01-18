<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="errors">
		语言： <select><option>java</option>
			<option>python</option>
			<option>c++</option>
			<option>php</option>
			<option>sql</option>
		</select> 操作系统：<select><option>windows 7</option>
			<option>windows10</option>
			<option>windows8</option>
			<option>redhat5</option>
			<option>ubantu</option>
			<option>mac</option>
		</select> 开发工具:<select><option>eclipse</option>
			<option>netbean</option>
			<option>idea</option>
		</select> 报错软件:<select><option>spring</option>
			<option>ant</option>
			<option>maven</option>
		</select> 相关软件:<select><option></option>
			<option>netbean</option>
			<option>idea</option>
		</select> <br /> <br /> 错误信息：
		<textarea cols="100" rows="20"></textarea>
		<input type="submit">
	</form>
</body>
</html>