package com.matteoveroni.learnnewwords.model.translations;

import com.matteoveroni.learnnewwords.model.gson.GsonSingleton;
import java.util.ArrayList;
import java.util.List;

public class Translations {

	List<String> translations = new ArrayList<>();

	public Translations() {
	}

	public List<String> getTranslations() {
		return translations;
	}

	public int size() {
		return translations.size();
	}

	public boolean isEmpty() {
		return translations.isEmpty();
	}

	public boolean addTranslation(String translation) {
		return translations.add(translation);
	}

	public boolean removeTranslation(String translation) {
		int indexToRemove = searchIndexOfTranslation(translation);
		if (indexToRemove >= 0) {
			return translations.remove(translation);
		}
		return false;
	}

	private int searchIndexOfTranslation(String translation) {
		for (int index = 0; index < translations.size(); index++) {
			if (translations.get(index).equalsIgnoreCase(translation)) {
				return index;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return GsonSingleton.getInstance().toJson(this);
	}
}
