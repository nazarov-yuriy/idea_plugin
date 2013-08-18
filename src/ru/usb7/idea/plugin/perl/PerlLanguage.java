package ru.usb7.idea.plugin.perl;

/**
 * @Author: Nazarov Yuriy
 */

import com.intellij.lang.Language;

public class PerlLanguage extends Language {
    public static final PerlLanguage INSTANCE = new PerlLanguage();

    public PerlLanguage() {
        super("Perl", "text/properties");
    }
}
