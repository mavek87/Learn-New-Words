package com.matteoveroni.learnnewwords.model.dictionary;

import com.matteoveroni.learnnewwords.model.translations.Translations;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Dictionary {

	private final Locale dictionaryLanguage;
	private final Locale translationsLanguage;
	private final Map<String, Translations> dictionaryMap = new HashMap<>();

	public Dictionary(Locale dictionaryLanguage, Locale translationsLanguage) {
		this.dictionaryLanguage = dictionaryLanguage;
		this.translationsLanguage = translationsLanguage;
	}

	public void createWordAndTranslations(String word, Translations translations) {
		dictionaryMap.put(word, translations);
	}

	public void removeWordAndTranslations(String word) {
		dictionaryMap.remove(word);
	}

	public Translations getTranslationsForWord(String word) {
		return dictionaryMap.get(word);
	}

	public void replaceTranslationsForWord(String word, Translations translations) {
		dictionaryMap.replace(word, translations);
	}

	@Override
	public String toString() {
		return "Dictionary{" + "dictionaryLanguage=" + dictionaryLanguage + ", translationsLanguage=" + translationsLanguage + ", dictionaryMap=" + dictionaryMap + '}';
	}
	
	

}
