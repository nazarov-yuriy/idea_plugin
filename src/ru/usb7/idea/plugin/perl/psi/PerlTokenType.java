package ru.usb7.idea.plugin.perl.psi;

/**
 * @Author: Nazarov Yuriy
 */

import com.intellij.psi.tree.IElementType;
import ru.usb7.idea.plugin.perl.PerlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class PerlTokenType extends IElementType {
    public PerlTokenType(@NotNull @NonNls String debugName) {
        super(debugName, PerlLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "PerlTokenType." + super.toString();
    }
}