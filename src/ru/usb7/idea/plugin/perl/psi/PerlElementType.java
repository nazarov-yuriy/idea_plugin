package ru.usb7.idea.plugin.perl.psi;

/**
 * @Author: Nazarov Yuriy
 */

import com.intellij.psi.tree.IElementType;
import ru.usb7.idea.plugin.perl.PerlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class PerlElementType extends IElementType {
    public PerlElementType(@NotNull @NonNls String debugName) {
        super(debugName, PerlLanguage.INSTANCE);
    }
}
