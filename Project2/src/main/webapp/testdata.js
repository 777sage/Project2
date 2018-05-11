        let tableBody2 = document.getElementById('test-body');
        let success=0;
        let fail=0;
        function getAllTests(){
        	console.log("getting All Tests");
        	success=0;
        	fail=0;
        	while (tableBody2.firstChild) {
        	    tableBody2.removeChild(tableBody2.firstChild);
        	}
        	requestsTable = document.getElementById('test-table');
        		let xhr = new XMLHttpRequest();
        		xhr.open('POST', 'getAllTests.do');
        		xhr.send();
        		xhr.onreadystatechange=()=>{
        			if(xhr.readyState===4&&xhr.status===200){
        				console.log("Response test"+ xhr.responseText);
        				let requests = JSON.parse(xhr.responseText);
        				requests.forEach(request=>{
        					let row =document.createElement('tr');
        					
        					let idCell = document.createElement('td');
        					idCell.innerHTML=request.tid;
        					row.appendChild(idCell);
        					
        					let amm = document.createElement('td');
        					amm.innerHTML=request.testName;
        					row.appendChild(amm);
        					
        					let quester = document.createElement('td');
        					quester.innerHTML=request.status;
        					if(request.status=="Success"){
        						success+=1;
        					}
        					else{
        						fail+=1;
        					}
        					row.appendChild(quester);
        					
        					let questDate = document.createElement('td');
        					questDate.innerHTML=request.timestamp;
        					row.appendChild(questDate);
        			        
        			        tableBody2.appendChild(row);
        				});
        				
        				 // Load google charts
        		        google.charts.load('current', {'packages':['corechart']});
        		        google.charts.setOnLoadCallback(drawChart);

        		        // Draw the chart and set the chart values
        		        function drawChart() {
        		          var data = google.visualization.arrayToDataTable([
        		          ['Tests', 'Tests'],
        		          ['Success', success],
        		          ['Failed', fail]
        		        ]);

        		          // Optional; add a title and set the width and height of the chart
        		          var options = {'title':'Test Results', 'width':550, 'height':400, colors:['#33cc33','#ff0000']};

        		          // Display the chart inside the <div> element with id="piechart"
        		          var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        		          chart.draw(data, options);
        		        }
        		}
        	}
        }
        