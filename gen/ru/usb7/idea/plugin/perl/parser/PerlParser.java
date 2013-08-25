// This is a generated file. Not intended for manual editing.
package ru.usb7.idea.plugin.perl.parser;

import org.jetbrains.annotations.*;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static ru.usb7.idea.plugin.perl.psi.PerlTypes.*;
import static ru.usb7.idea.plugin.perl.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PerlParser implements PsiParser {

  public static Logger LOG_ = Logger.getInstance("ru.usb7.idea.plugin.perl.parser.PerlParser");

  @NotNull
  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    int level_ = 0;
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this);
    if (root_ == ARRAY) {
      result_ = array(builder_, level_ + 1);
    }
    else if (root_ == CODE) {
      result_ = code(builder_, level_ + 1);
    }
    else if (root_ == CODE_BLOCK) {
      result_ = code_block(builder_, level_ + 1);
    }
    else if (root_ == EVAL) {
      result_ = eval(builder_, level_ + 1);
    }
    else if (root_ == EXPRESSION) {
      result_ = expression(builder_, level_ + 1);
    }
    else if (root_ == HASH) {
      result_ = hash(builder_, level_ + 1);
    }
    else if (root_ == INCLUDE) {
      result_ = include(builder_, level_ + 1);
    }
    else if (root_ == LITERAL) {
      result_ = literal(builder_, level_ + 1);
    }
    else if (root_ == PACKAGE_DECLARATION) {
      result_ = package_declaration(builder_, level_ + 1);
    }
    else if (root_ == PERLPOD) {
      result_ = perlpod(builder_, level_ + 1);
    }
    else if (root_ == SCALAR) {
      result_ = scalar(builder_, level_ + 1);
    }
    else if (root_ == SPECIAL_CODE_BLOCK) {
      result_ = special_code_block(builder_, level_ + 1);
    }
    else if (root_ == VARIABLE) {
      result_ = variable(builder_, level_ + 1);
    }
    else if (root_ == VARIABLE_DECLARATION) {
      result_ = variable_declaration(builder_, level_ + 1);
    }
    else {
      Marker marker_ = builder_.mark();
      enterErrorRecordingSection(builder_, level_, _SECTION_RECOVER_, null);
      result_ = parse_root_(root_, builder_, level_);
      exitErrorRecordingSection(builder_, level_, result_, true, _SECTION_RECOVER_, TOKEN_ADVANCER);
      marker_.done(root_);
    }
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return perlFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // ARRAY_SIGIL ID | (PARENTHESE_OPEN variable PARENTHESE_CLOSE)
  public static boolean array(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array")) return false;
    if (!nextTokenIs(builder_, ARRAY_SIGIL) && !nextTokenIs(builder_, PARENTHESE_OPEN)
        && replaceVariants(builder_, 2, "<array>")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<array>");
    result_ = array_0(builder_, level_ + 1);
    if (!result_) result_ = array_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(ARRAY);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // ARRAY_SIGIL ID
  private static boolean array_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, ARRAY_SIGIL, ID);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // PARENTHESE_OPEN variable PARENTHESE_CLOSE
  private static boolean array_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "array_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, PARENTHESE_OPEN);
    result_ = result_ && variable(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, PARENTHESE_CLOSE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // expression|eval|variable_declaration|eval|code|code_block
  public static boolean code(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "code")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<code>");
    result_ = expression(builder_, level_ + 1);
    if (!result_) result_ = eval(builder_, level_ + 1);
    if (!result_) result_ = variable_declaration(builder_, level_ + 1);
    if (!result_) result_ = eval(builder_, level_ + 1);
    if (!result_) result_ = code(builder_, level_ + 1);
    if (!result_) result_ = code_block(builder_, level_ + 1);
    if (result_) {
      marker_.done(CODE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // CURLYBRACKET_OPEN CRLF* code* CURLYBRACKET_CLOSE CRLF*
  public static boolean code_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "code_block")) return false;
    if (!nextTokenIs(builder_, CURLYBRACKET_OPEN)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, CURLYBRACKET_OPEN);
    result_ = result_ && code_block_1(builder_, level_ + 1);
    result_ = result_ && code_block_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CURLYBRACKET_CLOSE);
    result_ = result_ && code_block_4(builder_, level_ + 1);
    if (result_) {
      marker_.done(CODE_BLOCK);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // CRLF*
  private static boolean code_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "code_block_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!consumeToken(builder_, CRLF)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "code_block_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // code*
  private static boolean code_block_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "code_block_2")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!code(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "code_block_2");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // CRLF*
  private static boolean code_block_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "code_block_4")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!consumeToken(builder_, CRLF)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "code_block_4");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // EVAL_KEYWORD (code_block | literal) SEMICOLON? CRLF*
  public static boolean eval(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eval")) return false;
    if (!nextTokenIs(builder_, EVAL_KEYWORD)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, EVAL_KEYWORD);
    result_ = result_ && eval_1(builder_, level_ + 1);
    result_ = result_ && eval_2(builder_, level_ + 1);
    result_ = result_ && eval_3(builder_, level_ + 1);
    if (result_) {
      marker_.done(EVAL);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // code_block | literal
  private static boolean eval_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eval_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = code_block(builder_, level_ + 1);
    if (!result_) result_ = literal(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // SEMICOLON?
  private static boolean eval_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eval_2")) return false;
    consumeToken(builder_, SEMICOLON);
    return true;
  }

  // CRLF*
  private static boolean eval_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eval_3")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!consumeToken(builder_, CRLF)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "eval_3");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // ID variable? SEMICOLON? COMMENT? CRLF
  public static boolean expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, ID);
    result_ = result_ && expression_1(builder_, level_ + 1);
    result_ = result_ && expression_2(builder_, level_ + 1);
    result_ = result_ && expression_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CRLF);
    if (result_) {
      marker_.done(EXPRESSION);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // variable?
  private static boolean expression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression_1")) return false;
    variable(builder_, level_ + 1);
    return true;
  }

  // SEMICOLON?
  private static boolean expression_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression_2")) return false;
    consumeToken(builder_, SEMICOLON);
    return true;
  }

  // COMMENT?
  private static boolean expression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression_3")) return false;
    consumeToken(builder_, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // HASH_SIGIL ID
  public static boolean hash(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "hash")) return false;
    if (!nextTokenIs(builder_, HASH_SIGIL)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, HASH_SIGIL, ID);
    if (result_) {
      marker_.done(HASH);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // USE_REQURE_KEYWORD MODULE_NAME SEMICOLON
  public static boolean include(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "include")) return false;
    if (!nextTokenIs(builder_, USE_REQURE_KEYWORD)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, USE_REQURE_KEYWORD, MODULE_NAME, SEMICOLON);
    if (result_) {
      marker_.done(INCLUDE);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // LITERAL_START LITERAL_CONTENT* LITERAL_END
  public static boolean literal(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "literal")) return false;
    if (!nextTokenIs(builder_, LITERAL_START)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LITERAL_START);
    result_ = result_ && literal_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LITERAL_END);
    if (result_) {
      marker_.done(LITERAL);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // LITERAL_CONTENT*
  private static boolean literal_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "literal_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!consumeToken(builder_, LITERAL_CONTENT)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "literal_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // PACKAGE_KEYWORD MODULE_NAME SEMICOLON
  public static boolean package_declaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "package_declaration")) return false;
    if (!nextTokenIs(builder_, PACKAGE_KEYWORD)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, PACKAGE_KEYWORD, MODULE_NAME, SEMICOLON);
    if (result_) {
      marker_.done(PACKAGE_DECLARATION);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // perl_item*
  static boolean perlFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "perlFile")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!perl_item(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "perlFile");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // package_declaration|include|special_code_block|code|COMMENT|perlpod|CRLF
  static boolean perl_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "perl_item")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = package_declaration(builder_, level_ + 1);
    if (!result_) result_ = include(builder_, level_ + 1);
    if (!result_) result_ = special_code_block(builder_, level_ + 1);
    if (!result_) result_ = code(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = perlpod(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // PERLPOD_START PERLPOD_CONTENT* PERLPOD_END
  public static boolean perlpod(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "perlpod")) return false;
    if (!nextTokenIs(builder_, PERLPOD_START)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, PERLPOD_START);
    result_ = result_ && perlpod_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, PERLPOD_END);
    if (result_) {
      marker_.done(PERLPOD);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // PERLPOD_CONTENT*
  private static boolean perlpod_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "perlpod_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!consumeToken(builder_, PERLPOD_CONTENT)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "perlpod_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // SCALAR_SIGIL ID | literal
  public static boolean scalar(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "scalar")) return false;
    if (!nextTokenIs(builder_, LITERAL_START) && !nextTokenIs(builder_, SCALAR_SIGIL)
        && replaceVariants(builder_, 2, "<scalar>")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<scalar>");
    result_ = scalar_0(builder_, level_ + 1);
    if (!result_) result_ = literal(builder_, level_ + 1);
    if (result_) {
      marker_.done(SCALAR);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // SCALAR_SIGIL ID
  private static boolean scalar_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "scalar_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, SCALAR_SIGIL, ID);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // SPECIAL_BLOCK_KEYWORD code_block SEMICOLON?
  public static boolean special_code_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "special_code_block")) return false;
    if (!nextTokenIs(builder_, SPECIAL_BLOCK_KEYWORD)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, SPECIAL_BLOCK_KEYWORD);
    result_ = result_ && code_block(builder_, level_ + 1);
    result_ = result_ && special_code_block_2(builder_, level_ + 1);
    if (result_) {
      marker_.done(SPECIAL_CODE_BLOCK);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // SEMICOLON?
  private static boolean special_code_block_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "special_code_block_2")) return false;
    consumeToken(builder_, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // scalar|array|hash
  public static boolean variable(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variable")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<variable>");
    result_ = scalar(builder_, level_ + 1);
    if (!result_) result_ = array(builder_, level_ + 1);
    if (!result_) result_ = hash(builder_, level_ + 1);
    if (result_) {
      marker_.done(VARIABLE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // VARIABLE_DECLARATION_KEYWORD variable SEMICOLON? CRLF*
  public static boolean variable_declaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variable_declaration")) return false;
    if (!nextTokenIs(builder_, VARIABLE_DECLARATION_KEYWORD)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, VARIABLE_DECLARATION_KEYWORD);
    result_ = result_ && variable(builder_, level_ + 1);
    result_ = result_ && variable_declaration_2(builder_, level_ + 1);
    result_ = result_ && variable_declaration_3(builder_, level_ + 1);
    if (result_) {
      marker_.done(VARIABLE_DECLARATION);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // SEMICOLON?
  private static boolean variable_declaration_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variable_declaration_2")) return false;
    consumeToken(builder_, SEMICOLON);
    return true;
  }

  // CRLF*
  private static boolean variable_declaration_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variable_declaration_3")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!consumeToken(builder_, CRLF)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "variable_declaration_3");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

}
