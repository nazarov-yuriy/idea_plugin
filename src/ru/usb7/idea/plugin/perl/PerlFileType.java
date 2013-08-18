package ru.usb7.idea.plugin.perl;

/**
 * @Author: Nazarov Yuriy
 */

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PerlFileType extends LanguageFileType {
    public static final PerlFileType INSTANCE = new PerlFileType();

    private PerlFileType() {
        super(PerlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Perl script";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Perl script";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "pl";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return PerlIcons.FILE;
    }
}