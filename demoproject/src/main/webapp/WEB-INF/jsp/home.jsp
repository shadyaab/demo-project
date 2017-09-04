<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="marginTop20PX">
	<ul>
		<c:forEach items="${topics}" var="topic">
			<li><b>${topic.topicTitle}</b>
				<ul>
										<c:forEach var="j" begin="1" end="3">
											<li>SubTopic</li>
										</c:forEach>
					
<%-- 					<C:FOREACH ITEMS="${TOPIC.LISTARTICLE}" VAR="ITEM"> --%>
<%-- 						<LI>${ITEM.ARTICLETITLE}</LI> --%>
<!-- 					</C:FOREACH> -->
				</ul></li>
		</c:forEach>
	</ul>
</div>