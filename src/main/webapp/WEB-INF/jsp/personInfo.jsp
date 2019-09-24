<%@page language="java" contentType="text/html;charset=utf-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE> 
<html>
<head>  
<meta charset="utf-8">
</head>  
<script>

</script>
<body>
${user.id} 
<table>
	<thead>
		<tr>
			<th>usercode</th>
			<th>password</th> 
			<th>roleId</th>
			<th>operate</th> 
		</tr>
	</thead>
	<tbody>
		 
		<c:forEach items="${users}" var="u">
			<tr>
				<th>${u.usercode}</th>
				<th>${u.password}</th>
				<th>${u.roleId}</th> 
				<th>
					<a href="http://localhost:8080/ssm/userResourse/delete.action?id=${u.id}">删除</a>
					<a href="">更改</a> 
				</th>

			</tr>
		</c:forEach>
	</tbody>

</table>
</body>

</html>