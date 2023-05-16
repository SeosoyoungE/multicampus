package test.json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

public class JSONMakerExam {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		JSONObject myjson2=new JSONObject();
		myjson2.put("name", "김서연");
		myjson2.put("age", "25");
		
		JSONArray subJsonArr=new JSONArray();
		subJsonArr.add("자바");
		subJsonArr.add("하둡");
		subJsonArr.add("시큐어코딩");
		myjson2.put("subject",subJsonArr);
		
		JSONObject addJson =new JSONObject();
		addJson.put("Zip", "111-222");
		addJson.put("addr1", "인천시");
		myjson2.put("addr", addJson);
		
		JSONObject hisJson1 =new JSONObject();
		JSONObject hisJson2 =new JSONObject();
		hisJson1.put("subject", "java");
		hisJson1.put("month", "11");
		hisJson2.put("subject", "servlet");
		hisJson2.put("month", "12");
		JSONArray hisJsonArr=new JSONArray();
		hisJsonArr.add(hisJson1);
		hisJsonArr.add(hisJson2);
		myjson2.put("history", hisJsonArr);
		
		System.out.println(myjson2);
		FileWriter fw=new FileWriter("src/main/java/test/json/myjson2.json");
		fw.write(myjson2.toJSONString());
		fw.flush();
		fw.close();
	}

}
