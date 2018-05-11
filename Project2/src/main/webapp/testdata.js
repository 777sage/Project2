        let tableBody2 = document.getElementById('test-body');
        function getAllTests(){
        	console.log("getting All Tests");
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
        					row.appendChild(quester);
        					
        					let questDate = document.createElement('td');
        					questDate.innerHTML=request.time;
        					row.appendChild(questDate);
        			        
        			        tableBody2.appendChild(row);
        				});
        		}
        	}
        }