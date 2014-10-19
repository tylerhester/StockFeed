package com.bloomberglp.blpapi;

import java.util.ArrayList;
import java.util.logging.Level;

import com.bloomberglp.blpapi.Datetime;
import com.bloomberglp.blpapi.Event;
import com.bloomberglp.blpapi.Element;
import com.bloomberglp.blpapi.InvalidRequestException;
import com.bloomberglp.blpapi.Logging;
import com.bloomberglp.blpapi.Message;
import com.bloomberglp.blpapi.MessageIterator;
import com.bloomberglp.blpapi.Name;
import com.bloomberglp.blpapi.Request;
import com.bloomberglp.blpapi.Service;
import com.bloomberglp.blpapi.Session;
import com.bloomberglp.blpapi.SessionOptions;

public class GetData {
	private String IP_ADDRESS;
	private int PORT;
	private ArrayList<String> d_securities;
	private ArrayList<String> field;
        
    public GetData() {
        IP_ADDRESS = "10.8.8.1";
        PORT = 8194;
        d_securities.add("MSFT US Equity");
        field.add("DS002");
    }
        
	public static void main(String args[]) throws Exception {
		GetData app = new GetData();
		app.run();
	}

	private void run() throws Exception {
		SessionOptions sessionOptions = new SessionOptions();
		sessionOptions.setServerHost(IP_ADDRESS);
		sessionOptions.setServerPort(PORT);

		System.out.println("Connecting to " + IP_ADDRESS + ":" + PORT);
		Session session = new Session(sessionOptions);
		if(!session.start()) {
			System.err.println("Failed to start session.");
			return;
		}
		if(!session.openService("//blp/refdata")) {
			System.err.println("Failed to open //blp/refdata");
			return;
		}

		System.out.println("SUCCESS MOTHERFUCKER!");

		// Session session = new Session ?
	}

}