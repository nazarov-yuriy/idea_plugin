package ru.usb7.idea.plugin.perl;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import ru.usb7.idea.plugin.perl.psi.PerlTypes;
import com.intellij.psi.TokenType;

/* *
   * PACKAGE_KEYWORD
   * MODULE_NAME
   * SEMICOLON
   * USE_REQURE_KEYWORD
   * INCLUDE_LIST
   * SPECIAL_BLOCK_KEYWORD
   * VARIABLE_DECLARATION_KEYWORD
   * EVAL_KEYWORD
   * CURLYBRACKET_OPEN
   * CURLYBRACKET_CLOSE
   * COMMENT
   * PERLPOD_START
   * PERLPOD_CONTENT
   * PERLPOD_END
   * SCALAR_SIGIL
   * ID
   * ARRAY_SIGIL
   * HASH_SIGIL
   * LITERAL_START
   * LITERAL_CONTENT
   * LITERAL_END
   */

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
ID_CHARACTER=[a-zA-Z][a-zA-Z0-9]*
SINGLE_QUOTE_STRING_START='
SINGLE_QUOTE_STRING_END='

PERLPOD_START="="[a-zA-Z]+[^\r\n]*
PERLPOD_END="=cut"

END_OF_LINE_COMMENT=("#")[^\r\n]*


//brackets
PARENTHESE_OPEN="("
PARENTHESE_CLOSE=")"
CURLYBRACKET_OPEN="{"
CURLYBRACKET_CLOSE="}"
BRACKET_OPEN="["
BRACKET_CLOSE="]"
ANGLEBRACKET_OPEN="<"
ANGLEBRACKET_CLOSE=">"

//
SCALAR_SIGIL="$"
ARRAY_SIGIL="@"
HASH_SIGIL="%"

//
PACKAGE_KEYWORD="package "
USE_REQURE_KEYWORD="use "|"requre "
SPECIAL_BLOCK_KEYWORD="BEGIN"|"UNITCHECK"|"CHECK"|"INIT"|"END"

%state WAITING_QUOTE_STRING_END
%state WAITING_PERLPOD_END
%state WAITING_MODULE

%%

<YYINITIAL> {PACKAGE_KEYWORD}                               { yybegin(WAITING_MODULE); return PerlTypes.PACKAGE_KEYWORD; }
<YYINITIAL> {USE_REQURE_KEYWORD}                            { yybegin(WAITING_MODULE); return PerlTypes.USE_REQURE_KEYWORD; }
<WAITING_MODULE> {WHITE_SPACE}                              { yybegin(WAITING_MODULE); return PerlTypes.MODULE_NAME; }
<WAITING_MODULE> {ID_CHARACTER}+ ( "::" {ID_CHARACTER}+ )*  { yybegin(YYINITIAL); return PerlTypes.MODULE_NAME; }
<WAITING_MODULE> {SEMICOLON}                                { yybegin(YYINITIAL); return PerlTypes.SEMICOLON; }
<WAITING_MODULE> [^a-zA-Z;\ \t\f]+                          { return TokenType.BAD_CHARACTER; }

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return PerlTypes.COMMENT; }

<YYINITIAL> {SPECIAL_BLOCK_KEYWORD}                         { yybegin(YYINITIAL); return PerlTypes.SPECIAL_BLOCK_KEYWORD; }

<YYINITIAL> {ID_CHARACTER}+                                 { yybegin(YYINITIAL); return PerlTypes.ID; }

<YYINITIAL> {SCALAR_SIGIL}                                  { yybegin(YYINITIAL); return PerlTypes.SCALAR_SIGIL; }

<YYINITIAL> {ARRAY_SIGIL}                                   { yybegin(YYINITIAL); return PerlTypes.ARRAY_SIGIL; }

<YYINITIAL> {HASH_SIGIL}                                    { yybegin(YYINITIAL); return PerlTypes.HASH_SIGIL; }

<YYINITIAL> {CURLYBRACKET_OPEN}                             { yybegin(YYINITIAL); return PerlTypes.CURLYBRACKET_OPEN; }

<YYINITIAL> {CURLYBRACKET_CLOSE}                            { yybegin(YYINITIAL); return PerlTypes.CURLYBRACKET_CLOSE; }

<YYINITIAL> {PERLPOD_START}                                 { yybegin(WAITING_PERLPOD_END); return PerlTypes.PERLPOD_START; }

<YYINITIAL> {SINGLE_QUOTE_STRING_START}                     { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_START; }

<WAITING_QUOTE_STRING_END> {
  {SINGLE_QUOTE_STRING_END}                                 { yybegin(YYINITIAL); return PerlTypes.LITERAL_END; }
  [^\n\r\'\\]+                                              { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_CONTENT; }
  \\n                                                       { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_CONTENT; }
  \\r                                                       { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_CONTENT; }
  \\\'                                                      { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_CONTENT; }
  \\                                                        { yybegin(WAITING_QUOTE_STRING_END); return PerlTypes.LITERAL_CONTENT; }
}

<WAITING_PERLPOD_END> {
  {PERLPOD_END}                                             { yybegin(YYINITIAL); return PerlTypes.PERLPOD_END; }
  [^=]+                                                     { yybegin(WAITING_PERLPOD_END); return PerlTypes.PERLPOD_CONTENT; }
  [=]+                                                      { yybegin(WAITING_PERLPOD_END); return PerlTypes.PERLPOD_CONTENT; }
}

{CRLF}                                                      { yybegin(YYINITIAL); return PerlTypes.CRLF; }

{SEMICOLON}                                                 { yybegin(YYINITIAL); return PerlTypes.SEMICOLON; }

{WHITE_SPACE}+                                              { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }