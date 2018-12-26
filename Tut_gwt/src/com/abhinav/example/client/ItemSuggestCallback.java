package com.abhinav.example.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SuggestOracle.Callback;
import com.google.gwt.user.client.ui.SuggestOracle.Request;
import com.google.gwt.user.client.ui.SuggestOracle.Response;

public class ItemSuggestCallback implements AsyncCallback<Response> {

	private Request _request;
	private Callback _callBack;

	public ItemSuggestCallback(Request request, Callback callBack) {
		super();
		this._request = request;
		this._callBack = callBack;
	}

	@Override
	public void onFailure(Throwable caught) {
		_callBack.onSuggestionsReady(_request, new Response());

	}

	@Override
	public void onSuccess(Response result) {
		_callBack.onSuggestionsReady(_request, result);

	}

}
