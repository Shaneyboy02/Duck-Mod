package me.shaneyboy02.ducky.data;

import me.shaneyboy02.ducky.DuckMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class EnglishLang extends LanguageProvider {
    public EnglishLang(DataGenerator gen) {
        super(gen, DuckMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

    }
}
