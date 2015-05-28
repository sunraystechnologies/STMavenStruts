<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<title><tiles:getAsString name="title" /></title>

<style type="text/css">
.errorMessage {
    color: red;
    font-size: 16px;
}
</style>
</head>

<body>
    <table border="1" width="100%">
        <tr>
            <td align="center" colspan="2"><tiles:insertAttribute
                    name="header" /></td>
        </tr>
        <tr>
            <td height="400" valign="top" align="center"><tiles:insertAttribute
                    name="body" /></td>
        </tr>
        <tr>
            <td align="center" colspan="2"><tiles:insertAttribute
                    name="footer" /></td>
        </tr>
    </table>
</body>
</html>