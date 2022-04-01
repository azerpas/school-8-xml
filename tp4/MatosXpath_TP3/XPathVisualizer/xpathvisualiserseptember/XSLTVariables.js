	var theDelim = "\r";
	var xsltNamespaceURI = "http://www.w3.org/1999/XSL/Transform";
	
	function addXSLTVariable(varName, expression, bModified)
	{
		if(!bModified) // Create a new xsl:variable
		{
			var nodeVariable = theStylesheet.createNode(1, "xsl:variable",
								 xsltNamespaceURI);
			nodeVariable.setAttribute("name", varName);
			nodeVariable.setAttribute("select", expression);
			
			nodeStylesheet.insertBefore(nodeVariable, nodeStylesheetParam);	
		}
		else // Modify an existing xsl:variable -- a new value for @select
		{
			var nodeVariable = theStylesheet.selectSingleNode(
					"/xsl:stylesheet/xsl:variable[@name='" + varName + "']");
			  nodeVariable.setAttribute("select", expression);
		}
	}
	
	function modifyXSLTVariable(varName, newName, newValue)
	{
		var nodeVariable = theStylesheet.selectSingleNode(
				"/xsl:stylesheet/xsl:variable[@name='" + varName + "']");
		  nodeVariable.setAttribute("name", newName);
		  nodeVariable.setAttribute("select", newValue);
	}
	
	function deleteXSLTVariable(varName)
	{
		var nodeVariable = theStylesheet.selectSingleNode(
					"/xsl:stylesheet/xsl:variable[@name='" + varName + "']");

		nodeVariable = nodeStylesheet.removeChild(nodeVariable);
		nodeVariable = null;
	}
	
	function removeXSLTVariables(ExistingVariables)
	{
		var i = ExistingVariables.length - 1;
		
		while(i >= 0)
		{
			var varEntry = ExistingVariables[i];
			var idx   = varEntry.indexOf(theDelim);
			var name  = varEntry.substr(0, idx);

			deleteXSLTVariable(name);
			i--;
		}
	}
	
	function restoreXSLTVariables(ExistingVariables)
	{
		var i = ExistingVariables.length - 1;
		
		while(i >= 0)
		{
			var varEntry = ExistingVariables[i];
			var idx   = varEntry.indexOf(theDelim);
			var name  = varEntry.substr(0, idx);
			var value = varEntry.substr(idx + 1);

			addXSLTVariable(name, value, false);
			i--;
		}
}

