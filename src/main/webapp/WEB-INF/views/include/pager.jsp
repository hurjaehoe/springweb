<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<div class="box-footer">
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				<li><a
					href="listPage${pageMaker.makeQuery( pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li
					<c:out value="${pageMaker.pageCriteriaVO.page == idx?'class=active':'' }"/>>
					<a href="listPage${pageMaker.makeQuery( idx )}">${idx }</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
				<li><a
					href="listPage${pageMaker.makeQuery(pageMaker.endPage + 1 )}">&raquo;</a>
				</li>
			</c:if>
		</ul>
	</div>
</div>
<!-- /.box-footer-->