$(document).on("blur", "#emailId", function() {
	var emailIdValue = $(this).val();
	url = "/check-for-existing-email";
	data = {
		emailId : emailIdValue
	};
	$.post(url, data, function(response) {
		if (response == "EMAIL_EXISTS") {
			$("#emailId").closest("div.form-group").addClass("has-error");
			$("#emailId").siblings("span.help-block").show();
		} else {
			$("#emailId").closest("div.form-group").removeClass("has-error");
			$("#emailId").siblings("span.help-block").hide();
		}
	});
});

$(document).on("keyup", "#userName", function() {
	var userNameValue = $("#userName").val();
	url = "/check-for-existing-userName";
	data = {
		userName : userNameValue
	};
	$(".user-name-spinner-icon").show();
	$.post(url, data, function(response) {
		if (response == "USER_NAME_EXISTS") {
			$("#userName").closest("div.form-group").addClass("has-error");
			$("#userName").closest("div.form-group").find("span.help-block").show();
		} else {
			$("#userName").closest("div.form-group").removeClass("has-error");
			$("#userName").closest("div.form-group").find("span.help-block").hide();
		}
		$(".user-name-spinner-icon").hide();
	});
});

$document.ready(function(){$('[data-toggle="tooltip"]').tooltip()});

$(document).on("blur","#firstName",function(){
	var text = $(this).val();
	var isInvalid = text.match([a-zA-Z]);
	if(isInvalid){
		
	}
});