	var theDelim = "\r";
	var xsltNamespaceURI = "http://www.w3.org/1999/XSL/Transform";

	function addXSLTKey(Name, Match, Use, bModified)
	{
		if(!bModified) // Create a new xsl:key
		{
			var nodeKey = theStylesheet.createNode(1, "xsl:key",
								 xsltNamespaceURI);
			nodeKey.setAttribute("name", Name);
			nodeKey.setAttribute("match", Match);
			nodeKey.setAttribute("use", Use);
			
			nodeStylesheet.insertBefore(nodeKey, nodeStylesheetParam);	
		}
		else // Modify an existing xsl:key -- new values for @match, @use
		{
			modifyXSLTKey(Name, Name, Match, Use);
			var nodeKey = theStylesheet.selectSingleNode(
					"/xsl:stylesheet/xsl:key[@name='" + Name + "']");
			  nodeKey.setAttribute("match", Match);
			  nodeKey.setAttribute("use", Use);
		}
	}
	
	function modifyXSLTKey(Name, newName, newMatch, newUse)
	{
		var nodeKey = theStylesheet.selectSingleNode(
				"/xsl:stylesheet/xsl:key[@name='" + Name + "']");
			  nodeKey.setAttribute("name", newName);
			  nodeKey.setAttribute("match", newMatch);
			  nodeKey.setAttribute("use", newUse);
	}
	
	function deleteXSLTKey(varName)
	{
		var nodeKey = theStylesheet.selectSingleNode(
					"/xsl:stylesheet/xsl:key[@name='" + varName + "']");

		nodeKey = nodeStylesheet.removeChild(nodeKey);
		nodeKey = null;
	}
	
	function removeXSLTKeys(ExistingKeys)
	{
		var i = ExistingKeys.length - 1;
		
		while(i >= 0)
		{
			var varEntry = ExistingKeys[i];
			var idx   = varEntry.indexOf(theDelim);
			var name  = varEntry.substr(0, idx);

			deleteXSLTKey(name);
			i--;
		}
	}
	
	function restoreXSLTKeys(ExistingKeys)
	{
		var i = ExistingKeys.length - 1;
		
		while(i >= 0)
		{
			var varEntry = ExistingKeys[i];
			var arrCells = new Array(3);
			arrCells  = varEntry.split(theDelim);
			var name  = arrCells[0];
			var match = arrCells[1];
			var use   = arrCells[2];

			addXSLTKey(name, match, use, false);
			i--;
		}
}

