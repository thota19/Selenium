package sheetdata;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;


public class GoogleSheetData {
	
	public static String spreadsheetId="1kbdOWkivyX_pVtZAGTRbzNukr4O5ls4L5p4xQ7RBP58";
	public static String controllerSheet_range = "Controller!A1:B8";
	public static List<List<Object>> controllerSheetData;
	 private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
	  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	  private static final String TOKENS_DIRECTORY_PATH = "tokens";
	  private static final List<String> SCOPES =
	 Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
	  private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
	  
	  private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
		      throws IOException {
		    // Load client secrets.
		    InputStream in = GoogleSheetData.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
		    if (in == null) {
		      throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
		    }
		    GoogleClientSecrets clientSecrets =
		        GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		    // Build flow and trigger user authorization request.
		    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
		        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
		        .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
		        .setAccessType("offline")
		        .build();
		    LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
		    return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
		  }

	  
	  public static List<List<Object>> DatasheetReader(String range,String spreadsheetId) throws IOException, GeneralSecurityException {
		    // Build a new authorized API client service.
		    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		    Sheets service =
		        new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
		            .setApplicationName(APPLICATION_NAME)
		            .build();
		    ValueRange response = service.spreadsheets().values()
		        .get(spreadsheetId, range)
		        .execute();
		    List<List<Object>> values = response.getValues();
		return values;
		  }
		  
	  
	 public static void main(String[] args) throws Exception, GeneralSecurityException {
		 
		 controllerSheetData = DatasheetReader(controllerSheet_range,spreadsheetId);
		 Iterator<List<Object>> iterator = controllerSheetData.iterator();
		 while(iterator.hasNext()) {
			 List<Object> next = iterator.next();
			 Iterator<Object> iterator2 = next.iterator();
			 while(iterator2.hasNext()) {
				 List<Object> next2 = iterator.next();

				 		for(int i=0;i<next2.size();i++) {
				 			System.out.println(next2.get(i));
				 		}
				 
			 }
		 }
		
		 
	 }
	  
	  
}
