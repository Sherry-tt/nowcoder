$(function(){
	$("#publishBtn").click(publish);
});

function publish() {
	$("#publishModal").modal("hide");

	// Get title and content
	var title = $("#recipient-name").val();
	var content = $("#message-text").val();
	// Send an asynchronous request (POST)
	$.post(
		CONTEXT_PATH + "/discuss/add",
		{"title":title,"content":content},
		function(data) {
			data = $.parseJSON(data);
			$("#hintBody").text(data.msg);  // Show return message in tooltip
			$("#hintModal").modal("show");  // show tooltip
			setTimeout(function(){       // After 2 seconds, automatically hide the prompt box
				$("#hintModal").modal("hide");
				// refresh the page
				if(data.code == 0) {
					window.location.reload();
				}
			}, 2000);
		}
	);
}