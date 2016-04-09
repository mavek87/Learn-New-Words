package com.matteoveroni.learnnewwords;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.matteoveroni.learnnewwords.javafx.controllers.ModellableDemoController;
import com.matteoveroni.learnnewwords.javafx.localization.ResourceBundleManager;
import com.matteoveroni.learnnewwords.javafx.localization.exceptions.ResourceBundleForThisLocaleDoesntExistException;
import com.matteoveroni.learnnewwords.model.WordInsertionModel;
import com.matteoveroni.learnnewwords.model.dictionary.Dictionary;
import com.matteoveroni.learnnewwords.model.gson.GsonSingleton;
import com.matteoveroni.learnnewwords.model.translations.Translations;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Matteo Veroni
 * @version 0.0.2
 *
 * <b> Author Web Sites: </b>
 * <br/><a href="http://www.matteoveroni.com">www.matteoveroni.com</a>
 * <br/><a href="http://www.infoeinternet.com">www.infoeinternet.com</a>
 */
public class MainApp extends Application {

	private static final String APPLICATION_NAME = "Learn New Words";
	private static final String APPLICATION_VERSION = "0.0.2";

	@Override
	public void start(Stage stage) throws ResourceBundleForThisLocaleDoesntExistException, IOException {
		ResourceBundleManager resourceBundleManager = new ResourceBundleManager();
		Dictionary dictionary = new Dictionary(Locale.ENGLISH, Locale.ITALIAN);
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Demo.fxml"));
			fxmlLoader.setResources(resourceBundleManager.getResourceBundle());
			Parent root = fxmlLoader.load();
			ModellableDemoController demoController = fxmlLoader.getController();
			
			Translations translationsWord = new Translations();
			translationsWord.addTranslation("parola");
			dictionary.createWordAndTranslations("word", translationsWord);

			Translations translationsSee = new Translations();
			translationsSee.addTranslation("visto");
			translationsSee.addTranslation("vedere");
			dictionary.createWordAndTranslations("see", translationsSee);
			
			WordInsertionModel modelWordInsertion = new WordInsertionModel(dictionary);
			demoController.setModel(modelWordInsertion);
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");
			stage.setTitle(APPLICATION_NAME + " | v." + APPLICATION_VERSION);
			stage.setScene(scene);
			stage.show();
		} catch (ResourceBundleForThisLocaleDoesntExistException | IOException ex) {
			throw new RuntimeException(ex);
		}
		performGsonTest();
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be
	 * launched through deployment artifacts, e.g., in IDEs with limited FX
	 * support. NetBeans ignores main().
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	private void performGsonTest() {
		try {
			Dictionary englishItalianDictionary = new Dictionary(Locale.ENGLISH, Locale.ITALIAN);

			// Putting the two italian words created into the class translations for allow
			Translations translationWordAllow = new Translations();
			translationWordAllow.addTranslation("permettere");
			translationWordAllow.addTranslation("consentire");

			// Putting the translations into the english-italian dictionary
			englishItalianDictionary.createWordAndTranslations("allow", translationWordAllow);

			System.out.println(englishItalianDictionary);

			BufferedReader jsonResourceReader
				= new BufferedReader(
					new InputStreamReader(getClass().getResource("/persistence/italian-english.json").openConnection().getInputStream()
					)
				);

			Dictionary italian_englishReader = GsonSingleton.getInstance().fromJson(jsonResourceReader, Dictionary.class);
			System.out.println(italian_englishReader);

		} catch (IOException | JsonSyntaxException | JsonIOException ex) {
			ex.printStackTrace();
		}
	}
}
