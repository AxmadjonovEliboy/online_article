package uz.boom.core_project_jwt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author Jarvis on Fri 17:18. 14/04/23
 */

@Getter
@AllArgsConstructor
public enum Level {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    private final String name;

    public static Level getByName(String levelName) {
        if (Objects.isNull(levelName)) return Level.EASY;
        for (Level value : Level.values()) {
            if (value.name.equalsIgnoreCase(levelName)) return value;
        }
        return Level.EASY;
    }
}
