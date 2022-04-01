	// Courtesy of SimplytheBest.net (http://simplythebest.net)
	var rowHighlight = true; // turn on row highlights
	var colHighlight = true; // turn on row highlights
	var selectedRow = null;
	
	function getElement(el)
	{
	    var tagList = new Object;
	    
		for (var i = 1; i < arguments.length; i++)
	      tagList[arguments[i]] = true;
	    
		while ((el!=null) && (tagList[el.tagName]==null))
	      el = el.parentElement;
	    
		return el;
	}
	
	function checkSelected()
	{
		var el = getElement(event.srcElement,"TD");
		//alert(el)
		if (el==null) 
			return;
		
		//alert(el.tagName)
		if (el.tagName=="TD")
		{
			var row = getElement(el, "TR"); 
			var table = getElement(row, "TABLE");
			
			row.className = "select";
			if(selectedRow != null)
				selectedRow.className = "";
			
			row.className = "select";
			selectedRow = row;

			
			cache = row;
		} 

	}
	
	function checkHighlight(which) 
	{
		var el = getElement(event.srcElement,"TH","TD");
		
		if (el==null) 
			return;
		if ((el.tagName=="TH") && (colHighlight)) 
		{
			var idx = el.cellIndex;
			var table = getElement(el, "TABLE");
			var column = table.all.tags("COL")[idx];
			
			if (which)
				column.className="cover";
			else
				column.className="";
		}      
		
		if ((el.tagName=="TD") && (rowHighlight)) 
		{
			var row = getElement(el, "TR"); 
			var table = getElement(row, "TABLE");
			
			if (which) 
				row.className = "rover";
			else
			{
				row.className = ""	
				if(row == selectedRow)
					row.className = "select"	
			}

			
			cache = row;
		}
	}
	