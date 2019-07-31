<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="WebUtil.UIConstants" %>
<%@page import="java.util.*" %>

<html>
    <head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Emily's Classes</title>
		
		<link rel="stylesheet" href="style.css" >
		
		<script type="text/javascript" >
			function checkErrors() {
				var errorField = document.getElementById('error');
				var errors = '<%=request.getAttribute(UIConstants.ERROR_LIST)%>';
				if (errors != 'null') {
					errorField.textContent = errors;
					errorField.className = 'visible';
				}
			}
		</script>
		
    </head>

    <body>
        <form action="LoginServlet" method="post">
		
        <h1>Welcome to Emily's Classes</h1>

        <table align="center" >
                <tr>
                        <td>
                                <p>User: </p>
                        </td>
                        <td>
                                <input name="<%=UIConstants.USUARIO%>" value="" />
                        </td>
                </tr>
                <tr>
                        <td>
                                <p>Password: </p>
                        </td>
                        <td>
                                <input name="<%=UIConstants.PASSWORD%>" type="password" value="" />
                        </td>
                </tr>
        </table>

        <div class="error" >
                <%	List<String> errores = (List<String>) request.getAttribute(UIConstants.ERROR_LIST);
                        int i = 0;
                        if (errores != null && errores.size() > 0) {
                                for (String error : errores) { %>
                                        <p id="error<%= i %>"><%= error %></p>
                <%			i++;
                                }
                        } %>
        </div>

        <input type="submit" value="Submit">

        </form>
    </body>
</html>
