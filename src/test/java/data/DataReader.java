package data;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	//This code is common and hence, shifted into BaseTest
	
//	public List<HashMap<String, String>> getjsonDatatoMap(String filepath) throws IOException {
//		
//		
//		//jackson-databind Maven Dependency is required to support FileUtils
//		
//		//Read the json to string
//		
//		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "\\src\\test\\java\\data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
//		
//		//
//		ObjectMapper mapper = new ObjectMapper();
//		
//		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
//		return data;
//	}
//	

}
