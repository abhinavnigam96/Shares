package com.abhinav.example.server;

import java.util.ArrayList;
import java.util.Set;

import javax.ejb.EJB;

import com.abhinav.example.client.GreetingService;
import com.abhinav.example.ejb.SampleBeanLocal;
import com.abhinav.example.shared.FieldVerifier;
import com.abhinav.example.shared.ItemSuggestion;
import com.google.gwt.user.client.ui.SuggestOracle.Request;
import com.google.gwt.user.client.ui.SuggestOracle.Response;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	@EJB
	private SampleBeanLocal _sampleBean;

	@Override
	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {

			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		_sampleBean.getHelloEjb(input);
		return "Hello, " + input + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>"
		+ userAgent;
	}

	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}

	@Override
	public Response getSuggestion(Request request) {
		Response response = new Response();
		String query = request.getQuery();

		Set<String> firstNameSuggestions = _sampleBean.getFirstNameSuggestions(query);
		ArrayList<ItemSuggestion> suggestions = new ArrayList<>();
		for (String name : firstNameSuggestions) {

			ItemSuggestion suggestion = new ItemSuggestion(name);
			suggestions.add(suggestion);
		}
		response.setSuggestions(suggestions);
		return response;
	}
}
