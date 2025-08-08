public package com.function;


import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.json.simple.JSONObject;
//import org.springframework.http.ResponseEntity;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;



public class sample {

    /**
     * This function listens at endpoint "/api/HttpExample". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpExample
     * 2. curl "{your host}/api/HttpExample?name=HTTP%20Query"
     * @throws IOException
     * @throws SAXException
    * 
    * 
     */
    @FunctionName("franchiseMapping")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET, HttpMethod.POST},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<String> request,
                final ExecutionContext context) throws TransformerException, ParseException, ParserConfigurationException, SAXException, IOException{
                         
                  try {
                     String requestBody=request.getBody();
                     DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
                   DocumentBuilder builder=factory.newDocumentBuilder();
                   Document outputRef  = builder.newDocument();
                   Document doc = builder.parse(new InputSource(new StringReader(requestBody)));
                   ObjectMapper objectMapper = new ObjectMapper();
                   objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                   objectMapper.setSerializationInclusion(Include.ALWAYS);
            
                    ArrayNode Retails=objectMapper.createArrayNode();
                    ArrayNode ModelYears=objectMapper.createArrayNode();
                        ObjectNode myObject=objectMapper.createObjectNode(); 
                        ObjectNode AssetClass=objectMapper.createObjectNode();
                        ObjectNode Brand=objectMapper.createObjectNode();
                        ObjectNode Test=objectMapper.createObjectNode(); 
                        ObjectNode OtherInfo=objectMapper.createObjectNode(); //AssetType
                        ObjectNode AssetType=objectMapper.createObjectNode();
                        ObjectNode retailref=objectMapper.createObjectNode();
                        ObjectNode YearRef=objectMapper.createObjectNode();

                        JsonNode jsonNode = objectMapper.createObjectNode().put("Test",(String) null);
          
         String code=doc.getElementsByTagName("ModelCode").item(0).getTextContent()!= null?doc.getElementsByTagName("ModelCode").item(0).getTextContent():"";
         if(((code != null) && (code != ""))&&(doc.getElementsByTagName("ModPack").item(0).getTextContent()!= null) &&(doc.getElementsByTagName("ModPack").item(0).getTextContent()!=""))
         {
          myObject.put("ExternalModelId",(code)+"-"+ (doc.getElementsByTagName("ModPack").item(0).getTextContent()!= null?doc.getElementsByTagName("ModPack").item(0).getTextContent():""));
         }
         
        
         if((code != null) && (code != ""))
        		 {
              myObject.put("Code", code);
        		 }
         
         else {
          myObject.set("Code", jsonNode.get("Test"));
         }
         
         
         NodeList nltest=doc.getElementsByTagName("ModelDescription");
         for(int x=0,size= nltest.getLength();x<size;++x) { 

             Element itemElement = (Element) nltest.item(x);
             
             switch(x) {
             case 0:
            	
              
            	 Test.put("z", doc.getElementsByTagName("ModelLang").item(0).getTextContent());
            	 Test.put("E", doc.getElementsByTagName("ModelDesc").item(0).getTextContent());
            	
            
             break;
             
             case 1:
            	 
            	 Test.put("y", doc.getElementsByTagName("ModelLang").item(1).getTextContent());
            	 Test.put("J", doc.getElementsByTagName("ModelDesc").item(1).getTextContent());
            
            	 break;
            	 
             }
            }
          myObject.put("Description", doc.getElementsByTagName("ModelDesc").item(0).getTextContent());
          

         if((myObject.get("Description") == null)||(myObject.get("Description").asText()==null))
         {
        	 myObject.set("Description", jsonNode.get("Test"));
         }
        
        
         myObject.put("IsActive", "FALSE");
        myObject.set("EngineCc", jsonNode.get("Test"));
     
         if((code != null) && (code != ""))
		 {
	 myObject.put("VariantCode", code);
		 
         String BaumusterNumber=code.substring(0, 7);
         myObject.put("BaumusterNumber",BaumusterNumber);
         
		 }
         else {
        	 myObject.set("VariantCode", jsonNode.get("Test"));
        	 myObject.set("BaumusterNumber", jsonNode.get("Test"));
         }
         
         if((doc.getElementsByTagName("SearchGroup1").item(0).getTextContent()!= null)&&(doc.getElementsByTagName("SearchGroup1").item(0).getTextContent()!=""))
    	 {
    		 myObject.put("Range",doc.getElementsByTagName("SearchGroup1").item(0).getTextContent()!= null?doc.getElementsByTagName("SearchGroup1").item(0).getTextContent():"");
    	 }
         
         if((code != null) && (code != ""))
		 {
        	 OtherInfo.put("TypeNumber", code);
        	 
		 }
         else {
        	 OtherInfo.set("TypeNumber", jsonNode.get("Test"));
         }
         
         if((doc.getElementsByTagName("Steering").item(0).getTextContent()!= null)&&(doc.getElementsByTagName("Steering").item(0).getTextContent()!=""))
    	 {
    		 OtherInfo.put("Steering",doc.getElementsByTagName("Steering").item(0).getTextContent()!= null?doc.getElementsByTagName("Steering").item(0).getTextContent():"");
    	 }
         else {
        	 OtherInfo.set("Steering",jsonNode.get("Test"));
         }
      
         OtherInfo.set("TypeName",jsonNode.get("Test"));
         OtherInfo.set("Abbreviation",jsonNode.get("Test"));
         OtherInfo.set("Color",jsonNode.get("Test"));
         OtherInfo.set("MPNameSWT",jsonNode.get("Test"));
        
         
        
         myObject.set("OtherInfo", OtherInfo);
         
         myObject.set("Weight", jsonNode.get("Test"));
         myObject.set("Capacity", jsonNode.get("Test"));
         myObject.set("ExcessMileageRate", jsonNode.get("Test"));
         
         
          myObject.put("LocalDescription", Test.get("J").asText());
       

         if((myObject.get("LocalDescription") == null)||(myObject.get("LocalDescription").asText() == ""))
         {
        	 myObject.set("LocalDescription", jsonNode.get("Test"));
         }
        
          myObject.put("ExternalDescription", Test.get("E").asText());
       
         if((myObject.get("ExternalDescription") == null)||(myObject.get("ExternalDescription").asText() == ""))
         {
        	 myObject.set("ExternalDescription", jsonNode.get("Test"));
         }
           
        
         if((doc.getElementsByTagName("ModPack").item(0).getTextContent()!= null) &&(doc.getElementsByTagName("ModPack").item(0).getTextContent()!=""))
         {
        	 myObject.put("MPName",doc.getElementsByTagName("ModPack").item(0).getTextContent()!= null?doc.getElementsByTagName("ModPack").item(0).getTextContent():"");
         }
         else {
        	 myObject.set("MPName", jsonNode.get("Test"));
         }
         myObject.set("ModelType", jsonNode.get("Test"));
         myObject.set("EngineType", jsonNode.get("Test"));
         
         
         if((doc.getElementsByTagName("ModelGroup").item(0).getTextContent()!= null) &&(doc.getElementsByTagName("ModelGroup").item(0).getTextContent()!=""))
         {
        	 AssetClass.put("ExternalCode",doc.getElementsByTagName("ModelGroup").item(0).getTextContent()!= null?doc.getElementsByTagName("ModelGroup").item(0).getTextContent():"");
         }
         else
         {
        	 AssetClass.set("ExternalCode",jsonNode.get("Test")); 
         }
         
         if((doc.getElementsByTagName("ModelGroup").item(0).getTextContent()!= null) &&(doc.getElementsByTagName("ModelGroup").item(0).getTextContent()!=""))
         {
        	 AssetClass.put("Description",doc.getElementsByTagName("ModelGroup").item(0).getTextContent()!= null?doc.getElementsByTagName("ModelGroup").item(0).getTextContent():"");
         }
         else
         {
        	 AssetClass.set("Description",jsonNode.get("Test")); 
         }
         AssetClass.set("Group", jsonNode.get("Test"));
         
         if((doc.getElementsByTagName("ModelGroupDesc").item(0).getTextContent()!= null) &&(doc.getElementsByTagName("ModelGroupDesc").item(0).getTextContent()!=""))
         {
        	 AssetClass.put("ExternalDescription",doc.getElementsByTagName("ModelGroupDesc").item(0).getTextContent()!= null?doc.getElementsByTagName("ModelGroupDesc").item(0).getTextContent():"");
         }
         else
         {
        	 AssetClass.set("ExternalDescription",jsonNode.get("Test")); 
         }
         AssetClass.set("OtherInfo",jsonNode.get("Test")); 
         
         if((doc.getElementsByTagName("ModelDivision").item(0).getTextContent()!= null) &&(doc.getElementsByTagName("ModelDivision").item(0).getTextContent()!=""))
         {
        	 Brand.put("ExternalCode",doc.getElementsByTagName("ModelDivision").item(0).getTextContent()!= null?doc.getElementsByTagName("ModelDivision").item(0).getTextContent():"");
         }
         else
         {
        	 Brand.set("ExternalCode",jsonNode.get("Test")); 
         }
         
         if((doc.getElementsByTagName("ModelDivisionDesc").item(0).getTextContent()!= null) &&(doc.getElementsByTagName("ModelDivisionDesc").item(0).getTextContent()!=""))
         {
        	 Brand.put("Description",doc.getElementsByTagName("ModelDivisionDesc").item(0).getTextContent()!= null?doc.getElementsByTagName("ModelDivisionDesc").item(0).getTextContent():"");
         }
         else
         {
        	 Brand.set("Description",jsonNode.get("Test")); 
         }
         Brand.set("LocalDescription", jsonNode.get("Test"));
         Brand.set("MappingCode", jsonNode.get("Test"));
         Brand.set("Identifier", jsonNode.get("Test"));
         AssetType.put("ExternalCode", "PC");
         AssetType.put("Descriptione", "Passenger Car");
         Brand.set("AssetType", AssetType);
         AssetClass.set("Brand", Brand);

         myObject.set("AssetClass", AssetClass);
         

         String vDateStringFrom="0";
         String vDateStringTo="0";
         String vYear="0";
         String vMonth="0";
         String vDate="0";
         String ValidTo ="0" ;
         String ValidFrom="0";
         
         if((doc.getElementsByTagName("RTPrice").item(0)!= null) &&(doc.getElementsByTagName("RTPrice").item(0).getTextContent()!=""))
         {
        	 retailref.put("Price",doc.getElementsByTagName("RTPrice").item(0).getTextContent()!= null?doc.getElementsByTagName("RTPrice").item(0).getTextContent():"");
         }
         else
         {
        	 retailref.put("Price",0); 
         }
         
         if((doc.getElementsByTagName("RTCurrency").item(0)!= null) &&(doc.getElementsByTagName("RTCurrency").item(0).getTextContent()!=""))
         {
        	 retailref.put("Currency",doc.getElementsByTagName("RTCurrency").item(0).getTextContent()!= null?doc.getElementsByTagName("RTCurrency").item(0).getTextContent():"");
         }
         else
         {
        	 retailref.set("Currency",jsonNode.get("Test")); 
         }
         
         if((doc.getElementsByTagName("RTRound").item(0)!= null) &&(doc.getElementsByTagName("RTRound").item(0).getTextContent()!=""))
         {
        	 retailref.put("Round",doc.getElementsByTagName("RTRound").item(0).getTextContent()!= null?doc.getElementsByTagName("RTRound").item(0).getTextContent():"");
         }
         else
         {
        	 retailref.put("Round",0); 
         }
         
         if((doc.getElementsByTagName("RTValidFrom").item(0)!= null) &&(doc.getElementsByTagName("RTValidFrom").item(0).getTextContent()!=""))
         {
        	 vDateStringFrom=doc.getElementsByTagName("RTValidFrom").item(0).getTextContent();
        	 vYear=vDateStringFrom.substring(0, 4);
        	 vMonth=vDateStringFrom.substring(4, 6);
        	 vDate=vDateStringFrom.substring(6, 8);
        	 vDateStringFrom=vYear+"-"+vMonth+"-"+vDate+"T00:00:00";
        	 retailref.put("ValidFrom", vDateStringFrom);
        	 
        	
         }
         else {
        	 retailref.set("ValidFrom", jsonNode.get("Test"));
         }
         
         if((doc.getElementsByTagName("RTValidTo").item(0)!= null) &&(doc.getElementsByTagName("RTValidTo").item(0).getTextContent()!=""))
         {
        	 vDateStringTo=doc.getElementsByTagName("RTValidTo").item(0).getTextContent();
        	vYear=vDateStringTo.substring(0, 4);
            vMonth=vDateStringTo.substring(4, 6);
        	 vDate=vDateStringTo.substring(6, 8);
        	 vDateStringTo=vYear+"-"+vMonth+"-"+vDate+"T00:00:00";
        	 retailref.put("ValidTo", vDateStringTo);
        	 
        	
         }
         else {
        	 retailref.set("ValidTo", jsonNode.get("Test"));
         }
         
         Retails.add(retailref);
         myObject.set("Retails", Retails);

         
         String vYearFrom="0";
         String vYearTo="0";
         String vYear1="0";
         String vMonth1="0";
         String vDay="0";
         String ValidTo1="0" ;
         String ValidFrom1="0";
         String vDateModelTo="0";
        
         if((doc.getElementsByTagName("ModPack").item(0).getTextContent()!= null) &&(doc.getElementsByTagName("ModPack").item(0).getTextContent()!=""))
         {
        	 YearRef.put("Year",doc.getElementsByTagName("ModPack").item(0).getTextContent()!= null?doc.getElementsByTagName("ModPack").item(0).getTextContent():"");
         }
         else
         {
        	 YearRef.set("Year",jsonNode.get("Test"));
         }
         
         
         if((doc.getElementsByTagName("RTValidFrom").item(0)!= null) &&(doc.getElementsByTagName("RTValidFrom").item(0).getTextContent()!=""))
         {
        	 vYearFrom=doc.getElementsByTagName("RTValidFrom").item(0).getTextContent();
        	 vYear1=vYearFrom.substring(0, 4);
        	 vMonth1=vYearFrom.substring(4, 6);
        	 vDay=vYearFrom.substring(6, 8);
        	 vYearFrom=vYear1+"-"+vMonth1+"-"+vDay+"T00:00:00";
        	 YearRef.put("ValidFrom", vYearFrom);
        	 
        	
         }
         else {
        	 YearRef.set("ValidFrom", jsonNode.get("Test"));
         }
         
         if((doc.getElementsByTagName("RTValidTo").item(0)!= null) &&(doc.getElementsByTagName("RTValidTo").item(0).getTextContent()!=""))
         {
        	 vYearTo=doc.getElementsByTagName("RTValidTo").item(0).getTextContent();
        	vYear1=vYearTo.substring(0, 4);
            vMonth1=vYearTo.substring(4, 6);
            vDay=vYearTo.substring(6, 8);
            vYearTo=vYear1+"-"+vMonth1+"-"+vDay+"T00:00:00";
        	 YearRef.put("ValidTo", vYearTo);
        	 
        	
         }
         else {
        	 YearRef.set("ValidTo", jsonNode.get("Test"));
         }
         
         
          ModelYears.add(YearRef);
          myObject.set("ModelYears", ModelYears);

String jsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(myObject);
        
            return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(jsonData).build();
        }
                         catch (IOException | SAXException e) {
                            e.printStackTrace();
                         } 
                
                return request.createResponseBuilder(HttpStatus.BAD_REQUEST).build();

            }
          }
        
            

                           
        
     {
    
}
