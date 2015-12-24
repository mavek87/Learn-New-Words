package com.matteoveroni.learnnewwords.word;

/**
 *
 * @author Matteo Veroni
 */

public class Word {

    private String textName;

    public Word(String textName) {
        this.textName = textName;
    }

    public String getName() {
        return textName;
    }

    public void setName(String textName) {
        this.textName = textName;
    }
}
