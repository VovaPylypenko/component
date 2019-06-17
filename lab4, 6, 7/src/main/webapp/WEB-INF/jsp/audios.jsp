
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:base>
    <div class="jumbotron" align="center">
        <c:if test="${audios.haveAudios()}">
            <table>
                <tr>
                    <th align="center">№</th>
                    <th>  </th>
                    <th align="center">Name</th>
                    <th>  </th>
                    <th align="center">Audio</th>
                    <th>  </th>
                    <th align="center">Size</th>
                    <th>    </th>
                </tr>
                <c:forEach var="i" begin="0" end="${audios.audios.size()-1}">
                    <tr>
                        <form:form method="post" action="/delete" modelAttribute="audioForDel">
                            <td align="center">${i + 1}</td>
                            <td>  </td>
                            <td>${audios.audios.get(i).name}</td>
                            <td>  </td>
                            <td>${audios.audios.get(i).audio}</td>
                            <td>  </td>
                            <td>${audios.audios.get(i).audio.length() * 4}</td>
                            <td>  </td>
                            <td>
                                <form:input type="hidden" path="audioID" value="${i}" />
                                <button type="submit" class="btn-danger">DELETE</button>
                            </td>
                        </form:form>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${audios.emptyAudios()}">
            <h3>You do not have any audios.</h3>
        </c:if>
    </div>
</t:base>
