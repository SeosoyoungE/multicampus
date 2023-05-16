package test.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParserExam {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser=new JSONParser();
		JSONObject root=(JSONObject)parser.parse(new FileReader("src/main/java/test/json/myjson2.json"));
		
		String name=(String)root.get("name");
		System.out.println("name: "+name);
		String age=(String)root.get("age");
		System.out.println("age: "+age);
		
		JSONArray subjsonarr=(JSONArray) root.get("subject");
		for(int i=0;i<subjsonarr.size();i++) {
			String subject=(String)subjsonarr.get(i);
			System.out.println("subject: "+subject);
		}
		
		JSONArray hisJsonArray =(JSONArray)root.get("history");
		for(int i=0;i<hisJsonArray.size();i++) {
			JSONObject hisjson=(JSONObject)hisJsonArray.get(i);
			String month=(String)hisjson.get("month");
			System.out.println("month: "+month);
			String subject=(String)hisjson.get("subject");
			System.out.println("subject: "+subject);
		}
		
		JSONObject addr=(JSONObject)root.get("addr");
		String zip=(String)addr.get("Zip");
		System.out.println("zip: "+zip);
		String addr1=(String)addr.get("addr1");
		System.out.println("addr1: "+addr1);
	}
}
