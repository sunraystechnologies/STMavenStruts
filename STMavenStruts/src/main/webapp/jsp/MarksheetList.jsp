<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Marksheet List</h1>

<s:form action="MarksheetList">

	<table width="100%">
		<tr>
			<td align="center">Name : <s:textfield name="name" label="Name"
					theme="simple"></s:textfield> <s:submit name="operation"
					value="Search" theme="simple"></s:submit></td>
		</tr>
	</table>
	<BR>
	<table border="1" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<th>Select</th>
			<th>Seq No</th>
			<th>RollNo</th>
			<th>Name</th>
			<th>Physics</th>
			<th>Chemistry</th>
			<th>Maths</th>
			<th>Edit</th>
		</tr>
		<s:if test="hasActionErrors()">
			<tr>
				<td colspan="5"><font color="red"><s:actionerror
							theme="simple" /></font></td>
			</tr>
		</s:if>
		<s:iterator value="list" status="status" var='%{0,1}'>
			<tr>
				<td><input type="checkbox" name="ids"
					value='<s:property value="id"/>'></td>
				<td><s:property value='%{#status.count}' /></td>
				<td><s:property value="rollNo" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="physics" /></td>
				<td><s:property value="chemistry" /></td>
				<td><s:property value="maths" /></td>
				<td><a
					href='app/Marksheet!input.action?id=<s:property value="id" />'>Edit</a></td>
			</tr>
		</s:iterator>
		<tr>
			<s:hidden name="pageNo"></s:hidden>
			<s:hidden name="pageSize"></s:hidden>
			<td><s:submit name="operation" value="Previous" theme="simple" /></td>
			<td colspan="6" align="center"><s:submit name="operation"
					value="Delete" theme="simple" /></td>
			<td align="right"><s:submit name="operation" value="Next"
					theme="simple" /></td>
		</tr>
	</table>
</s:form>