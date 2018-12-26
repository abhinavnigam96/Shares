package com.abhinav.example.client.subpanels;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CustomDialogPanel extends Composite {

	private VerticalPanel _panel;
	private final Button _closeButton;
	private Label _textToServerLabel;
	private HTML _serverResponseLabel;

	public CustomDialogPanel(Button closeButton) {
		_panel = new VerticalPanel();
		_closeButton = closeButton;

		_textToServerLabel = new Label();
		_serverResponseLabel = new HTML();

		_panel.addStyleName("dialogVPanel");
		_panel.add(new HTML("<b>Sending name to the server:</b>"));
		_panel.add(_textToServerLabel);
		_panel.add(new HTML("<br><b>Server replies:</b>"));
		_panel.add(_serverResponseLabel);
		_panel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		_panel.add(_closeButton);

		initWidget(this);
	}

}
