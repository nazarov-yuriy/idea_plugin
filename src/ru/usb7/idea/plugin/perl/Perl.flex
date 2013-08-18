package ru.usb7.idea.plugin.perl;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import ru.usb7.idea.plugin.perl.psi.PerlTypes;
import com.intellij.psi.TokenType;

%%

%class PerlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF= \n|\r|\r\n
SEMICOLON= ";"
WHITE_SPACE=[\ \t\f]
FUNCTION_CHARACTER=[a-zA-Z]
SINGLE_QUOTE_STRING_START='
SINGLE_QUOTE_STRING_END='

PERLPOD_START="="[a-zA-Z]+[^\r\n]*
PERLPOD_END="=cut"

END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*

%state WAITING_QUOTE_STRING_END
%state WAITING_PERLPOD_END

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return PerlTypes.COMMENT_1; }

<YYINITIAL> {FUNCTION_CHARACTER}+                           { yybegin(YYINITIAL); return PerlTypes.FUNCTION; }

<YYINITIAL> {PERLPOD_START}                                 { yybegin(WAITING_PERLPOD_END); return PerlTypes.COMMENT_2_START; }

<YYINITIAL> {SINGLE_QUOTE_STRING_START}                     { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_1_START; }

<WAITING_QUOTE_STRING_END> {
  {SINGLE_QUOTE_STRING_END}                                 { yybegin(YYINITIAL); return PerlTypes.LITERAL_1_END; }
  [^\n\r\'\\]+                                              { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_1_CONTENT; }
  \\n                                                       { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_1_CONTENT; }
  \\r                                                       { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_1_CONTENT; }
  \\\'                                                      { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_1_CONTENT; }
  \\                                                        { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_1_CONTENT; }
}

<WAITING_PERLPOD_END> {
  {PERLPOD_END}                                             { yybegin(YYINITIAL); return PerlTypes.COMMENT_2_END; }
  [^=]+                                                     { yybegin(WAITING_PERLPOD_END); return PerlTypes.COMMENT_2_CONTENT; }
  [=]+                                                      { yybegin(WAITING_PERLPOD_END); return PerlTypes.COMMENT_2_CONTENT; }
}

{CRLF}                                                      { yybegin(YYINITIAL); return PerlTypes.CRLF; }

{SEMICOLON}                                                 { yybegin(YYINITIAL); return PerlTypes.SEMICOLON; }

{WHITE_SPACE}+                                              { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }