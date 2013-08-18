package ru.usb7.idea.plugin.perl;

/**
 * @Author: Nazarov Yuriy
 */

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import ru.usb7.idea.plugin.perl.parser.PerlParser;
import ru.usb7.idea.plugin.perl.psi.PerlFile;
import ru.usb7.idea.plugin.perl.psi.PerlTypes;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

public class PerlParserDefinition implements ParserDefinition{
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENT_1 = TokenSet.create(PerlTypes.COMMENT_1);
    public static final TokenSet LITERAL_1 = TokenSet.create(PerlTypes.LITERAL_1);

    public static final IFileElementType FILE = new IFileElementType(Language.<PerlLanguage>findInstance(PerlLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new FlexAdapter(new PerlLexer((Reader) null));
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENT_1;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return LITERAL_1;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new PerlParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new PerlFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return PerlTypes.Factory.createElement(node);
    }
}
