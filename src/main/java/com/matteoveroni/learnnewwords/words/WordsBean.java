package com.matteoveroni.learnnewwords.words;

/**
 *
 * @author Matteo Veroni
 */
public class WordsBean {

    private WordBean[] words;

    public WordBean[] getWords() {
        return words;
    }

    public void setWords(WordBean[] words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "ClassPojo [words = " + words + "]";
    }
}
