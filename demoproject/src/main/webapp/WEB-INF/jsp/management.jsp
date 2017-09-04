<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row">	
		<div class="col-md-offset-2 col-md-8">
		
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4> Add Article</h4>
				</div>
				
				<div class="panel-body">
					<!-- Form Element -->
					<sf:form class="form-horizontal" action="${contextRoot}/management" method="POST"
								modelAttribute="article">
						
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Article Title : </label>
							<div class="col-md-8">
								<sf:input type="text" path="articleTitle" placeholder="Article Name" class="form-control"/>
								<sf:errors path="articleTitle" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="article">Article : </label>
							<div class="col-md-8">
								<sf:textarea rows="4" cols="57" path="article" class="form-control" />
								<sf:errors path="article" cssClass="help-block" element="em"></sf:errors> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="topic">Select Topic : </label>
							<div class="col-md-8">
								<sf:select path="topic.topicId" class="form-control"
									items="${topics}"
									itemLabel="topicTitle"
									itemValue="topicId"
								/>
								<sf:errors path="topic" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" value="Submit" class="btn btn-primary"/>
							</div>
						</div>
					</sf:form>
				
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="row">	
		<div class="col-md-offset-2 col-md-8">
		
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4> Add Topic</h4>
				</div>
				
				<div class="panel-body">
					<!-- Form Element -->
					<sf:form class="form-horizontal" action="${contextRoot}/add/topic" method="POST"
								modelAttribute="topic">
						
						<div class="form-group">
							<label class="control-label col-md-4" for="topicTitle">Topic Title : </label>
							<div class="col-md-8">
								<sf:input type="text" path="topicTitle" placeholder="Topic Title" class="form-control"/>
								<sf:errors path="topicTitle" cssClass="help-block" element="em"></sf:errors>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="topicDesc">Topic Description : </label>
							<div class="col-md-8">
								<sf:textarea rows="4" cols="57" path="topicDesc" class="form-control" />
								<sf:errors path="topicDesc" cssClass="help-block" element="em"></sf:errors> 
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" value="Submit" class="btn btn-primary"/>
							</div>
						</div>
						
					</sf:form>
				
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	