
console.log(window.contextRoot);
var emailRegisterForTopic = function(){
	
	var emails = [];
	$('.email-register').each(function(index, element){
		var email = $(this).find('.email').val();
		var topicId = $(this).find('.topicId').val();
		var temp = {};
		temp.email = email;
		temp.topic = {};
		temp.topic.topicId = topicId;
		
		emails.push(temp);
	});
	
	$.ajax({
		url: window.contextRoot + "/notification",
		type: "POST",
	    contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(emails),
		success: function(result){
			console.log(result);
			$('.email').val('');
			alert('Email is registerd successfully');
			
		}
	});
}

var defaultEmailRegisterForTopic = function(){
	var defaultEmails =$('.default-email').val();
	defaultEmails = defaultEmails.split(';');
	
	$.ajax({
		url : window.contextRoot + "/defaultEmailRegister",
		type: "POST",
		contentType : "application/json",
		data: JSON.stringify(defaultEmails),
		success: function(result){
			console.log(result);
			alert('Default mail is registerd successfully');
		}	
	});
}
















