package com.fyg.cuadrillas.controlador;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ManejaJSON {
	
	public JSONObject recibeJSON(String json){
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Object obj = parser.parse(json);
			jsonObject = (JSONObject) obj;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return jsonObject;
	}
}
