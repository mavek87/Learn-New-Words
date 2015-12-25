package com.matteoveroni.learnnewwords.words;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matteo Veroni
 */
public class Word {

    private String wordName;
    private List<String> translations = new ArrayList<>();

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }

    public void addTranslation(String translation) {
        this.translations.add(translation);
    }

    @Override
    public String toString() {
        return "ClassPojo [wordName = " + wordName + ", translations = " + translations + "]";
    }
}
