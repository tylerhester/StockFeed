private static void handleResponseEvent(Event event) throws Exception 
{
 System.out.println("EventType =" + event.eventType());
 MessageIterator iter = event.messageIterator();
 while (iter.hasNext()) {
 	Message message = iter.next();
 	System.out.println("correlationID=" + message.correlationID());
 	System.out.println("messageType =" + message.messageType());
 	message.print(System.out);
 	}
 }