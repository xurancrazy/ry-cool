<%@ tag import="com.ry.cool.common.utils.PrettyTimeUtils" %>
<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="date" type="java.util.Date" required="true" description="时间" %>
<%=PrettyTimeUtils.prettyTime(date)%>