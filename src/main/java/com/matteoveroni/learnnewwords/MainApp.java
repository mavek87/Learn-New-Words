package com.matteoveroni.learnnewwords;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matteoveroni.learnnewwords.words.WordBean;
import com.matteoveroni.learnnewwords.words.WordsBean;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Matteo Veroni
 */
public class MainApp extends Application {

    private static final String VERSION = "0.0.1";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Learn New Words | v." + VERSION);
        stage.setScene(scene);
        stage.show();

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = "{'name' : 'mkyong'}";

            //JSON from URL to Object
            WordsBean wordsBean = mapper.readValue(getClass().getResource("/persistence/italian-english.json"), WordsBean.class);

            for (WordBean word : wordsBean.getWords()) {
                System.out.println("Word " + word.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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

}
