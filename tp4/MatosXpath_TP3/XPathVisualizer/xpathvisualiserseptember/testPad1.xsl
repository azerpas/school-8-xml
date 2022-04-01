<xsl:stylesheet version='1.0'
xmlns:xsl='http://www.w3.org/1999/XSL/Transform'
 >
 <xsl:output method="text"/>
<xsl:preserve-space elements="*"/>

<xsl:template match="/">
	'<xsl:call-template name="pad">
		<xsl:with-param name="String" select="'abc'"/>
		<xsl:with-param name="length" select="6"/>
	</xsl:call-template>'
	'<xsl:call-template name="pad2">
		<xsl:with-param name="String" select="'abc'"/>
		<xsl:with-param name="length" select="6"/>
	</xsl:call-template>'
</xsl:template>

<xsl:template name="pad">
    <xsl:param name="String"/>
    <xsl:param name="length"/>
    <xsl:variable name="spaces"><xsl:text xml:space="preserve">          </xsl:text></xsl:variable>
    <xsl:value-of select="substring(concat($String,$spaces),1,$length)"/>
</xsl:template>

<xsl:template name="pad2">
    <xsl:param name="String"/>
    <xsl:param name="length"/>
    <xsl:variable name="spaces" select="'          '"/>
    <xsl:value-of select="substring(concat($String,$spaces),1,$length)"/>
</xsl:template>

</xsl:stylesheet>