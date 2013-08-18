// This is a generated file. Not intended for manual editing.
package ru.usb7.idea.plugin.perl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ru.usb7.idea.plugin.perl.psi.impl.*;

public interface PerlTypes {

  IElementType COMMENT_2 = new PerlElementType("COMMENT_2");
  IElementType EXPRESSION = new PerlElementType("EXPRESSION");
  IElementType LITERAL_1 = new PerlElementType("LITERAL_1");

  IElementType COMMENT_1 = new PerlTokenType("COMMENT_1");
  IElementType COMMENT_2_CONTENT = new PerlTokenType("COMMENT_2_CONTENT");
  IElementType COMMENT_2_END = new PerlTokenType("COMMENT_2_END");
  IElementType COMMENT_2_START = new PerlTokenType("COMMENT_2_START");
  IElementType CRLF = new PerlTokenType("CRLF");
  IElementType FUNCTION = new PerlTokenType("FUNCTION");
  IElementType LITERAL_1_CONTENT = new PerlTokenType("LITERAL_1_CONTENT");
  IElementType LITERAL_1_END = new PerlTokenType("LITERAL_1_END");
  IElementType LITERAL_1_START = new PerlTokenType("LITERAL_1_START");
  IElementType SEMICOLON = new PerlTokenType("SEMICOLON");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == COMMENT_2) {
        return new PerlCOMMENT2Impl(node);
      }
      else if (type == EXPRESSION) {
        return new PerlExpressionImpl(node);
      }
      else if (type == LITERAL_1) {
        return new PerlLITERAL1Impl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
