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
    if (root_ == COMMENT_2) {
      result_ = COMMENT_2(builder_, level_ + 1);
    }
    else if (root_ == LITERAL_1) {
      result_ = LITERAL_1(builder_, level_ + 1);
    }
    else if (root_ == EXPRESSION) {
      result_ = expression(builder_, level_ + 1);
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
  // COMMENT_2_START COMMENT_2_CONTENT* COMMENT_2_END
  public static boolean COMMENT_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "COMMENT_2")) return false;
    if (!nextTokenIs(builder_, COMMENT_2_START)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMENT_2_START);
    result_ = result_ && COMMENT_2_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COMMENT_2_END);
    if (result_) {
      marker_.done(COMMENT_2);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // COMMENT_2_CONTENT*
  private static boolean COMMENT_2_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "COMMENT_2_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!consumeToken(builder_, COMMENT_2_CONTENT)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "COMMENT_2_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // LITERAL_1_START LITERAL_1_CONTENT* LITERAL_1_END
  public static boolean LITERAL_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LITERAL_1")) return false;
    if (!nextTokenIs(builder_, LITERAL_1_START)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LITERAL_1_START);
    result_ = result_ && LITERAL_1_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LITERAL_1_END);
    if (result_) {
      marker_.done(LITERAL_1);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // LITERAL_1_CONTENT*
  private static boolean LITERAL_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LITERAL_1_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!consumeToken(builder_, LITERAL_1_CONTENT)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "LITERAL_1_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // FUNCTION LITERAL_1? SEMICOLON? COMMENT_1? CRLF
  public static boolean expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression")) return false;
    if (!nextTokenIs(builder_, FUNCTION)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, FUNCTION);
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

  // LITERAL_1?
  private static boolean expression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression_1")) return false;
    LITERAL_1(builder_, level_ + 1);
    return true;
  }

  // SEMICOLON?
  private static boolean expression_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression_2")) return false;
    consumeToken(builder_, SEMICOLON);
    return true;
  }

  // COMMENT_1?
  private static boolean expression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression_3")) return false;
    consumeToken(builder_, COMMENT_1);
    return true;
  }

  /* ********************************************************** */
  // expression|COMMENT_1|COMMENT_2|CRLF
  static boolean item_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "item_")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expression(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT_1);
    if (!result_) result_ = COMMENT_2(builder_, level_ + 1);
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
  // item_*
  static boolean perlFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "perlFile")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!item_(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "perlFile");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

}
