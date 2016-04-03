package com.matteoveroni.learnnewwords;

import com.matteoveroni.learnnewwords.javafx.controllers.ModellableDemoController;
import com.matteoveroni.learnnewwords.javafx.localization.ResourceBundleManager;
import com.matteoveroni.learnnewwords.javafx.localization.exceptions.ResourceBundleForThisLocaleDoesntExistException;
import com.matteoveroni.learnnewwords.model.dictionary.Dictionary;
import java.io.IOException;
import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Matteo Veroni
 * @version 0.0.1
 *
 * <b> Author Web Sites: </b>
 * <br/><a href="http://www.matteoveroni.com">www.matteoveroni.com</a>
 * <br/><a href="http://www.infoeinternet.com">www.infoeinternet.com</a>
 */
public class MainApp extends Application {

	private static final String APPLICATION_NAME = "Learn New Words";
	private static final String APPLICATION_VERSION = "0.0.1";

	@Override
	public void start(Stage stage) throws ResourceBundleForThisLocaleDoesntExistException, IOException {
		ResourceBundleManager resourceBundleManager = new ResourceBundleManager();
		Dictionary dictionary = new Dictionary(Locale.ENGLISH, Locale.ITALIAN);

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Demo.fxml"));
			fxmlLoader.setResources(resourceBundleManager.getResourceBundle());
			Parent root = fxmlLoader.load();
			ModellableDemoController demoController = fxmlLoader.getController();
			demoController.setModel(dictionary);
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");
			stage.setTitle(APPLICATION_NAME + " | v." + APPLICATION_VERSION);
			stage.setScene(scene);
			stage.show();
		} catch (ResourceBundleForThisLocaleDoesntExistException | IOException ex) {
			throw new RuntimeException(ex);
		}
//            performGsonTest();
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

//    private void performGsonTest() {
//
//        try {
////            String translationOfDog1 = "dog";
////
////            Word wordCane = new Word();
////            wordCane.setWord("cane");
////            wordCane.addTranslation(translationOfDog1);
//
//            Dictionary englishItalianDictionary = new Dictionary();
//            englishItalianDictionary.setLanguageOfTheDictionary(new Locale("en", "EN"));
//            englishItalianDictionary.setLanguageOfTranslations(new Locale("it", "IT"));
//
//            // I create a english word 'allow'
//            String englishWordAllow = "allow";
//
//            // Creating two italian words: 'consentire' and 'permettere'
//            String italianWordConsentire = "consentire";
//            String italianWordPermettere = "permettere";
//
//            // Putting the two italian words created into the class translations for allow
//            Translations italianTranslationsForEnglishWordAllow = new Translations();
//            List<String> listOfItalianTranslationsForEnglishWordAllow = new ArrayList<>();
//            listOfItalianTranslationsForEnglishWordAllow.add(italianWordConsentire);
//            listOfItalianTranslationsForEnglishWordAllow.add(italianWordPermettere);
//            italianTranslationsForEnglishWordAllow.setTranslations(listOfItalianTranslationsForEnglishWordAllow);
//            
//            // Putting the translations into the english-italian dictionary
//            Map<String, Translations> mapOfDictionaryElements = new HashMap<>();
//            mapOfDictionaryElements.put(englishWordAllow, italianTranslationsForEnglishWordAllow);
//            englishItalianDictionary.setTranslations(mapOfDictionaryElements);
//           
//            GsonBuilder builder = new GsonBuilder();
//            Gson gson = builder.create();
//
//            System.out.println(gson.toJson(englishItalianDictionary));
//
//            Dictionary d = new Dictionary();
//            d = gson.fromJson(gson.toJson(englishItalianDictionary), Dictionary.class);
//            
//            
//            BufferedReader jsonResourceReader
//                = new BufferedReader(
//                    new InputStreamReader(getClass().getResource("/persistence/italian-english.json").openConnection().getInputStream()
//                    )
//                );
//
//            Dictionary italian_englishReader = gson.fromJson(jsonResourceReader, Dictionary.class);
//            
////            for (String wordInTheDictionary : italian_englishReader.getTranslations().keySet()) {
////                System.out.println("Word -> " + wordInTheDictionary);
////                for (String translation : italian_englishReader.getTranslationsOfWord(wordInTheDictionary).getTranslations()) {
////                    System.out.println("\tTranslation ->" + translation);
////                }
////            }
//
//        } catch (IOException | JsonSyntaxException | JsonIOException ex) {
//            ex.printStackTrace();
//        }
//    }
}
