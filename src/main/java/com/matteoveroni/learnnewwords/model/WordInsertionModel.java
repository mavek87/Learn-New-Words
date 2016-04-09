package com.matteoveroni.learnnewwords.model;

import com.matteoveroni.learnnewwords.model.dictionary.Dictionary;

public class WordInsertionModel {

	private Dictionary dictionary;

	public WordInsertionModel(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
}
