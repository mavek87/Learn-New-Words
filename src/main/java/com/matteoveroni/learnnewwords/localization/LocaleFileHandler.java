package com.matteoveroni.learnnewwords.localization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

/**
 *
 * @author Matteo Veroni
 */
public class LocaleFileHandler {

    private static final String LANGUAGE_FILE_PATH = "src/main/resources/localization/";
    private static final String LANGUAGE_FILE_NAME = "locale.properties";

    private final File languageFile;
    private final Properties propertiesOfLanguageFile = new Properties();

    public LocaleFileHandler() {
        try {
            languageFile = new File(LANGUAGE_FILE_PATH + LANGUAGE_FILE_NAME);
            if (languageFile.createNewFile()) {
                writeLocale(ResourceBundleFramework.SUPPORTED_ENGLISH_LOCALE.getLocale());
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public final void writeLocale(Locale locale) {
        BufferedOutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(languageFile));
            propertiesOfLanguageFile.setProperty("locale", locale.toString());
            propertiesOfLanguageFile.store(outputStream, "default locale setted");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    public final Locale readLocale() {
        Locale localeSetted;
        String defaultLocaleContent = readSettedLocaleFromLanguageFile();
        switch (defaultLocaleContent) {
            case "en_EN":
                localeSetted = ResourceBundleFramework.SUPPORTED_ENGLISH_LOCALE.getLocale();
//                LOG.info("Locale setted to English");
                break;
            case "it_IT":
                localeSetted = ResourceBundleFramework.SUPPORTED_ITALIAN_LOCALE.getLocale();
//                LOG.info("Locale setted to Italian");
                break;
            default:
                throw new RuntimeException("LOCALE FILE CORRUPTED");
        }
        return localeSetted;
    }

    private String readSettedLocaleFromLanguageFile() {
        BufferedInputStream inputStream = null;
        String localeToStringReadedFromResourceBundle = "";
        try {
            inputStream = new BufferedInputStream(new FileInputStream(languageFile));
            propertiesOfLanguageFile.load(inputStream);
            localeToStringReadedFromResourceBundle = propertiesOfLanguageFile.getProperty("locale");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
            }
        }
        return localeToStringReadedFromResourceBundle;
    }
}
