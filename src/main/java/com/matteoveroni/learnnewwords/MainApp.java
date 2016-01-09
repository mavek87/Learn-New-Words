package com.matteoveroni.learnnewwords;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.matteoveroni.learnnewwords.localization.ResourceBundleManager;
import com.matteoveroni.learnnewwords.localization.exceptions.ResourceBundleForThisLocaleDoesntExistException;
import com.matteoveroni.learnnewwords.words.Word;
import com.matteoveroni.learnnewwords.words.Words;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
    public void start(Stage stage) {
        ResourceBundleManager resourceBundleManager = new ResourceBundleManager();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"), resourceBundleManager.getResourceBundle());
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            stage.setTitle(APPLICATION_NAME + " | v." + APPLICATION_VERSION);
            stage.setScene(scene);
            stage.show();
            performGsonTest();
        } catch (ResourceBundleForThisLocaleDoesntExistException | IOException ex) {
            throw new RuntimeException();
        }
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
            String translationOfDog1 = "dog";

            Word wordCane = new Word();
            wordCane.setWordName("cane");
            wordCane.addTranslation(translationOfDog1);

            Words italianWords = new Words();
            italianWords.addWord(wordCane);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            System.out.println(gson.toJson(italianWords));

            BufferedReader jsonResourceReader
                = new BufferedReader(
                    new InputStreamReader(getClass().getResource("/persistence/italian-english.json").openConnection().getInputStream()
                    )
                );

            Words italian_englishReader = gson.fromJson(jsonResourceReader, Words.class);

            for (Word word : italian_englishReader.getWords()) {
                System.out.println("Word -> " + word.getWordName());
                for (String translation : word.getTranslations()) {
                    System.out.println("\tTranslation ->" + translation);
                }
            }

        } catch (IOException | JsonSyntaxException | JsonIOException ex) {
            ex.printStackTrace();
        }
    }

}
