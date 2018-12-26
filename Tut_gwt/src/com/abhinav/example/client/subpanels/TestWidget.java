package com.abhinav.example.client.subpanels;

import com.abhinav.example.client.RpcService;
import com.abhinav.example.shared.FieldVerifier;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestWidget extends Composite {

	FlowPanel panel = new FlowPanel();
	private Button _sendButton;
	private TextBox _nameField;
	private Label _errorLabel;

	private HTML _serverResponseLabel;

	private final RpcService _rpcService;
	private Button _closeButton;
	private DialogBox _dialogBox;

	public TestWidget(RpcService rpcService) {

		_rpcService = rpcService;
		_sendButton = new Button("Send");

		_nameField = new TextBox();
		_nameField.setFocus(true);
		_errorLabel = new Label();

		_serverResponseLabel = new HTML();

		_sendButton.addClickHandler(event -> sendNameToServer());

		_dialogBox = new DialogBox();
		_dialogBox.setText("Remote Procedure Call");
		_dialogBox.setAnimationEnabled(true);
		_closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		_closeButton.getElement().setId("closeButton");

		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));

		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(_serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(_closeButton);

		_closeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				_dialogBox.hide();
				_sendButton.setEnabled(true);
				_sendButton.setFocus(true);
			}
		});
		_dialogBox.setWidget(dialogVPanel);


		panel.add(_nameField);
		panel.add(_sendButton);

		initWidget(panel);
	}

	private void sendNameToServer() {
		_errorLabel.setText("");
		String textToServer = _nameField.getText();
		if (!FieldVerifier.isValidName(textToServer)) {
			_errorLabel.setText("Please enter at least four characters");
			return;
		}

		// Then, we send the input to the server.
		_sendButton.setEnabled(false);
		// _textToServerLabel.setText(textToServer);
		_serverResponseLabel.setText("");

		ServerResponse response = _rpcService.getResponse(textToServer);
		_dialogBox.setText(response.get_labelHeader());

		_serverResponseLabel.setHTML(response.get_response());

		// _rpc.greetServer(textToServer, new AsyncCallback<String>() {
		// @Override
		// public void onFailure(Throwable caught) {
		// // Show the RPC error message to the user
		// _dialogBox.setText(REMOTE_PROCEDURE_CALL_FAILURE);
		//
		// _serverResponseLabel.setHTML(SERVER_ERROR);
		//
		// }
		//
		// @Override
		// public void onSuccess(String result) {
		// _dialogBox.setText(REMOTE_PROCEDURE_CALL_SUCCESS);
		//
		// _serverResponseLabel.setHTML(result);
		//
		// }
		// });

		_dialogBox.center();
		_closeButton.setFocus(true);
		_nameField.setText("");
	}

}
