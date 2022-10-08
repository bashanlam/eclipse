package kai;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;


//import org.json.simple.*;  
//import org.json.simple.parser.*; 

//import org.json.JSONArray;
//import org.json.JSONObject;


public class HelloWorld {

	public static String getPhoneNumbers (String country, String phoneNumber) {
		String ret = "-1";
		try {
			    String link = "https://jsonmock.hackerrank.com/api/countries?name="+country;
			    URL url = new URL(link);
			    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			    conn.setRequestMethod("GET");

			    int responseCode = conn.getResponseCode();
					if (responseCode == 200) {
					    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
					    String output;
					    String totalString = "" ;
					    while ((output = br.readLine()) != null) {
					    totalString += output;
					    }
					    System.out.println(totalString);
		
		
					    com.google.gson.JsonObject jsonObject = new JsonParser().parse(totalString).getAsJsonObject();
				    String fajr = jsonObject.getAsJsonArray("data").toString();
					    System.out.println(fajr);

		                Iterator<JsonElement> iter = jsonObject.getAsJsonArray("data").iterator();
		                while (iter.hasNext()) {
//		                	System.out.println("Data->callingCodes:"+ iter.next().getAsJsonObject().getAsJsonArray("callingCodes").iterator().next().getAsString());
			                Iterator<JsonElement> iterData = iter.next().getAsJsonObject().getAsJsonArray("callingCodes").iterator();

//		                	ret = iter.next().getAsJsonObject().getAsJsonArray("callingCodes").iterator().next().getAsString();
			                if (iterData.hasNext()){
//			                	ret = iterData.next().getAsString();
			        			ret = "+" + iterData.next().getAsString() + " " + phoneNumber;

			                } else {
			                	ret = "-1";
			                }
//		                	ret = iter.next().getAsJsonObject().getAsJsonArray("callingCodes").iterator().next().getAsString();
		                	System.out.println("Data->callingCodes:"+ ret);
		                }
					}
			    }
			    catch(Exception e) 
			    {
			    e.printStackTrace();
			    }		
			return ret;
		}
	
	public static void fizzBuzz(int n) {
		if (n<(int) Math.pow(2, 10)){
			if ((n%3==0) & (n%5==0)){
				System.out.println("FizzBuzz");	
			}
			if ((n%3==0) & (n%5!=0)){
				System.out.println("Fizz");	
			}
			if ((n%3!=0) & (n%5==0)){
				System.out.println("Buzz");	
			}
			if ((n%3!=0) & (n%5!=0)){
				System.out.println(n);	
			}
		}
	}
	

	public static void gcTest() {
	    Object a = new Object();

System.out.println("Start gcTest");
	    List< Object > b = new ArrayList< Object >();
	    b.add( a );


	    String c = a.toString();


	    a = null;
	    b = null;
	    c = null;
	   // System.gc(); // p1 will be garbage-collected
	   Runtime.getRuntime().gc();
	    System.out.println("End gcTest");

	}

	
	public static List<List<Long>> smashTheBricks(int bigHits, List<Integer> newtons) {
		if((bigHits <0)||(bigHits > 2 *( (10)^5) )) return null;
		if((newtons.size() <0)||(newtons.size() > 2 *( (10)^5) )) return null;
		if(!(newtons.stream().allMatch(new HashSet<>()::add))) return null;
		double max = Math. pow(10, 9);
		Iterator<Integer> allIterator = newtons.iterator();
		while(allIterator.hasNext()){
			double a = (double) allIterator.next();
			if ((a < 1)||(a > max)) return null;
		}
		
		List<Integer> newtonsOrg = new ArrayList<>(newtons);
		Collections.sort(newtons);
		newtons.sort((o1,o2) -> {return (o2-o1);});
		if (bigHits >= newtons.size()) bigHits = newtons.size();
		List<Long> bigHitArr = new ArrayList<>();
		if (bigHits == 0) bigHitArr.add((long)(-1));		
		Iterator<Integer> bigIterator = newtons.subList(0, bigHits).iterator();
		while(bigIterator.hasNext()){
			long bigHit = (long) bigIterator.next();
			bigHitArr.add((long)(newtonsOrg.indexOf((int)bigHit)+1));
		}
		int smallHit = 0;
		List<Long> smallHitArr = new ArrayList<>();
		if (bigHits >= newtons.size()) {
			smallHitArr.add((long)(-1));
		} else {
			Iterator<Integer> iterator = newtons.subList(bigHits, newtons.size()).iterator();
			while(iterator.hasNext()){
				int i = (int) iterator.next();
				smallHit = smallHit +i;
				smallHitArr.add((long)(newtonsOrg.indexOf((int)i)+1));
			}
		}
		List<Long> totalHit = new ArrayList<>();
		totalHit.add((long)(bigHits+smallHit));
		List<List<Long>> result = new ArrayList<>();
		Collections.sort(bigHitArr);
		Collections.sort(smallHitArr);
		result.add(totalHit);
		result.add(bigHitArr);
		result.add(smallHitArr);
		return result;
    }
	
	/* 
	 * public static String getPhoneNumbersOLD (String country, String phoneNumber) {
	 
		HttpURLConnection conn = null;
		BufferedReader reader;
		String line;
		String ret = "";
		StringBuilder responseContent = new StringBuilder();
		try{
			URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name="+country);
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);// 5000 milliseconds = 5 seconds
			conn.setReadTimeout(5000);
			
			int status = conn.getResponseCode();
			
			if (status >= 300) {
				reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			else {
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}			
			
			JSONArray array = new JSONArray("["+responseContent.toString()+"]");  
			for(int i=0; i < array.length(); i++)   
			{  
				JSONObject object = array.getJSONObject(i);  
				//System.out.println(object.toString());  
				JSONArray arrData = object.getJSONArray("data");  
				if (object.getJSONArray("data").length() < 1) return "-1";
				JSONObject objData = arrData.getJSONObject(0);  

				
				//for(int j = 0; j<objData.names().length(); j++){
					System.out.println("key = " + objData.names().getString(j) + " value = " + objData.get(objData.names().getString(j)));
				//}
				//
				//System.out.println("callingCodes:" + objData.get("callingCodes"));
				//System.out.println("callingCodes:" + objData.getJSONArray("callingCodes").toString());
				JSONArray arrCC = objData.getJSONArray("callingCodes"); 
				//System.out.println("callingCodes1:" + arrCC.getString(0));  
				if (arrCC.length()>0) {
					ret = "+" + arrCC.getString(0) + " " + phoneNumber;
				} else {
					ret = "+ " + phoneNumber;
				}
			}  
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			conn.disconnect();
		}
		return ret;
    }
    
    
    	public static String parse(String responseBody) {
		JSONArray albums = new JSONArray(responseBody);
		for (int i = 0 ; i < albums.length(); i++) {
			JSONObject album = albums.getJSONObject(i);			
			String name = album.getString("name");
			String callingCodes = album.getString("callingCodes");
			System.out.println(name+":"+callingCodes);
		}
		return null;
	}

    */

	public static void main(String[] args) {
		gcTest();
		/* List<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(10);
        al.add(20);
        // 10 is present at index 3.
        int index = Collections.binarySearch(al, 10);
        System.out.println(index);
  
        // 13 is not present. 13 would have been inserted
        // at position 4. So the function returns (-4-1)
        // which is -5.
        index = Collections.binarySearch(al, 13);
        System.out.println(index);
  		*/
        
		/*String ret ="";
		ret = getPhoneNumbers("Puerto Rico", "656445423");
		System.out.println("Result: "+ret);

		fizzBuzz(15);
		//fizzBuzz(9);
		//fizzBuzz(55);
		//fizzBuzz(11);
		for (int i = 0; i < 16; i++) {
			fizzBuzz(i);
			}		//		System.out.println("Hello world!");	

		fizzBuzz((int) Math.pow(2, 10)*2); */
		
		 
		/* List<Integer> ints = new ArrayList<>();
		
		ints.add(10000000);
		ints.add(100000000);
		ints.add(1000000000);
		ints.add(2);
		ints.add(5);
		ints.add(8);
		ints.add(7);
		ints.add(6);

		List<List<Long>> ret = smashTheBricks(-1, ints);
		System.out.println("Result: "+ret);
		*/
	}

}
