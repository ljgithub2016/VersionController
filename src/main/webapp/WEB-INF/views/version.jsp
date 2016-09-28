<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/version/save" modelAttribute="versionVo" method="post">
    	<div>
    		版本号:<form:input path="versionName" id="versionName" /><br/>
    		作者:<form:input path="author" id="author" /><br/>
    		创建时间:<form:input path="createDate" id="createDate" /><br/>
    		验收时间:<form:input path="testDate" id="testDate" /><br/>
    		上线时间:<form:input path="workDate" id="workDate" /><br/>
    		数据库脚本:<form:textarea rows="20" cols="50" path="dbInfo" id="dbInfo" ></form:textarea> <br/>
    		菜单脚本:<form:textarea rows="20" cols="50" path="menuInfo" id="menuInfo" ></form:textarea> <br/>
    		<input type="submit" value="提交"/>
    		
    	</div>
    </form:form>
</body>
</html>