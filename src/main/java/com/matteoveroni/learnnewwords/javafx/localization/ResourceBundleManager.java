package com.matteoveroni.learnnewwords.javafx.localization;

import com.matteoveroni.learnnewwords.javafx.localization.exceptions.ResourceBundleForThisLocaleDoesntExistException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Matteo Veroni
 */
public class ResourceBundleManager {

    private final LocaleFileHandler languageFileHandler = new LocaleFileHandler();

    public ResourceBundle getResourceBundle() throws ResourceBundleForThisLocaleDoesntExistException{
        Locale currentLocale = languageFileHandler.readLocale();
        if (resourceBundleForThisLocaleExists(currentLocale)) {
            return ResourceBundle.getBundle("localization.bundles.Bundle", currentLocale);
        }
        throw new ResourceBundleForThisLocaleDoesntExistException();
    }

    public ResourceBundle changeResourceBundle(Locale newLocale)  throws ResourceBundleForThisLocaleDoesntExistException{
        if (resourceBundleForThisLocaleExists(newLocale)) {
            languageFileHandler.writeLocale(newLocale);
            return ResourceBundle.getBundle("localization.bundles.Bundle", newLocale);
        }
        throw new ResourceBundleForThisLocaleDoesntExistException();
    }

    private boolean resourceBundleForThisLocaleExists(Locale locale) {
        for (ResourceBundleFramework resourceBundle : ResourceBundleFramework.values()) {
            if (resourceBundle.getLocale().equals(locale)) {
                return true;
            }
        }
        return false;
    }
}
