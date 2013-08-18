package ru.usb7.idea.plugin.perl;

/**
 * @Author: Nazarov Yuriy
 */

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import ru.usb7.idea.plugin.perl.psi.PerlTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.Reader;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class PerlSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey KEYWORD_1     = createTextAttributesKey("PERL_KEYWORD_1", new TextAttributes(new Color(0xA020F0), null, null, null, Font.PLAIN));
    public static final TextAttributesKey KEYWORD_2     = createTextAttributesKey("PERL_KEYWORD_2", new TextAttributes(Color.BLUE,          null, null, null, Font.PLAIN));
    public static final TextAttributesKey VARIABLE      = createTextAttributesKey("PERL_VARIABLE",  new TextAttributes(Color.MAGENTA,       null, null, null, Font.PLAIN));
    public static final TextAttributesKey COMMENT_1     = createTextAttributesKey("PERL_COMMENT_1", new TextAttributes(new Color(0xB22200), null, null, null, Font.PLAIN));
    public static final TextAttributesKey COMMENT_2     = createTextAttributesKey("PERL_COMMENT_2", new TextAttributes(new Color(0xB22200), null, null, null, Font.BOLD));
    public static final TextAttributesKey LITERAL_1     = createTextAttributesKey("PERL_LITERAL_1", new TextAttributes(new Color(0x0000FF), null, null, null, Font.PLAIN));
    public static final TextAttributesKey LITERAL_2     = createTextAttributesKey("PERL_LITERAL_2", new TextAttributes(Color.GREEN,         null, null, null, Font.PLAIN));
    public static final TextAttributesKey LABEL         = createTextAttributesKey("PERL_LABEL",     new TextAttributes(Color.MAGENTA,       null, null, null, Font.PLAIN));
    public static final TextAttributesKey FUNCTON       = createTextAttributesKey("PERL_FUNCTION",  new TextAttributes(Color.MAGENTA,       null, null, null, Font.PLAIN));
    public static final TextAttributesKey OPERATOR      = createTextAttributesKey("PERL_OPERATOR",  new TextAttributes(Color.BLACK,         null, null, null, Font.PLAIN));
    public static final TextAttributesKey NUMBER        = createTextAttributesKey("PERL_NUMBER",    new TextAttributes(Color.BLUE,          null, null, null, Font.PLAIN));
    public static final TextAttributesKey INVALID       = createTextAttributesKey("PERL_INVALID",   new TextAttributes(Color.RED,           null, null, null, Font.BOLD));

    private static final TextAttributesKey[] KEYWORD_1_KEYS = new TextAttributesKey[]{KEYWORD_1};
    private static final TextAttributesKey[] KEYWORD_2_KEYS = new TextAttributesKey[]{KEYWORD_2};
    private static final TextAttributesKey[] VARIABLE_KEYS  = new TextAttributesKey[]{VARIABLE};
    private static final TextAttributesKey[] COMMENT_1_KEYS = new TextAttributesKey[]{COMMENT_1};
    private static final TextAttributesKey[] COMMENT_2_KEYS = new TextAttributesKey[]{COMMENT_2};
    private static final TextAttributesKey[] LITERAL_1_KEYS = new TextAttributesKey[]{LITERAL_1};
    private static final TextAttributesKey[] LITERAL_2_KEYS = new TextAttributesKey[]{LITERAL_2};
    private static final TextAttributesKey[] LABEL_KEYS     = new TextAttributesKey[]{LABEL};
    private static final TextAttributesKey[] FUNCTON_KEYS   = new TextAttributesKey[]{FUNCTON};
    private static final TextAttributesKey[] OPERATOR_KEYS  = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] NUMBER_KEYS    = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] INVALID_KEYS   = new TextAttributesKey[]{INVALID};
    private static final TextAttributesKey[] EMPTY_KEYS     = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new PerlLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(PerlTypes.FUNCTION)) {
            return KEYWORD_1_KEYS;
        } else if (tokenType.equals(PerlTypes.FUNCTION)) {
            return KEYWORD_2_KEYS;
        } else if (tokenType.equals(PerlTypes.FUNCTION)) {
            return VARIABLE_KEYS;
        } else if (tokenType.equals(PerlTypes.COMMENT_1)) {
            return COMMENT_1_KEYS;
        } else if (tokenType.equals(PerlTypes.COMMENT_2_START) || tokenType.equals(PerlTypes.COMMENT_2_CONTENT) || tokenType.equals(PerlTypes.COMMENT_2_END)) {
            return COMMENT_2_KEYS;
        } else if (tokenType.equals(PerlTypes.LITERAL_1_START) || tokenType.equals(PerlTypes.LITERAL_1_CONTENT) || tokenType.equals(PerlTypes.LITERAL_1_END)) {
            return LITERAL_1_KEYS;
        } else if (tokenType.equals(PerlTypes.FUNCTION)) {
            return LITERAL_2_KEYS;
        } else if (tokenType.equals(PerlTypes.FUNCTION)) {
            return LABEL_KEYS;
        } else if (tokenType.equals(PerlTypes.FUNCTION)) {
            return FUNCTON_KEYS;
        } else if (tokenType.equals(PerlTypes.FUNCTION)) {
            return OPERATOR_KEYS;
        } else if (tokenType.equals(PerlTypes.FUNCTION)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return INVALID_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
