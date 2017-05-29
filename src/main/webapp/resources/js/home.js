/**
 * Created by Khanh Nguyen on 15/4/2017.
 */
$(function () {
    $('#select-date').datepicker({
    	startDate: '+1d',
    	endDate: '+7d'
    });

    $("#routeId").attr("value", $("#select-origin option:selected").attr("value"));
    $("#select-origin").on("change", function() {
        var optionSelected = $(this).find("option:selected");
        $("#routeId").attr("value", optionSelected.attr("value"));

    });

});