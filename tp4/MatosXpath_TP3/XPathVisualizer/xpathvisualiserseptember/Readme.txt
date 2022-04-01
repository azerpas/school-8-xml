<!--    XPath Visualiser,
	 by Dimitre Novatchev, Apr. 2000.
	 mailto:dnovatchev@yahoo.com

This is a full blown Visual XPath Interpreter for the evaluation of any XPath expression
and visual presentation of the resulting nodeset or scalar value.

The XPath Visualiser's value as an XSLT and XPath learning and authoring tool 
results from its ability to present the results of any XPath expression in an
immediate, appealing and straightforward visualization. It allows the user to
define their own dynamic xsl:variable and xsl:key elements and to use variable 
references and the key() functions in their XPath expressions. 

The Xpath Visualiser remembers and makes available to manage and reuse 
any previously entered expression, variable or key definition.

The source XML Document is displayed with any node hi-lighted that satisfies the
XPath expression. 

In case the expression evaluates to a scalar (string | number | boolean) 
then it is displayed in a separate window.

The expandable/collapsible syntax colour-coded display of the source
XML Document is the same as done by default by Internet Explorer.

The latest version of the XPath Visualiser is 1.4 (13 June, 2001).

This tool will best be used for:
-------------------------------
1. Composing the exact XPath expression when designing an XSLT stylesheet. 
2. As a "nodeset view" in a watch window of an XSLT debugger.
3. Conveniently obtaining subsets of elements by defining and referencing xsl:variables
   and xsl:keys.
4. Obtaining any quantitative measures of the xml source 
   by evaluating expressions that return a scalar.
5. Learning and playing with XPath expressions. 
6. Learning and playing with xsl:variables and xsl:keys.
7. As a good example how to process completely un-anticipated XML documents
   using "push processing".

Files in this distribution (XPathVisualiser Ver. 1.3):
----------------------------------------------------
     129 arrow_beg.gif
     126 arrow_end.gif
     889 arrow_end_dis.gif
      92 arrow_next.gif
     868 arrow_next_dis.gif
      92 arrow_prev.gif
     796 authors.xml
     691 authors2.xml
   2,256 back42.jpg
     873 combo.jpg
     714 DocWithDTD.xml
     727 DocWithDTD2.xml
     745 DocWithDTD3.xml
     490 DocWithDTD4.xml
     155 DocWithDTD5.xml
     944 expressions.htm
     151 KeyOrVar.css
   7,667 keys.htm
  23,503 myDefaultss80.xsl
   2,840 newKey.htm
   2,781 newVariable.htm
  11,549 Readme.txt
     381 table.css
   1,632 table.js
   1,075 testPad.xsl
   1,053 testPad1.xsl
   7,077 topFrame.htm
   7,333 variables.htm
     102 viewFrame.htm
   9,825 XPathMain.htm
   1,965 XSLTKeys.js
   1,936 XSLTVariables.js
   
To start the XPath Visualiser:
-----------------------------
1. Unzip the distribution file you downloaded (XPathVisualiserSeptember.zip
   or the XPathVisualiser.zip file) in a separate directory.
2. Double-click on XPathMain.htm


This is a customisation of the original DEFAULTSS.XSL 
written by Johnatan Marsh. 
The changes that had to be made are listed below:
------------------------------------------------

1. The original stylesheet was modified to work 
with the XSLT default namespace uri: 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform".

2. The modifications above include a completely new way
of detecting namespace node definitions - something that
was not provided by the old DEFAULTSS.XSL and is in fact 
considered impossile (see Mike Kay's book, page 60).
In fact this still doesn't mean Mike's wrong - note the
critical importance of using the vxpathuser:xml() xtn f-n.

3. A global parameter named "selectedNodes" was added.

4. Additional logic was added to all templates 
to recognise whether the current match belongs to
the $selectedNodes nodeset.

5. All nodes that belong to the $selectedNodes nodeset 
are treated in a special way - hi-lighted.

6. All container nodes that are collapsed and hide selections
are also specially hi-lighted. Thus it is possile to have a minimum
length display of the xml source that still shows all selected nodes.

Requirements:
------------
1. The Standard MSXML 3, or at least the Septemer Beta Release
2. MS Internet Explorer 5 or later.

If you have a previous release of MSXML installed, download the file XPathVisualiser.zip

Known issues:
------------
1. This tool will not display selected nodes that were not explicitly
specified in the text of the xml source document. Most notably this is
true for (propagated) namespace nodes and for default/implied attributes
that were specified in a DTD and not explicitly specified in the text
of the source document.
However, the containing nodes are still hi-lighted to indicate the presence
of such selected and not specified in the text nodes.

Also, you can still get any available data about such nodes,
by using scalar expressions. For example:

string(//namespace::*[contains(.,"3")][1]) 

returns:

"http://www.w3.org/XML/1998/namespace"

although this is the value of the (hidden) default namespace node.

Just changing the above expression (if you have loaded the authors.xml file 
provided with this distribution) to:

string(//namespace::*[contains(.,"3")][2])

will return:

"mynamespace3"

2.A bug in all MSXML processors before September 2000 sometimes
prevents the correct finding and hilighting of nodes that are 
specified by the XPath expression.

What happens is that sometimes, according to MSXML 
count(nodeset | member-node) != count(nodeset)

I have reported this bug to Microsoft twice (every month since June)
and it was fixed in their September Beta Release.

Plans for the future:
--------------------
1. Turn the XPath Visualiser into a full-blown Visual XPath Interpreter -- done (28 Oct. 2000)!
2. Provide a remote, web-server based XPath Visualiser.
3. Change the user interface into Netscape-compatible.
4. Integrate the XPath Visualiser into an existing editor/debugger 
(hopefully Corey Haines and Chris Stefano will be interested... :o))) )
 -->

Here are the title comments of Johnatan Marsh -- the author of the
original Microsoft default stylesheet:
-------------------------------------
<!--
  IE5 default style sheet, provides a view of any XML document
  and provides the following features:
  - auto-indenting of the display, expanding of entity references
  - click or tab/return to expand/collapse
  - color coding of markup
  - color coding of recognized namespaces - xml, xmlns, xsl, dt
  
  This style sheet is available in IE5 in a compact form at the URL
  "res://msxml.dll/DEFAULTSS.xsl".  This version differs only in the
  addition of comments and whitespace for readability.
  
  Author:  Jonathan Marsh (jmarsh@microsoft.com)
-->
------------------------------------

Change History:
13 June 2001
   1. Implemented hi-lighting of default/implied attributr values.
   2. Corrected the syntax colouring of stylesheets.
   3. Added a better, even more readable colouring scheme
   4. Removed a minor bug, so  that now namespace definitions are
      properly displayed in MSXML4
	  
 7 Jan. 2001
Implemented support for dynamic, user-defined XSLT keys. The user can now define, 
modify or delete xsl:key(s) and use key() functions as part of the entered expressions.
Existing xsl:key definitions are conveniently displayed in a table, they can be selected 
and used in the expression ("OK" or dbl-click) or modified, or deleted. 

When a new file is loaded, the list of xsl:keys for the previous file is remembered. 
If afterwords the previous file is re-loaded, the list of xsl:keys is restored 
and any key-name can be immediately used in a key() function within an XPath expression.

14 Dec. 2000
Implemented support for dynamic, user-defined XSLT variables. The user can now define, 
modify or delete XSLT variables and use $variableName as part of the entered expressions.
Existing variables are conveniently displayed in a table, they can be selected and used 
in the expression ("OK" or dbl-click) or modified, or deleted. 

New variables can be defined by entering their value "from scratch" or by selecting 
an expression from the list of all entered expressions.

When a new file is loaded, the list of variables for the previous file is remembered. 
If afterwords the previous file is re-loaded, the list of variables is restored 
and any variable can be immediately used in an XPath expression.

11 Nov. 2000
All expressions entered for a specific xml file are remembered and the user can select an earlier-entered expression from a list.
When switching to a file that the user worked earlier with (during the current session), the list of entered expressions for that file is used.

30 Oct. 2000
Fixed a bug reported by Albert Tsun -- the namespace declarations of the source xml are now dynamically added to the stylesheet. When a new source xml file is loaded, the previously added namespace definitions are removed from the stylesheet, and the ones of the newly loaded xml file are added this time.

28 Oct. 2000
Added the ability to evaluate scalar expressions -- this turned the XPath 
Visualiser into a full-blown Visual XPath Interpreter.

15 Oct. 2000
Fixed a bug -- an error MsgBox was showing when the XPath query
resulted in an empty node-set.

8 Oct. 2000
A. Implemented Navigation through the selected nodes:
    1. First, Last, Next, Previous buttons.
    2. Occurence/Total displayed/Total in selection counter.
B. Convenience Features:
   Clicking the "Enter" key in an input field will now cause 
   the button right to it to be "clicked".


4 Oct. 2000
The user can now use QNames in his XPath expression.

2 Oct. 2000
Colapsed elements, which contain selected nodes now are detected and hi-lighted in navy. The + is also replaced by a red asterisk.

1 Oct. 2000
  1. Added namespace support -- Namespace definition nodes are now properly displayed.
     XPath expressions containing the namespace axis are now evaluated and the results hi-lighted correctly.
  2. This version only runs with the latest September MSXML release.
  3. In case you have an earlier version than the September one, 
     then you must download and use the xpathvisualiser.zip file. 
	 I will no longer develop this earlier version.

28 Sep. 2000. 
Fixed a bug that hi-lighted the end-tag (in addition to the
start tag of a selected element.

27 Sep. 2000.  Fixed the following bugs found by Aung Aung (aaung@microsoft.com):
> 1. one thing, if I
> hit 'Enter' key  when my coursor is in the browse box, it flip to a 
> "This page is unable to display" page, I think you might want to fix it
>
> 2. <!-- ************** use apply-templates instead of value-of, or the text
> node won't be colored ************-->  
>  <xsl:apply-templates/>
>  <!--
>    <SPAN class="tx"><xsl:value-of select="."/></SPAN>
>    -->
> <!-- ************** END ************-->  


26 Sep. 2000. Fixed the following bugs found by Aung Aung (aaung@microsoft.com):

> 1. async property on the documents (style and source) should set to
> false
> before loading, or "attempt to modify a read-only node" error occurs.
> ( need
> to fix in htm file)
>
> 2. If the fileName is invalid the loadFile() got called infinately
> which
> crash IE. (need to check and not call doQuery() from inside
> loadFile()).
> 


 9 Sep. 2000. Submitted initially to vbxml.com.
