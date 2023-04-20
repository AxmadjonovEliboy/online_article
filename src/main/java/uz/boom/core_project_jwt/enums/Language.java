package uz.boom.core_project_jwt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author Jarvis on Fri 16:57. 14/04/23
 */
@Getter
@AllArgsConstructor
public enum Language {
    UZB("uzb"),
    RUS("rus"),
    ENG("eng");

    private final String name;

    public static Language getByName(String languageName) {
        if (Objects.isNull(languageName)) return Language.UZB;
        for (Language value : Language.values()) {
            if (value.name.equalsIgnoreCase(languageName)) return value;
        }
        return Language.UZB;
    }
}
