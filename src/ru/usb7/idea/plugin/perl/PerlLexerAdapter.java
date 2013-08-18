package ru.usb7.idea.plugin.perl;

/**
 * @Author: Nazarov Yuriy
 */

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class PerlLexerAdapter extends FlexAdapter {
    public PerlLexerAdapter() {
        super(new PerlLexer((Reader) null));
    }
}
