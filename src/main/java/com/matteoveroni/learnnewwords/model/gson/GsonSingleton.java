package com.matteoveroni.learnnewwords.model.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Matteo Veroni
 */
public class GsonSingleton {

	private static final GsonBuilder builder = new GsonBuilder();
	private volatile static Gson uniqueGsonInstance;

	private GsonSingleton() {
	}

	public static Gson getInstance() {
		if (uniqueGsonInstance == null) {
			synchronized (GsonSingleton.class) {
				if (uniqueGsonInstance == null) {
					uniqueGsonInstance = builder.create();
				}
			}
		}
		return uniqueGsonInstance;
	}
}
