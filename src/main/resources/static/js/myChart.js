var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);


var arrayLength = chartJsonArray.length;

var numericData = [];
var labelData = [];

for(var i=0 ; i < arrayLength; i++)
{
    numericData[i] =chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
	
}

/* For a pie chart */
new Chart(document.getElementById("myPieChart"),{
    type: 'pie',
 /* The data for our dataset*/
    data:{
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#2E86C1", "#C0392B", "#239B56"],
            borderColor: 'rgb(255, 99, 132)',
            data: numericData
        }]
    },

    /* Configuration options go here*/
    options: {
    	title:{
    	display:true,
    	text:'Project Status'
        }
    }
});


/* return [{"label":"COMPLETED","value":1},{"label":"INPROGRESS","value":2},{"label":"NOTSTARTED","value":1}]*/
function decodeHtml(html) {
	var txt= document.createElement("textarea");
	txt.innerHTML=html;
	return txt.value;
}

