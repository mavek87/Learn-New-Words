package com.matteoveroni.learnnewwords.javafx.controllers;

import com.matteoveroni.learnnewwords.model.WordInsertionModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DemoController implements ModellableDemoController, Initializable {

	private WordInsertionModel model;
	private ObservableList<String> translationsOfDictionary;
	private ListView<String> listView_dictionaryTranslations;

	@FXML
	private AnchorPane paneListview;
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
		List<String> translations = new ArrayList<>();
		translationsOfDictionary = FXCollections.observableArrayList(translations);
		listView_dictionaryTranslations = new ListView<>(translationsOfDictionary);
		listView_dictionaryTranslations.setPrefHeight(100);
		listView_dictionaryTranslations.setItems(translationsOfDictionary);
		paneListview.getChildren().add(listView_dictionaryTranslations);

	}

	@Override
	public void setModel(WordInsertionModel model) {
		this.model = model;
		txt_dictionaryWord.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				populateTranslationsListView();
			}
		});
	}

	private void populateTranslationsListView() {
		if (isStringValidAndNotNull(txt_dictionaryWord.getText()) && model.getDictionary().containsTranslationsForWord(txt_dictionaryWord.getText())) {
			translationsOfDictionary = FXCollections.observableArrayList(model.getDictionary().getTranslationsForWord(txt_dictionaryWord.getText()).getTranslations());
			listView_dictionaryTranslations.setItems(translationsOfDictionary);
		} else {
			listView_dictionaryTranslations.setItems(null);
		}
		listView_dictionaryTranslations.refresh();
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
