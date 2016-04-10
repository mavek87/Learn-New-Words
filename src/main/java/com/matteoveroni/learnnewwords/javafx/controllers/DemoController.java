package com.matteoveroni.learnnewwords.javafx.controllers;

import com.matteoveroni.learnnewwords.model.WordInsertionModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class DemoController implements ModellableDemoController, Initializable {

	private WordInsertionModel model;
	private ObservableList<String> observableTranslationsOfDictionary;
	private ListView<String> listView_translationsOfdictionary;

	@FXML
	private BorderPane paneListview;
	@FXML
	private TextField txt_dictionaryWord;
	@FXML
	private TextField txt_dictionaryTranslation;
	@FXML
	private Button btn_addWord;
	@FXML
	private Button btn_addDictionaryTranslation;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		observableTranslationsOfDictionary = FXCollections.observableArrayList(new ArrayList<>());
		listView_translationsOfdictionary = new ListView<>(observableTranslationsOfDictionary);
		listView_translationsOfdictionary.setPrefHeight(100);
		listView_translationsOfdictionary.setItems(observableTranslationsOfDictionary);
		paneListview.setCenter(listView_translationsOfdictionary);
	}

	@Override
	public void setModel(WordInsertionModel model) {
		this.model = model;
		txt_dictionaryWord.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
			if (populateTranslationsListView()) {
				txt_dictionaryWord.setStyle("-fx-font-weight:bold;");
			} else {
				txt_dictionaryWord.setStyle("");
			}
		});
	}

	private boolean populateTranslationsListView() {
		boolean isListViewPopulated;
		if (isStringValidAndNotNull(txt_dictionaryWord.getText()) && model.getDictionary().containsTranslationsForWord(txt_dictionaryWord.getText())) {
			observableTranslationsOfDictionary = FXCollections.observableArrayList(model.getDictionary().getTranslationsForWord(txt_dictionaryWord.getText()).getTranslations());
			listView_translationsOfdictionary.setItems(observableTranslationsOfDictionary);
			isListViewPopulated = true;
		} else {
			listView_translationsOfdictionary.setItems(null);
			isListViewPopulated = false;
		}
		listView_translationsOfdictionary.refresh();
		return isListViewPopulated;
	}

	private boolean isStringValidAndNotNull(String string) {
		return string != null && !string.trim().isEmpty();
	}

	@FXML
	void saveNewDictionaryWord(ActionEvent event) {
//		if (!txt_dictionaryWord.getText().trim().isEmpty() && !listOfTranslation.isEmpty()) {
//
//		}
//
//		if (translations != null && !translations.isEmpty()) {
//			dictionary.createWordAndTranslations(txt_dictionaryWord.getText(), translations);
//			System.out.println("Dictionary updated: \n" + dictionary);
//		} else {
//			System.out.println("Error");
//		}
	}

	@FXML
	void addDictionaryTranslation(ActionEvent event) {
//		if(txt_dictionaryTranslation.getTe)
//		for (int index = 0; index < list_dictionaryTranslations.getItems().size(); index++) {
//			if (index == 0) {
//				translations = new Translations(list_dictionaryTranslations.getItems().get(0));
//			} else {
//				translations.addTranslation(list_dictionaryTranslations.getItems().get(index));
//			}
//		}
	}

}
