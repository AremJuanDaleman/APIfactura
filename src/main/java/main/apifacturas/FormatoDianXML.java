/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.apifacturas;


import org.json.JSONObject;

/**
 *
 * @author juan
 */
public class FormatoDianXML implements FormatoCliente{

    String facturaxml = "FACTURA CLIENTE<br/>";
    
    @Override
    public String crearFormato(JSONObject json) {
        
        String numfac=json.getString("numfac");
        String numempresa=json.getString("numempresa");
        String empresa=json.getString("empresa");
        Double valo=Double.parseDouble(json.getString("valor"));
        Double impuest=valo*0.19;
        Double gananci=valo-impuest;
        String valor= valo.toString();
        String impuesto= impuest.toString();
        String ganancia=gananci.toString();
        
        
        
        
        String cadena=
        "&lt;?xml version='1.0' encoding='UTF-8'?&gt;"+"<br/>"+
        "&lt;fe:Invoice xmlns:fe='http://www.dian.gov.co/contratos/facturaelectronica/v1' xmlns:cac='urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2' xmlns:cbc='urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2' xmlns:clm54217='urn:un:unece:uncefact:codelist:specification:54217:2001' xmlns:clm66411='urn:un:unece:uncefact:codelist:specification:66411:2001' xmlns:clmIANAMIMEMediaType='urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003' xmlns:ext='urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2' xmlns:qdt='urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2' xmlns:sts='http://www.dian.gov.co/contratos/facturaelectronica/v1/Structures' xmlns:udt='urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation=''&gt;"+"<br/>"+
          "&lt;ext:UBLExtensions&gt;"+"<br/>"+
            "&lt;ext:UBLExtension&gt;"+"<br/>"+
              "&lt;ext:ExtensionContent&gt;"+"<br/>"+
                "&lt;sts:DianExtensions&gt;"+"<br/>"+
                  "&lt;sts:InvoiceControl&gt;"+"<br/>"+
                    "&lt;sts:InvoiceAuthorization&gt;"+numfac+"&lt;/sts:InvoiceAuthorization&gt;"+"<br/>"+
                    "&lt;sts:AuthorizationPeriod&gt;"+"<br/>"+
                      "&lt;cbc:StartDate&gt;2018-05-22&lt;/cbc:StartDate&gt;"+"<br/>"+
                      "&lt;cbc:EndDate&gt;2019-05-22&lt;/cbc:EndDate&gt;"+"<br/>"+
                    "&lt;/sts:AuthorizationPeriod&gt;"+"<br/>"+
                    "&lt;sts:AuthorizedInvoices&gt;"+"<br/>"+
                      "&lt;sts:Prefix&gt;MD&lt;/sts:Prefix&gt;"+"<br/>"+
                      "&lt;sts:From&gt;100001&lt;/sts:From&gt;"+"<br/>"+
                      "&lt;sts:To&gt;174999&lt;/sts:To&gt;"+"<br/>"+
                    "&lt;/sts:AuthorizedInvoices&gt;"+"<br/>"+
                  "&lt;/sts:InvoiceControl&gt;"+"<br/>"+
                  "&lt;sts:InvoiceSource&gt;"+"<br/>"+
                    "&lt;cbc:IdentificationCode listAgencyID='"+numempresa+"' listAgencyName="+empresa +" listSchemeURI='urn:oasis:names:specification:ubl:codelist:gc:CountryIdentificationCode-2.0'&gt;CO&lt;/cbc:IdentificationCode&gt;"+"<br/>"+
                  "&lt;/sts:InvoiceSource&gt;"+"<br/>"+
                  "&lt;sts:SoftwareProvider&gt;"+"<br/>"+
                    "&lt;sts:ProviderID schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)'/&gt;"+"<br/>"+
                    "&lt;sts:SoftwareID schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)'/&gt;"+"<br/>"+
                  "&lt;/sts:SoftwareProvider&gt;"+"<br/>"+
                  "&lt;sts:SoftwareSecurityCode schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)'/&gt;"+"<br/>"+
                "&lt;/sts:DianExtensions&gt;"+"<br/>"+
              "&lt;/ext:ExtensionContent&gt;"+"<br/>"+
            "&lt;/ext:UBLExtension&gt;"+"<br/>"+
            "&lt;ext:UBLExtension&gt;"+"<br/>"+
              "&lt;ext:ExtensionContent/&gt;"+"<br/>"+
            "&lt;/ext:UBLExtension&gt;"+"<br/>"+
          "&lt;/ext:UBLExtensions&gt;"+"<br/>"+
          "&lt;cbc:UBLVersionID&gt;UBL 2.0&lt;/cbc:UBLVersionID&gt;"+"<br/>"+
          "&lt;cbc:ProfileID&gt;DIAN 1.0&lt;/cbc:ProfileID&gt;"+"<br/>"+
          "&lt;cbc:ID&gt;MD100202&lt;/cbc:ID&gt;"+"<br/>"+
          "&lt;cbc:UUID schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)'&gt;371b2af5b92f607948788d32fa7a56e5c1d5a02e&lt;/cbc:UUID&gt;"+"<br/>"+
          "&lt;cbc:IssueDate&gt;2018-05-22&lt;/cbc:IssueDate&gt;"+"<br/>"+
          "&lt;cbc:IssueTime&gt;00:00:00&lt;/cbc:IssueTime&gt;"+"<br/>"+
          "&lt;cbc:InvoiceTypeCode listAgencyID='195' listAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)' listSchemeURI='http://www.dian.gov.co/contratos/facturaelectronica/v1/InvoiceType'&gt;1&lt;/cbc:InvoiceTypeCode&gt;"+"<br/>"+
          "&lt;cbc:Note&gt;Autorización de numeración de facturación N°"+numfac+ "de 2018/05/22 Modalidad Factura Electrónica Desde N° MD100001 hasta MD174999 con vigencia de 18 meses&lt;/cbc:Note&gt;"+"<br/>"+
          "&lt;cbc:DocumentCurrencyCode&gt;COP&lt;/cbc:DocumentCurrencyCode&gt;"+"<br/>"+
          "&lt;fe:AccountingSupplierParty&gt;"+"<br/>"+
            "&lt;cbc:AdditionalAccountID/&gt;"+"<br/>"+
            "&lt;fe:Party&gt;"+"<br/>"+
             "&lt;cac:PartyIdentification&gt;"+"<br/>"+
                "&lt;cbc:ID schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)' schemeID='31'&gt;890930534&lt;/cbc:ID&gt;"+"<br/>"+
              "&lt;/cac:PartyIdentification&gt;"+"<br/>"+
              "&lt;cac:PartyName&gt;"+"<br/>"+
                "&lt;cbc:Name&gt;"+empresa+"&lt;/cbc:Name&gt;"+"<br/>"+
              "&lt;/cac:PartyName&gt;"+"<br/>"+
              "&lt;fe:PhysicalLocation&gt;"+"<br/>"+
                "&lt;fe:Address&gt;"+"<br/>"+
                  "&lt;cbc:Department&gt;CUNDINAMARCA&lt;/cbc:Department&gt;"+"<br/>"+
                  "&lt;cbc:CitySubdivisionName&gt;BOGOTA&lt;/cbc:CitySubdivisionName&gt;"+"<br/>"+
                  "&lt;cbc:CityName&gt;BOGOTA&lt;/cbc:CityName&gt;"+"<br/>"+
                  "&lt;cac:AddressLine&gt;"+"<br/>"+
                    "&lt;cbc:Line&gt;CR 61 #173-41&lt;/cbc:Line&gt;"+"<br/>"+
                  "&lt;/cac:AddressLine&gt;"+"<br/>"+
                  "&lt;cac:Country&gt;"+"<br/>"+
                    "&lt;cbc:IdentificationCode&gt;CO&lt;/cbc:IdentificationCode&gt;"+"<br/>"+
                  "&lt;/cac:Country&gt;"+"<br/>"+
                "&lt;/fe:Address&gt;"+"<br/>"+
              "&lt;/fe:PhysicalLocation&gt;"+"<br/>"+
              "&lt;fe:PartyTaxScheme&gt;"+"<br/>"+
                "&lt;cbc:TaxLevelCode&gt;0&lt;/cbc:TaxLevelCode&gt;"+"<br/>"+
                "&lt;cac:TaxScheme/&gt;"+"<br/>"+
              "&lt;/fe:PartyTaxScheme&gt;"+"<br/>"+
              "&lt;fe:PartyLegalEntity&gt;"+"<br/>"+
               "&lt;cbc:RegistrationName&gt;"+empresa+"&lt;/cbc:RegistrationName&gt;"+"<br/>"+
              "&lt;/fe:PartyLegalEntity&gt;"+"<br/>"+
            "&lt;/fe:Party&gt;"+"<br/>"+
          "&lt;/fe:AccountingSupplierParty&gt;"+"<br/>"+
          "&lt;fe:AccountingCustomerParty&gt;"+"<br/>"+
            "&lt;cbc:AdditionalAccountID/&gt;"+"<br/>"+
            "&lt;fe:Party&gt;"+"<br/>"+
              "&lt;cac:PartyIdentification&gt;"+"<br/>"+
                "&lt;cbc:ID schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)' schemeID='31'&gt;830507412&lt;/cbc:ID&gt;"+"<br/>"+
              "&lt;/cac:PartyIdentification&gt;"+"<br/>"+
             "&lt;fe:PhysicalLocation&gt;"+"<br/>"+
                "&lt;fe:Address&gt;"+"<br/>"+
                  "&lt;cbc:Department&gt;11&lt;/cbc:Department&gt;"+"<br/>"+
                  "&lt;cbc:CitySubdivisionName&gt;&lt;/cbc:CitySubdivisionName&gt;"+"<br/>"+
                  "&lt;cbc:CityName&gt;BOGOTA&lt;/cbc:CityName&gt;"+"<br/>"+
                  "&lt;cac:AddressLine&gt;"+"<br/>"+
                    "&lt;cbc:Line&gt;CARRERA 62#173-41&lt;/cbc:Line&gt;"+"<br/>"+
                  "&lt;/cac:AddressLine&gt;"+"<br/>"+
                  "&lt;cac:Country&gt;"+"<br/>"+
                    "&lt;cbc:IdentificationCode&gt;CO&lt;/cbc:IdentificationCode&gt;"+"<br/>"+
                  "&lt;/cac:Country&gt;"+"<br/>"+
                "&lt;/fe:Address&gt;"+"<br/>"+
              "&lt;/fe:PhysicalLocation&gt;"+"<br/>"+
              "&lt;fe:PartyTaxScheme&gt;"+"<br/>"+
                "&lt;cbc:TaxLevelCode&gt;0&lt;/cbc:TaxLevelCode&gt;"+"<br/>"+
                "&lt;cac:TaxScheme/&gt;"+"<br/>"+
              "&lt;/fe:PartyTaxScheme&gt;"+"<br/>"+
              "&lt;fe:Person&gt;"+"<br/>"+
                "&lt;cbc:FirstName/&gt;"+"<br/>"+
                "&lt;cbc:FamilyName/&gt;"+"<br/>"+
                "&lt;cbc:MiddleName/&gt;"+"<br/>"+
              "&lt;/fe:Person&gt;"+"<br/>"+
            "&lt;/fe:Party&gt;"+"<br/>"+
          "&lt;/fe:AccountingCustomerParty&gt;"+"<br/>"+
          "&lt;fe:TaxTotal&gt;"+"<br/>"+
            "&lt;cbc:TaxAmount currencyID='COP'&gt;"+impuesto+"&lt;/cbc:TaxAmount&gt;"+"<br/>"+
            "&lt;cbc:TaxEvidenceIndicator&gt;false&lt;/cbc:TaxEvidenceIndicator&gt;"+"<br/>"+
            "&lt;fe:TaxSubtotal&gt;"+"<br/>"+
              "&lt;cbc:TaxableAmount currencyID='COP'&gt;"+valor+"&lt;/cbc:TaxableAmount&gt;"+"<br/>"+
              "&lt;cbc:TaxAmount currencyID='COP'&gt;"+impuesto+"&lt;/cbc:TaxAmount&gt;"+"<br/>"+
              "&lt;cbc:Percent&gt;19&lt;/cbc:Percent&gt;"+"<br/>"+
              "&lt;cac:TaxCategory&gt;"+"<br/>"+
               " &lt;cac:TaxScheme&gt;"+"<br/>"+
                  "&lt;cbc:ID&gt;01&lt;/cbc:ID&gt;"+"<br/>"+
                "&lt;/cac:TaxScheme&gt;"+"<br/>"+
              "&lt;/cac:TaxCategory&gt;"+"<br/>"+
            "&lt;/fe:TaxSubtotal&gt;"+"<br/>"+
          "&lt;/fe:TaxTotal&gt;"+"<br/>"+
          "&lt;fe:TaxTotal&gt;"+"<br/>"+
            "&lt;cbc:TaxAmount currencyID='COP'&gt;0.00&lt;/cbc:TaxAmount&gt;"+"<br/>"+
            "&lt;cbc:TaxEvidenceIndicator&gt;false&lt;/cbc:TaxEvidenceIndicator&gt;"+"<br/>"+
            "&lt;fe:TaxSubtotal&gt;"+"<br/>"+
              "&lt;cbc:TaxableAmount currencyID='COP'&gt;0.00&lt;/cbc:TaxableAmount&gt;"+"<br/>"+
              "&lt;cbc:TaxAmount currencyID='COP'&gt;0.00&lt;/cbc:TaxAmount&gt;"+"<br/>"+
              "&lt;cbc:Percent&gt;0&lt;/cbc:Percent&gt;"+"<br/>"+
              "&lt;cac:TaxCategory&gt;"+"<br/>"+
                "&lt;cac:TaxScheme&gt;"+"<br/>"+
                  "&lt;cbc:ID&gt;02&lt;/cbc:ID&gt;"+"<br/>"+
                "&lt;/cac:TaxScheme&gt;"+"<br/>"+
              "&lt;/cac:TaxCategory&gt;"+"<br/>"+
            "&lt;/fe:TaxSubtotal&gt;"+"<br/>"+
          "&lt;/fe:TaxTotal&gt;"+"<br/>"+
          "&lt;fe:TaxTotal&gt;"+"<br/>"+
            "&lt;cbc:TaxAmount currencyID='COP'&gt;0.00&lt;/cbc:TaxAmount&gt;"+"<br/>"+
            "&lt;cbc:TaxEvidenceIndicator&gt;false&lt;/cbc:TaxEvidenceIndicator&gt;"+"<br/>"+
            "&lt;fe:TaxSubtotal&gt;"+"<br/>"+
              "&lt;cbc:TaxableAmount currencyID='COP'&gt;0.00&lt;/cbc:TaxableAmount&gt;"+"<br/>"+
              "&lt;cbc:TaxAmount currencyID='COP'&gt;0.00&lt;/cbc:TaxAmount&gt;"+"<br/>"+
              "&lt;cbc:Percent&gt;0&lt;/cbc:Percent&gt;"+"<br/>"+
              "&lt;cac:TaxCategory&gt;"+"<br/>"+
                "&lt;cac:TaxScheme&gt;"+"<br/>"+
                  "&lt;cbc:ID&gt;03&lt;/cbc:ID&gt;"+"<br/>"+
                "&lt;/cac:TaxScheme&gt;"+"<br/>"+
              "&lt;/cac:TaxCategory&gt;"+"<br/>"+
            "&lt;/fe:TaxSubtotal&gt;"+"<br/>"+
          "&lt;/fe:TaxTotal&gt;"+"<br/>"+
          "&lt;fe:LegalMonetaryTotal&gt;"+"<br/>"+
            "&lt;cbc:LineExtensionAmount currencyID='COP'&gt;"+ganancia+"&lt;/cbc:LineExtensionAmount&gt;"+"<br/>"+
            "&lt;cbc:TaxExclusiveAmount currencyID='COP'&gt;"+ganancia+"&lt;/cbc:TaxExclusiveAmount&gt;"+"<br/>"+
            "&lt;cbc:PayableAmount currencyID='COP'&gt;"+valor+"&lt;/cbc:PayableAmount&gt;"+"<br/>"+
          "&lt;/fe:LegalMonetaryTotal&gt;"+"<br/>"+
          "&lt;fe:InvoiceLine&gt;"+"<br/>"+
            "&lt;cbc:ID&gt;1&lt;/cbc:ID&gt;"+"<br/>"+
            "&lt;cbc:InvoicedQuantity&gt;1&lt;/cbc:InvoicedQuantity&gt;"+"<br/>"+
            "&lt;cbc:LineExtensionAmount currencyID='COP'&gt;"+valor+"&lt;/cbc:LineExtensionAmount&gt;"+"<br/>"+
            "&lt;fe:Item&gt;"+"<br/>"+
              "&lt;cbc:Description&gt;BPO LOGÍSTICO&lt;/cbc:Description&gt;"+"<br/>"+
            "&lt;/fe:Item&gt;"+"<br/>"+
            "&lt;fe:Price&gt;"+"<br/>"+
              "&lt;cbc:PriceAmount currencyID='COP'&gt;"+valor+"&lt;/cbc:PriceAmount&gt;"+"<br/>"+
            "&lt;/fe:Price&gt;"+"<br/>"+
          "&lt;/fe:InvoiceLine&gt;"+"<br/>"+
        "&lt;/fe:Invoice&gt;"+"<br/>";          
     return cadena;   
              
              
    }
    
}
