function currencyChangefunction() {
	var currency_type = document.getElementById("currencychange").value;
	if (currency_type == ""){
		alert("please select Currency type");
		return;
	}
	var v_type = document.getElementById("v_type").value;
	var table = document.getElementById("price_list");
	if( v_type == "CYCLE"){
		if(currency_type == "INR"){
			table.rows[1].cells[1].innerHTML="5";
			table.rows[2].cells[1].innerHTML="100";
			table.rows[3].cells[1].innerHTML="500";
		}
		else if(currency_type == "USD"){
			table.rows[1].cells[1].innerHTML="$0.6";
			table.rows[2].cells[1].innerHTML="$1.38";
			table.rows[3].cells[1].innerHTML="$6.94";
		}
		else if(currency_type == "YEN"){
			table.rows[1].cells[1].innerHTML="7.39 YEN";
			table.rows[2].cells[1].innerHTML="147.83 YEN";
			table.rows[3].cells[1].innerHTML="739.17 YEN";
		}
	}
	else if( v_type == "MOTOR CYCLE"){
		if(currency_type == "INR"){
			table.rows[1].cells[1].innerHTML="10";
			table.rows[2].cells[1].innerHTML="200";
			table.rows[3].cells[1].innerHTML="1000";
		}
		else if(currency_type == "USD"){
			table.rows[1].cells[1].innerHTML="$0.13";
			table.rows[2].cells[1].innerHTML="$2.77";
			table.rows[3].cells[1].innerHTML="$13.88";
		}
		else if(currency_type == "YEN"){
			table.rows[1].cells[1].innerHTML="14.78 YEN";
			table.rows[2].cells[1].innerHTML="295.67 YEN";
			table.rows[3].cells[1].innerHTML="1478.33 YEN";
		}
	
	}
	else if( v_type == "FOUR WHEELER"){
		if(currency_type == "INR"){
			table.rows[1].cells[1].innerHTML="20";
			table.rows[2].cells[1].innerHTML="500";
			table.rows[3].cells[1].innerHTML="3500";
		}
		else if(currency_type == "USD"){
			table.rows[1].cells[1].innerHTML="$0.277";
			table.rows[2].cells[1].innerHTML="$6.94";
			table.rows[3].cells[1].innerHTML="$48.61";
		}
		else if(currency_type == "YEN"){
			table.rows[1].cells[1].innerHTML="29.57 YEN";
			table.rows[2].cells[1].innerHTML="739.17 YEN";
			table.rows[3].cells[1].innerHTML="5174.16 YEN";
		}
	
	}
} 