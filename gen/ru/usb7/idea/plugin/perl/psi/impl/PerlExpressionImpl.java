// This is a generated file. Not intended for manual editing.
package ru.usb7.idea.plugin.perl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ru.usb7.idea.plugin.perl.psi.PerlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ru.usb7.idea.plugin.perl.psi.*;

public class PerlExpressionImpl extends ASTWrapperPsiElement implements PerlExpression {

  public PerlExpressionImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public PerlLITERAL1 getLITERAL1() {
    return findChildByClass(PerlLITERAL1.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PerlVisitor) ((PerlVisitor)visitor).visitExpression(this);
    else super.accept(visitor);
  }

}
