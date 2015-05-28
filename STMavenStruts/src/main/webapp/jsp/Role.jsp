<%@ taglib prefix="s" uri="/struts-tags"%>
<h1 align="center">Add Role</h1>
<font color="red"><s:actionerror /></font>
<font color="green"><s:actionmessage /></font>

<s:form action="s_Role">

	<s:hidden name="id"></s:hidden>

	<tr>
		<td><s:textfield name="name" label="Name*"></s:textfield>
		<td><s:textarea rows="3" name="description" label="Description"></s:textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><s:submit name="operation" value="Save"
				theme="simple"></s:submit> <s:if test="id!=null && id>0">
				<s:submit name="operation" value="Delete" theme="simple"></s:submit>
			</s:if></td>
</s:form>