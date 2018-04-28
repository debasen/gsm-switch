$(document).on("change", "#power-btn", function(event) {
	event.preventDefault();
	var relay = $('#power-btn').prop('checked');
	$('#power-btn').bootstrapToggle('disable');
	var url = "/operate-relay";

	var data = [ {
		name : "relayState",
		value : relay
	} ];
	$.post(url, data, function(response) {
		var relayStatus = response.relayStatus;
		var relayColor = response.buttonColor;
		$('#power-btn').bootstrapToggle('destroy');
		if (relayStatus == true) {
			$('#power-btn').bootstrapToggle({
				onstyle : relayColor,
				offstyle : 'info'
			});
		} else {
			$('#power-btn').bootstrapToggle({
				onstyle : 'info',
				offstyle : relayColor
			});
		}
		$('#power-btn').bootstrapToggle('enable');
	});
});

$(document).ready(function() {
	var relayColor = $('#relay-color-tag').text();
	var relayStatus = $('#relay-status-tag').text();
	if (relayStatus == 'true') {
		$('#power-btn').bootstrapToggle({
			onstyle : relayColor,
			offstyle : 'info'
		});
	} else {
		$('#power-btn').bootstrapToggle({
			onstyle : 'info',
			offstyle : relayColor,
		});
	}
});

$(document).ready(function pollServer() {
	$.get('/poll-server', function(response) {
		var relayStatus = response.relay;
		var relayColor = response.relayColor;
		$('#power-btn').bootstrapToggle('destroy');
		if (relayStatus == true) {
			$('#power-btn').bootstrapToggle({
				onstyle : relayColor,
				offstyle : 'info'
			});
		} else {
			$('#power-btn').bootstrapToggle({
				onstyle : 'info',
				offstyle : relayColor
			});
		}
		setTimeout(pollServer, 5000);
	});
});

$(document).on('click', '.history-panel-heading', function() {
	$('.history-panel-body').slideToggle('fast',function() {
		if ($(".history-panel-body").is(":visible")) {
			$('.history-collapse-btn').removeClass('glyphicon-plus');
			$('.history-collapse-btn').addClass('glyphicon-minus');
		} else {
			$('.history-collapse-btn').removeClass('glyphicon-minus');
			$('.history-collapse-btn').addClass('glyphicon-plus');
		}
	});
});

$(document).ready(function() {
	$('.history-panel-body').hide();
});