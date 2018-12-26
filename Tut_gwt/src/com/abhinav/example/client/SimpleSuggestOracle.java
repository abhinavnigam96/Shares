package com.abhinav.example.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.SuggestOracle;

public class SimpleSuggestOracle extends SuggestOracle {

	private final GreetingServiceAsync _service = GWT.create(GreetingService.class);
	@Override
	public void requestSuggestions(Request request, Callback callback) {
		_service.getSuggestion(request, new ItemSuggestCallback(request, callback));
	}

}
