package com;

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

@SuppressWarnings("unused")
public class GetData {
	private String IP_ADDRESS;
	private int PORT;
	private ArrayList<String> d_securities;
	private ArrayList<String> d_fields;
        
    public GetData() {
        IP_ADDRESS = "10.8.8.1";
        PORT = 8194;
        d_securities = new ArrayList<String>();
        d_securities.add("MSFT US Equity");
        d_fields = new ArrayList<String>();
        d_fields.add("DS002");
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
		 
		 try {
			 sendRefDataRequest(session);
		 } catch (InvalidRequestException e) {
			 e.printStackTrace();
		 }
		 
		 // wait for events from session
		 eventLoop(session);
		 
		 session.stop();
		 System.out.println("SUCCESS MOTHERFUCKER!");

	}
	
	private void eventLoop(Session session) throws Exception {
		boolean done = false;
		while(!done) {
			Event event = session.nextEvent();
			if(event.eventType() == Event.EventType.PARTIAL_RESPONSE) {
				System.out.println("Processing Partial Response");
				//processResponseEvent(event);
			} else if(event.eventType() == Event.EventType.RESPONSE) {
				System.out.println("Processing Response");
				//processResponseEvent(event);
				done = true;
			} else {
				MessageIterator msgIter = event.messageIterator();
				while(msgIter.hasNext()) {
					Message msg = msgIter.next();
					System.out.println(msg.asElement());
					if(event.eventType() == Event.EventType.SESSION_STATUS) {
						if(msg.messageType().equals("Session Terminated") || msg.messageType().equals("SessionStartupFailure")) {
							done = true;
						}
					}
				}
			}
		}
	}
	
	private void sendRefDataRequest(Session session) throws Exception {
		Service refDataService = session.getService("//blp/refdata");
		Request request = refDataService.createRequest("ReferenceDataRequest");
		
		//add securities to request
		Element securities = request.getElement("securities");
		for(String security : d_securities) {
			securities.appendValue(security);
		}
		
		//add securities to request
		Element fields = request.getElement("fields");
		for(String field : d_fields) {
			fields.appendValue(field);
		}
		
		System.out.println("Sending Request: " + request);
		session.sendRequest(request, null);
	}

}