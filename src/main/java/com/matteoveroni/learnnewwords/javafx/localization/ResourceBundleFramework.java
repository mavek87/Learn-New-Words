package com.matteoveroni.learnnewwords.javafx.localization;

import java.util.Locale;

/**
 *
 * @author Matteo Veroni
 */
public enum ResourceBundleFramework {

    SUPPORTED_ENGLISH_LOCALE("English", new Locale("en", "EN")),
    SUPPORTED_ITALIAN_LOCALE("Italian", new Locale("it", "IT"));

    private final String localeName;
    private final Locale locale;

    protected static final String RESOURCE_BUNDLE_FILES_PATH = "resources/localization/bundles";

    ResourceBundleFramework(String localeName, Locale locale) {
        this.localeName = localeName;
        this.locale = locale;
    }

    protected String getLocaleName() {
        return localeName;
    }

    protected Locale getLocale() {
        return locale;
    }
}
