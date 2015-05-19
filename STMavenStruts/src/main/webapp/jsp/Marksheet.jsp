<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<H1>Marksheet</H1>
	<s:form action="Marksheet">
		<s:property value="errorMessage" />
		<s:textfield name="rollNo" label="Roll Numbere" />
		<s:textfield name="name" label="Name" />
		<s:textfield name="maths" label="Maths" />
		<s:textfield name="physics" label="Physics" />
		<s:textfield name="chemistry" label="Chemistry" />
		<s:submit name="operation" value="Add"></s:submit>
		<s:submit name="operation" value="Update"></s:submit>
		<s:submit name="operation" value="Delete"></s:submit>

	</s:form>
</body>
</html>
