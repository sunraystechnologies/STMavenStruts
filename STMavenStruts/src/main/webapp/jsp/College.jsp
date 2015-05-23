<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>

	Language
	<a href="College.action?request_locale=en">English</a> |
	<a href="College.action?request_locale=hi">Hindi</a>

	<H1>
		<s:text name="college.title" />
	</H1>

	<font color="red"><s:actionerror /></font>
	<font color="green"><s:actionmessage /></font>

	<s:form action="College">

		<s:hidden name="id" />

		<s:textfield name="name" key="label.name" />
		<s:textfield name="address" key="label.address" />
		<s:textfield name="phoneNo" key="label.phone" />
		<s:textfield name="city" key="label.city" />
		<s:textfield name="state" key="label.state" />

		<s:submit name="operation" value="Save" />

	</s:form>
</body>
</html>
