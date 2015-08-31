<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page session="false" %>
<html>
  <head>
    <title>${message}</title>
  </head>
  <body>
    <h1>${message}</h1>
    <f:form method="POST" action="addPerson">
    <table>
      <tbody>
        <tr>
          <td>Name:</td>
          <td><f:input path="name" size="30" /></td>
        </tr>
        <tr>
          <td>Surname:</td>
          <td><f:input path="surname" size="30" /></td>
        </tr>
        <tr>
          <td>Additional info:</td>
          <td><f:input path="additionalInfo" size="50" /></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Add Person"></td>
        </tr>
      </tbody>
    </table>
    </f:form>
  </body>
</html>