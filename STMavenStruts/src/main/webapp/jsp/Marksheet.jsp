<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<H1>Marksheet</H1>

	<font color="red"><s:actionerror /></font>
	<font color="green"><s:actionmessage /></font>

	<s:form action="Marksheet">

		<s:hidden name="id" />
		<s:textfield name="rollNo" label="Roll Number*" />
		<s:textfield name="studentId" label="Student Id*" />
		<s:textfield name="name" label="Name*" />
		<s:textfield name="physics" label="Physics" />
		<s:textfield name="chemistry" label="Chemistry" />
		<s:textfield name="maths" label="Maths" />

		<s:submit name="operation" value="Save"></s:submit>
		<s:submit name="operation" value="Delete"></s:submit>

	</s:form>
</body>
</html>
