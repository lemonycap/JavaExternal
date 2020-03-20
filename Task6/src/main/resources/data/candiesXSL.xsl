<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
       <html>
           <body>
               <h2>Candies List</h2>
               <table border="1">
                       <th align="left">Product Name</th>
                       <th align="left">Energy</th>
                       <th align="left">Type</th>
                       <th align="left">Water</th>
                       <th align="left">Sugar</th>
                       <th align="left">Fructose</th>
                       <th align="left">Vaniline</th>
                       <th align="left">Chocolate type</th>
                      <th align="left">Proteins</th>
                      <th align="left">Fats</th>
                      <th align="left">Carbs</th>
                      <th align="left">Product owner</th>
                   <xsl:for-each select="candies/candy">
                       <xsl:sort select="product_owner"/>
                       <tr>
                           <td><xsl:value-of select="name"/></td>
                           <td><xsl:value-of select="energy"/></td>
                           <td><xsl:value-of select="type"/></td>
                           <td><xsl:value-of select="ingredients/water"/></td>
                           <td><xsl:value-of select="ingredients/sugar"/></td>
                           <td><xsl:value-of select="ingredients/fructose"/></td>
                           <td><xsl:value-of select="ingredients/vaniline"/></td>
                           <td><xsl:value-of select="ingredients/chocolate_type"/></td>
                           <td><xsl:value-of select="value/proteins"/></td>
                           <td><xsl:value-of select="value/fats"/></td>
                           <td><xsl:value-of select="value/carbs"/></td>
                           <td><xsl:value-of select="product_owner"/></td>
                       </tr>
                   </xsl:for-each>
               </table>
           </body>
       </html>
    </xsl:template></xsl:stylesheet>
