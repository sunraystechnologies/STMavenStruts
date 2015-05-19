<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<body>

	<H1>Person</H1>

	<s:form action="Person" method="post">
		<s:textfield label="Name" name="name" />
		<s:textfield label="Age" name="age" />
		<s:textfield label="Favorite color" name="answer" />
		<s:submit />
	</s:form>


</body>
</html>
