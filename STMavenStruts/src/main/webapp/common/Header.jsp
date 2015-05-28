<%@ taglib uri="/struts-tags" prefix="s"%>

<h1 style="text-align: center;">
    Online Result System <span style="float: right;"> 
    <img src="/STMavenStruts/img/customLogo.jpg" align="right" /></span>
</h1>

<s:if test="#session.user != null">

    <h3>Welcome: <s:property value="#session.user"/> </h3>
  
    <a href="/STMavenStruts/tiles/d_Role.action">Add Role</a> | 
    <a href="/STMavenStruts/tiles/d_RoleList.action">Role List</a> | 
    <a href="/STMavenStruts/Login!input.action">Logout</a>

</s:if>

<s:else>
    <a href="/STMavenStruts">Home</a>&emsp;
    <a href="/STMavenStruts/Login!input.action">Login</a>
</s:else>