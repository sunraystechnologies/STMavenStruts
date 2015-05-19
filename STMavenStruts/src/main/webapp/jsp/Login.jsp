<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<body>

	<H1>Login</H1>

	<H2 style="color: red">
		<s:property value="error" />
	</H2>

	<s:form action="Login">
		<s:textfield name="userId" label="User Name" />
		<s:password name="password" label="Password" />
		<s:submit name="operation" value="Go"></s:submit>
	</s:form>
	
	<h4>Test login/password: admin/admin</h4>

</body>
</html>
