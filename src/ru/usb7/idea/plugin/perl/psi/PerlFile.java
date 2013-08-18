package ru.usb7.idea.plugin.perl.psi;

/**
 * @Author: Nazarov Yuriy
 */

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import ru.usb7.idea.plugin.perl.PerlFileType;
import ru.usb7.idea.plugin.perl.PerlLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class PerlFile extends PsiFileBase {
    public PerlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, PerlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return PerlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Perl File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
