<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="row" class="marginTop20PX">	
	<div class="col-md-offset-2 col-md-8">
	
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4> Add Notification</h4>
			</div>
			
			<div class="panel-body">
				<div class="form-horizontal" >
					
					<div class="form-group">
						<div class="col-md-10 email-register">
							<input type="text" name="email" value="${defaultEmail}" class="form-control default-email"/>
						</div>
						<div class="col-md-2">
							<input type="submit" name="submit" value="Submit" class="btn btn-primary" onclick ="defaultEmailRegisterForTopic()"/>
						</div>
					</div>
					
					<c:forEach items="${topics}" var="topic" varStatus="status">
						<div class="form-group">
							<label class="control-label col-md-3" for="topicTitle">${topic.topicTitle}</label>
							<div class="col-md-6 email-register">
								<input type="text" name="email" placeholder="Enter Email" class="form-control email"/>
								<input type="hidden" value="${topic.topicId}" class="topicId">
							</div>
						</div>
					</c:forEach>
					
					<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
							<input type="submit" name="submit" value="Submit" class="btn btn-primary" onclick ="emailRegisterForTopic()"/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>









<%-- 	<sf:form class="form-horizontal" action="${contextRoot}/notification" method="POST"  --%>
<%-- 						modelAttribute="emails" > --%>
<%-- 					<c:forEach items="${topics}" var="topic" varStatus="status"> --%>
<!-- 						<div class="form-group"> -->
<%-- 							<label class="control-label col-md-3" for="topicTitle">${topic.topicTitle}</label> --%>
<!-- 							<div class="col-md-6"> -->
<!-- 								<input type="text" name="email" placeholder="Enter Email" class="form-control"/> -->
<!-- 							</div> -->
<!-- 						</div> -->
<%-- 					</c:forEach> --%>
					
					
<!-- 					<div class="form-group"> -->
<!-- 						<div class="col-md-offset-4 col-md-8"> -->
<!-- 							<input type="submit" name="submit" value="Submit" class="btn btn-primary"/> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<%-- 				</sf:form> --%>