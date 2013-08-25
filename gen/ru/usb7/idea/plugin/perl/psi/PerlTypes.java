// This is a generated file. Not intended for manual editing.
package ru.usb7.idea.plugin.perl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ru.usb7.idea.plugin.perl.psi.impl.*;

public interface PerlTypes {

  IElementType ARRAY = new PerlElementType("ARRAY");
  IElementType CODE = new PerlElementType("CODE");
  IElementType CODE_BLOCK = new PerlElementType("CODE_BLOCK");
  IElementType EVAL = new PerlElementType("EVAL");
  IElementType EXPRESSION = new PerlElementType("EXPRESSION");
  IElementType HASH = new PerlElementType("HASH");
  IElementType INCLUDE = new PerlElementType("INCLUDE");
  IElementType LITERAL = new PerlElementType("LITERAL");
  IElementType PACKAGE_DECLARATION = new PerlElementType("PACKAGE_DECLARATION");
  IElementType PERLPOD = new PerlElementType("PERLPOD");
  IElementType SCALAR = new PerlElementType("SCALAR");
  IElementType SPECIAL_CODE_BLOCK = new PerlElementType("SPECIAL_CODE_BLOCK");
  IElementType VARIABLE = new PerlElementType("VARIABLE");
  IElementType VARIABLE_DECLARATION = new PerlElementType("VARIABLE_DECLARATION");

  IElementType ARRAY_SIGIL = new PerlTokenType("ARRAY_SIGIL");
  IElementType COMMENT = new PerlTokenType("COMMENT");
  IElementType CRLF = new PerlTokenType("CRLF");
  IElementType CURLYBRACKET_CLOSE = new PerlTokenType("CURLYBRACKET_CLOSE");
  IElementType CURLYBRACKET_OPEN = new PerlTokenType("CURLYBRACKET_OPEN");
  IElementType EVAL_KEYWORD = new PerlTokenType("EVAL_KEYWORD");
  IElementType HASH_SIGIL = new PerlTokenType("HASH_SIGIL");
  IElementType ID = new PerlTokenType("ID");
  IElementType LITERAL_CONTENT = new PerlTokenType("LITERAL_CONTENT");
  IElementType LITERAL_END = new PerlTokenType("LITERAL_END");
  IElementType LITERAL_START = new PerlTokenType("LITERAL_START");
  IElementType MODULE_NAME = new PerlTokenType("MODULE_NAME");
  IElementType PACKAGE_KEYWORD = new PerlTokenType("PACKAGE_KEYWORD");
  IElementType PARENTHESE_CLOSE = new PerlTokenType("PARENTHESE_CLOSE");
  IElementType PARENTHESE_OPEN = new PerlTokenType("PARENTHESE_OPEN");
  IElementType PERLPOD_CONTENT = new PerlTokenType("PERLPOD_CONTENT");
  IElementType PERLPOD_END = new PerlTokenType("PERLPOD_END");
  IElementType PERLPOD_START = new PerlTokenType("PERLPOD_START");
  IElementType SCALAR_SIGIL = new PerlTokenType("SCALAR_SIGIL");
  IElementType SEMICOLON = new PerlTokenType("SEMICOLON");
  IElementType SPECIAL_BLOCK_KEYWORD = new PerlTokenType("SPECIAL_BLOCK_KEYWORD");
  IElementType USE_REQURE_KEYWORD = new PerlTokenType("USE_REQURE_KEYWORD");
  IElementType VARIABLE_DECLARATION_KEYWORD = new PerlTokenType("VARIABLE_DECLARATION_KEYWORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARRAY) {
        return new PerlArrayImpl(node);
      }
      else if (type == CODE) {
        return new PerlCodeImpl(node);
      }
      else if (type == CODE_BLOCK) {
        return new PerlCodeBlockImpl(node);
      }
      else if (type == EVAL) {
        return new PerlEvalImpl(node);
      }
      else if (type == EXPRESSION) {
        return new PerlExpressionImpl(node);
      }
      else if (type == HASH) {
        return new PerlHashImpl(node);
      }
      else if (type == INCLUDE) {
        return new PerlIncludeImpl(node);
      }
      else if (type == LITERAL) {
        return new PerlLiteralImpl(node);
      }
      else if (type == PACKAGE_DECLARATION) {
        return new PerlPackageDeclarationImpl(node);
      }
      else if (type == PERLPOD) {
        return new PerlPerlpodImpl(node);
      }
      else if (type == SCALAR) {
        return new PerlScalarImpl(node);
      }
      else if (type == SPECIAL_CODE_BLOCK) {
        return new PerlSpecialCodeBlockImpl(node);
      }
      else if (type == VARIABLE) {
        return new PerlVariableImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new PerlVariableDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
