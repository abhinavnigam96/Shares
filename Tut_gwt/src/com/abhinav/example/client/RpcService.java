package com.abhinav.example.client;

import java.util.List;

import com.abhinav.example.client.subpanels.ServerResponse;

public interface RpcService {

	ServerResponse getResponse(String input);

	List<String> getAllNames();

}
