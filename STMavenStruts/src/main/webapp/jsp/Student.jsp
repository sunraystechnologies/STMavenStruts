<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sx:head />

<h1 align="center">Add Student</h1>

<font color="red"><s:actionerror /></font>
<font color="green"><s:actionmessage /></font>

<s:form action="s_Student">

	<s:hidden name="id"></s:hidden>

	<tr>
		<td><s:select list="collegeList" listKey="id" listValue="name"
				headerKey="0" headerValue="--Select--" name="collegeId"
				label="College Id*" /></td>
		<td><s:textfield name="firstName" label="First Name*"></s:textfield>
		<td><s:textfield name="lastName" label="Last Name*"></s:textfield></td>
		<td><sx:datetimepicker name="dob" label="DOB*"
				toggleType="explode" adjustWeeks="true" displayFormat="dd/MM/yyyy"></sx:datetimepicker></td>
		<td><s:textfield name="mobileNo" label="Mobile No*"></s:textfield></td>
		<td><s:textfield name="email" label="Email*"></s:textfield></td>

	</tr>

	<tr>

		<td><s:submit name="operation" value="Save" theme="simple"></s:submit></td>

		<s:if test="id!=null && id>0">
			<td><s:submit name="operation" value="Delete" theme="simple"></s:submit></td>
			<td><s:submit name="operation" value="Cancel" theme="simple"></s:submit></td>
		</s:if>

</s:form>