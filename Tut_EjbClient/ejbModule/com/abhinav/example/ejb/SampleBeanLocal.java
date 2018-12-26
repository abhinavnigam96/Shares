package com.abhinav.example.ejb;

import java.util.Set;

import javax.ejb.Local;

@Local
public interface SampleBeanLocal {

	public String getHelloEjb(String name);

	public Set<String> getFirstNameSuggestions(String root);
}
