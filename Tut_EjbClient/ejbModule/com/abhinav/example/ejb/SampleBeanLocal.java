package com.abhinav.example.ejb;

import javax.ejb.Local;

@Local
public interface SampleBeanLocal {

	public String getHelloEjb(String name);

}
