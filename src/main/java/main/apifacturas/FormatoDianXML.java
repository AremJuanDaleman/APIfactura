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

    String facturaxml = "FACTURA CLIENTE\n";
    
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
        "<html><body>"
        + "<?xml version='1.0' encoding='UTF-8'?>"+"\n"+
        "<fe:Invoice xmlns:fe='http://www.dian.gov.co/contratos/facturaelectronica/v1' xmlns:cac='urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2' xmlns:cbc='urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2' xmlns:clm54217='urn:un:unece:uncefact:codelist:specification:54217:2001' xmlns:clm66411='urn:un:unece:uncefact:codelist:specification:66411:2001' xmlns:clmIANAMIMEMediaType='urn:un:unece:uncefact:codelist:specification:IANAMIMEMediaType:2003' xmlns:ext='urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2' xmlns:qdt='urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2' xmlns:sts='http://www.dian.gov.co/contratos/facturaelectronica/v1/Structures' xmlns:udt='urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation=''>"+"\n"+
          "<ext:UBLExtensions>"+"\n"+
            "<ext:UBLExtension>"+"\n"+
              "<ext:ExtensionContent>"+"\n"+
                "<sts:DianExtensions>"+"\n"+
                  "<sts:InvoiceControl>"+"\n"+
                    "<sts:InvoiceAuthorization>"+numfac+"</sts:InvoiceAuthorization>"+"\n"+
                    "<sts:AuthorizationPeriod>"+"\n"+
                      "<cbc:StartDate>2018-05-22</cbc:StartDate>"+"\n"+
                      "<cbc:EndDate>2019-05-22</cbc:EndDate>"+"\n"+
                    "</sts:AuthorizationPeriod>"+"\n"+
                    "<sts:AuthorizedInvoices>"+"\n"+
                      "<sts:Prefix>MD</sts:Prefix>"+"\n"+
                      "<sts:From>100001</sts:From>"+"\n"+
                      "<sts:To>174999</sts:To>"+"\n"+
                    "</sts:AuthorizedInvoices>"+"\n"+
                  "</sts:InvoiceControl>"+"\n"+
                  "<sts:InvoiceSource>"+"\n"+
                    "<cbc:IdentificationCode listAgencyID='"+numempresa+"' listAgencyName="+empresa +" listSchemeURI='urn:oasis:names:specification:ubl:codelist:gc:CountryIdentificationCode-2.0'>CO</cbc:IdentificationCode>"+"\n"+
                  "</sts:InvoiceSource>"+"\n"+
                  "<sts:SoftwareProvider>"+"\n"+
                    "<sts:ProviderID schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)'/>"+"\n"+
                    "<sts:SoftwareID schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)'/>"+"\n"+
                  "</sts:SoftwareProvider>"+"\n"+
                  "<sts:SoftwareSecurityCode schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)'/>"+"\n"+
                "</sts:DianExtensions>"+"\n"+
              "</ext:ExtensionContent>"+"\n"+
            "</ext:UBLExtension>"+"\n"+
            "<ext:UBLExtension>"+"\n"+
              "<ext:ExtensionContent/>"+"\n"+
            "</ext:UBLExtension>"+"\n"+
          "</ext:UBLExtensions>"+"\n"+
          "<cbc:UBLVersionID>UBL 2.0</cbc:UBLVersionID>"+"\n"+
          "<cbc:ProfileID>DIAN 1.0</cbc:ProfileID>"+"\n"+
          "<cbc:ID>MD100202</cbc:ID>"+"\n"+
          "<cbc:UUID schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)'>371b2af5b92f607948788d32fa7a56e5c1d5a02e</cbc:UUID>"+"\n"+
          "<cbc:IssueDate>2018-05-22</cbc:IssueDate>"+"\n"+
          "<cbc:IssueTime>00:00:00</cbc:IssueTime>"+"\n"+
          "<cbc:InvoiceTypeCode listAgencyID='195' listAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)' listSchemeURI='http://www.dian.gov.co/contratos/facturaelectronica/v1/InvoiceType'>1</cbc:InvoiceTypeCode>"+"\n"+
          "<cbc:Note>Autorización de numeración de facturación N°"+numfac+ "de 2018/05/22 Modalidad Factura Electrónica Desde N° MD100001 hasta MD174999 con vigencia de 18 meses</cbc:Note>"+"\n"+
          "<cbc:DocumentCurrencyCode>COP</cbc:DocumentCurrencyCode>"+"\n"+
          "<fe:AccountingSupplierParty>"+"\n"+
            "<cbc:AdditionalAccountID/>"+"\n"+
            "<fe:Party>"+"\n"+
             "<cac:PartyIdentification>"+"\n"+
                "<cbc:ID schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)' schemeID='31'>890930534</cbc:ID>"+"\n"+
              "</cac:PartyIdentification>"+"\n"+
              "<cac:PartyName>"+"\n"+
                "<cbc:Name>"+empresa+"</cbc:Name>"+"\n"+
              "</cac:PartyName>"+"\n"+
              "<fe:PhysicalLocation>"+"\n"+
                "<fe:Address>"+"\n"+
                  "<cbc:Department>CUNDINAMARCA</cbc:Department>"+"\n"+
                  "<cbc:CitySubdivisionName>BOGOTA</cbc:CitySubdivisionName>"+"\n"+
                  "<cbc:CityName>BOGOTA</cbc:CityName>"+"\n"+
                  "<cac:AddressLine>"+"\n"+
                    "<cbc:Line>CR 61 #173-41</cbc:Line>"+"\n"+
                  "</cac:AddressLine>"+"\n"+
                  "<cac:Country>"+"\n"+
                    "<cbc:IdentificationCode>CO</cbc:IdentificationCode>"+"\n"+
                  "</cac:Country>"+"\n"+
                "</fe:Address>"+"\n"+
              "</fe:PhysicalLocation>"+"\n"+
              "<fe:PartyTaxScheme>"+"\n"+
                "<cbc:TaxLevelCode>0</cbc:TaxLevelCode>"+"\n"+
                "<cac:TaxScheme/>"+"\n"+
              "</fe:PartyTaxScheme>"+"\n"+
              "<fe:PartyLegalEntity>"+"\n"+
               "<cbc:RegistrationName>"+empresa+"</cbc:RegistrationName>"+"\n"+
              "</fe:PartyLegalEntity>"+"\n"+
            "</fe:Party>"+"\n"+
          "</fe:AccountingSupplierParty>"+"\n"+
          "<fe:AccountingCustomerParty>"+"\n"+
            "<cbc:AdditionalAccountID/>"+"\n"+
            "<fe:Party>"+"\n"+
              "<cac:PartyIdentification>"+"\n"+
                "<cbc:ID schemeAgencyID='195' schemeAgencyName='CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)' schemeID='31'>830507412</cbc:ID>"+"\n"+
              "</cac:PartyIdentification>"+"\n"+
             "<fe:PhysicalLocation>"+"\n"+
                "<fe:Address>"+"\n"+
                  "<cbc:Department>11</cbc:Department>"+"\n"+
                  "<cbc:CitySubdivisionName></cbc:CitySubdivisionName>"+"\n"+
                  "<cbc:CityName>BOGOTA</cbc:CityName>"+"\n"+
                  "<cac:AddressLine>"+"\n"+
                    "<cbc:Line>CARRERA 62#173-41</cbc:Line>"+"\n"+
                  "</cac:AddressLine>"+"\n"+
                  "<cac:Country>"+"\n"+
                    "<cbc:IdentificationCode>CO</cbc:IdentificationCode>"+"\n"+
                  "</cac:Country>"+"\n"+
                "</fe:Address>"+"\n"+
              "</fe:PhysicalLocation>"+"\n"+
              "<fe:PartyTaxScheme>"+"\n"+
                "<cbc:TaxLevelCode>0</cbc:TaxLevelCode>"+"\n"+
                "<cac:TaxScheme/>"+"\n"+
              "</fe:PartyTaxScheme>"+"\n"+
              "<fe:Person>"+"\n"+
                "<cbc:FirstName/>"+"\n"+
                "<cbc:FamilyName/>"+"\n"+
                "<cbc:MiddleName/>"+"\n"+
              "</fe:Person>"+"\n"+
            "</fe:Party>"+"\n"+
          "</fe:AccountingCustomerParty>"+"\n"+
          "<fe:TaxTotal>"+"\n"+
            "<cbc:TaxAmount currencyID='COP'>"+impuesto+"</cbc:TaxAmount>"+"\n"+
            "<cbc:TaxEvidenceIndicator>false</cbc:TaxEvidenceIndicator>"+"\n"+
            "<fe:TaxSubtotal>"+"\n"+
              "<cbc:TaxableAmount currencyID='COP'>"+valor+"</cbc:TaxableAmount>"+"\n"+
              "<cbc:TaxAmount currencyID='COP'>"+impuesto+"</cbc:TaxAmount>"+"\n"+
              "<cbc:Percent>19</cbc:Percent>"+"\n"+
              "<cac:TaxCategory>"+"\n"+
               " <cac:TaxScheme>"+"\n"+
                  "<cbc:ID>01</cbc:ID>"+"\n"+
                "</cac:TaxScheme>"+"\n"+
              "</cac:TaxCategory>"+"\n"+
            "</fe:TaxSubtotal>"+"\n"+
          "</fe:TaxTotal>"+"\n"+
          "<fe:TaxTotal>"+"\n"+
            "<cbc:TaxAmount currencyID='COP'>0.00</cbc:TaxAmount>"+"\n"+
            "<cbc:TaxEvidenceIndicator>false</cbc:TaxEvidenceIndicator>"+"\n"+
            "<fe:TaxSubtotal>"+"\n"+
              "<cbc:TaxableAmount currencyID='COP'>0.00</cbc:TaxableAmount>"+"\n"+
              "<cbc:TaxAmount currencyID='COP'>0.00</cbc:TaxAmount>"+"\n"+
              "<cbc:Percent>0</cbc:Percent>"+"\n"+
              "<cac:TaxCategory>"+"\n"+
                "<cac:TaxScheme>"+"\n"+
                  "<cbc:ID>02</cbc:ID>"+"\n"+
                "</cac:TaxScheme>"+"\n"+
              "</cac:TaxCategory>"+"\n"+
            "</fe:TaxSubtotal>"+"\n"+
          "</fe:TaxTotal>"+"\n"+
          "<fe:TaxTotal>"+"\n"+
            "<cbc:TaxAmount currencyID='COP'>0.00</cbc:TaxAmount>"+"\n"+
            "<cbc:TaxEvidenceIndicator>false</cbc:TaxEvidenceIndicator>"+"\n"+
            "<fe:TaxSubtotal>"+"\n"+
              "<cbc:TaxableAmount currencyID='COP'>0.00</cbc:TaxableAmount>"+"\n"+
              "<cbc:TaxAmount currencyID='COP'>0.00</cbc:TaxAmount>"+"\n"+
              "<cbc:Percent>0</cbc:Percent>"+"\n"+
              "<cac:TaxCategory>"+"\n"+
                "<cac:TaxScheme>"+"\n"+
                  "<cbc:ID>03</cbc:ID>"+"\n"+
                "</cac:TaxScheme>"+"\n"+
              "</cac:TaxCategory>"+"\n"+
            "</fe:TaxSubtotal>"+"\n"+
          "</fe:TaxTotal>"+"\n"+
          "<fe:LegalMonetaryTotal>"+"\n"+
            "<cbc:LineExtensionAmount currencyID='COP'>"+ganancia+"</cbc:LineExtensionAmount>"+"\n"+
            "<cbc:TaxExclusiveAmount currencyID='COP'>"+ganancia+"</cbc:TaxExclusiveAmount>"+"\n"+
            "<cbc:PayableAmount currencyID='COP'>"+valor+"</cbc:PayableAmount>"+"\n"+
          "</fe:LegalMonetaryTotal>"+"\n"+
          "<fe:InvoiceLine>"+"\n"+
            "<cbc:ID>1</cbc:ID>"+"\n"+
            "<cbc:InvoicedQuantity>1</cbc:InvoicedQuantity>"+"\n"+
            "<cbc:LineExtensionAmount currencyID='COP'>"+valor+"</cbc:LineExtensionAmount>"+"\n"+
            "<fe:Item>"+"\n"+
              "<cbc:Description>BPO LOGÍSTICO</cbc:Description>"+"\n"+
            "</fe:Item>"+"\n"+
            "<fe:Price>"+"\n"+
              "<cbc:PriceAmount currencyID='COP'>"+valor+"</cbc:PriceAmount>"+"\n"+
            "</fe:Price>"+"\n"+
          "</fe:InvoiceLine>"+"\n"+
        "</fe:Invoice>"+"\n"+"<br/></body></html>";          
     return cadena;   
              
              
    }
    
}
