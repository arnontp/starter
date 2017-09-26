$(document).ready(function() {
	changePageAndSize();
	
	 $('.datetimepicker').datetimepicker({
		 format: 'DD-MM-YYYY' 
	 });
});

function changePageAndSize() {
	$('#pageSizeSelect').change(function(evt) {
		var getUrl = window.location;
		var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];	 
		window.location.replace(baseUrl+"/?pageSize=" + this.value + "&page=1");
	});
}
