$(document).on("click", "[data-switch='relay']", function(){
			var relay = $(this).attr('id');
			var url = "/relay-handler";
			$(this).removeClass("btn-default");
			$(this).removeClass("btn-success");
			var data = [{name: "relay-id", value: relay}];
			$.post(url, data, function(response){
					$('#'+relay).addClass(response);
					$('#'+relay).blur();
			});
});