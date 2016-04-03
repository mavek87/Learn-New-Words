package com.matteoveroni.learnnewwords.javafx.controllers;

import com.matteoveroni.learnnewwords.model.dictionary.Dictionary;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DemoController implements ModellableDemoController, Initializable {

    private Dictionary dictionary;
//    private Translations translations = new Translations();
    
    @FXML
    private ListView<?> list_dictionaryTranslations;

    @FXML
    private TextField txt_dictionaryWord;

    @FXML
    private TextArea txt_dictionaryTranslation;

    @FXML
    private Button btn_addWord;

    @FXML
    private Button btn_addDictionaryTranslation;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setModel(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @FXML
    void saveNewDictionaryWord(ActionEvent event) {
//        newWord.setName(txt_dictionaryWord.getText());
//        dictionary.putElement(newWord, translations);
//        
//        for(Word dictionaryElement : dictionary.getDictionaryElements().keySet()){
//            System.out.println("Dictionary Element: " + dictionaryElement);
//            for(Word translationForThisElement : dictionary.getTranslationsOfWord(dictionaryElement).getAllTranslations()){
//                System.out.println("translation " + translationForThisElement);
//            }
//        }
        
    }

    @FXML
    void addDictionaryTranslation(ActionEvent event) {
//        translations.addNewTranslation(new Word(txt_dictionaryTranslation.getText()));
    }

}
