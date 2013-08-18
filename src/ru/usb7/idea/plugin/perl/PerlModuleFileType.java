package ru.usb7.idea.plugin.perl;

/**
 * @Author: Nazarov Yuriy
 */

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PerlModuleFileType extends LanguageFileType {
    public static final PerlModuleFileType INSTANCE = new PerlModuleFileType();

    private PerlModuleFileType() {
        super(PerlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Perl module";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Perl module";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "pm";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return PerlIcons.FILE;
    }
}