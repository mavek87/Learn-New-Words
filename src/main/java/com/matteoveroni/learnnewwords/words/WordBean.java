package com.matteoveroni.learnnewwords.words;

import java.util.List;

/**
 *
 * @author Matteo Veroni
 */
public class WordBean {

    private String wordName;
    private String[] translations;

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String[] getTranslations() {
        return translations;
    }

    public void setTranslations(String[] translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        return "ClassPojo [wordName = " + wordName + ", translations = " + translations + "]";
    }
}
