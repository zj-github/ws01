<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!-- 显示分页操作链接：开始 -->
    	第${page.pageNum}页/共${page.totalPage}页&nbsp;&nbsp;
    	<a href="${pageContext.request.contextPath}${page.url}&pageNum=${page.pageNum-1<1?1:page.pageNum-1}">上一页</a>&nbsp;&nbsp;
    	
    	<c:forEach begin="${page.startPageNum }" end="${page.endPageNum }" var="num">
    		<a href="${pageContext.request.contextPath}${page.url}&pageNum=${num}">${num }</a>
    	</c:forEach>
    	<a href="${pageContext.request.contextPath}${page.url}&pageNum=${page.pageNum+1>page.totalPage?page.totalPage:page.pageNum+1}">下一页</a>
    	
    	<select id="s1" name="num" onchange="jump(this)">
    		<c:forEach begin="1" end="${page.totalPage}" var="num">
    			<option value="${num}" ${page.pageNum==num?'selected="selected"':'' } >${num}</option>
    		</c:forEach>
    	</select>
    	<script type="text/javascript">
    		function jump(selectObj){
    			//alert(selectObj.value);
    			window.location.href="${pageContext.request.contextPath}${page.url}&pageNum="+selectObj.value;
    		}
    	</script>
    	<!-- 显示分页操作链接：结束 -->