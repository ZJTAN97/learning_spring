<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
<title>Student Form</title>
</head>

<body>

<form:form action="process" modelAttribute="student">
	First name: <form:input path="firstName" />
	<br><br>
	Last name: <form:input path="lastName" />
	<br><br>
	
	Location:
	<form:select path="location">
		<form:options items="${student.locationOptions}" />
	</form:select>
	
	<br><br>
	
	Favourite Language:
	<form:radiobuttons path="favouriteLanguage" items="${student.languageOptions }"/>
	
	<br><br>
	
	Linux <form:checkbox path="operatingSystems" value="Linux" />
	Mac OS <form:checkbox path="operatingSystems" value="MacOS" />
	Windows <form:checkbox path="operatingSystems" value="Windows" />

	
	<br><br>
	
	<input type="submit" value="Submit" />
	
</form:form>


</body>

</html>