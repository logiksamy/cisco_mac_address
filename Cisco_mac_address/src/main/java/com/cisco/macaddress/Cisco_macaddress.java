package com.cisco.macaddress;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.cisco.common.getEnv;


@SpringBootApplication
public class Cisco_macaddress {
	
	 public static void main(String[] args) {
	        
		 	if (args != null && args.length != 1)
		 	{
		 		System.out.println("Please enter MAC Address. The application requires 1 argument.");
		 		System.exit(0);
		 	}
	        
	        String lowercase_macadress = args[0];
	       
	        validate_macaddress(lowercase_macadress.toLowerCase());
	        
	        try
	        {
	        	invoke_macaddress_api(lowercase_macadress.toLowerCase());
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	        
	    }
	 
	 static void validate_macaddress(String macadress)
	 {
		 if ( macadress.matches( "[0-9a-f]{2}([-:])[0-9a-f]{2}(\\1[0-9a-f]{2}){4}$"))

			 System.out.println("Its a valid " + macadress);

	    else

	    	System.out.println("The Mac_Add is invalid : " + macadress );

	 }
	 
	 static void invoke_macaddress_api(String mac_address) throws IOException
	 {

		    String api_url = "https://api.macaddress.io/v1?output=json&search=" + mac_address;
		    
		    URL url = new URL(api_url);
		    
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-Authentication-Token", getEnv.envs.get("MAC_API_KEY"));

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed with HTTP error code : "
						+ conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Response from MAC address API... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
			
	}

}
