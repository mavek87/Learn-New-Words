package com.matteoveroni.learnnewwords.words;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matteo Veroni
 */
public class Words {

    private List<Word> words = new ArrayList<>();

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public void addWord(Word word) {
        words.add(word);
    }

    @Override
    public String toString() {
        return "ClassPojo [words = " + words + "]";
    }
}
