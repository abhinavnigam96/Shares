package com.abhinav.example.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

public class ItemSuggestion implements IsSerializable, Suggestion {
	private String _suggestionString;

	public ItemSuggestion() {

		_suggestionString = null;
	}

	public ItemSuggestion(String suggestionString) {

		this._suggestionString = suggestionString;
	}

	@Override
	public String getDisplayString() {

		return _suggestionString;
	}

	@Override
	public String getReplacementString() {

		return _suggestionString;
	}

}
