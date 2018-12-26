package com.abhinav.example.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SuggestOracle.Request;
import com.google.gwt.user.client.ui.SuggestOracle.Response;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input,
	                 AsyncCallback<String> callback) throws IllegalArgumentException;

	void getSuggestion(Request request, AsyncCallback<Response> callback);
}
