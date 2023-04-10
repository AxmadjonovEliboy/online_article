package uz.boom.core_project_jwt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author Jarvis on Sat 11:31. 08/04/23
 */
@Getter
@AllArgsConstructor
public enum Gender {

    MALE("male"),
    FEMALE("female"),
    OTHER("other");


    private final String name;

    public static Gender getByName(String genderName) {
        if (Objects.isNull(genderName)) return Gender.OTHER;
        for (Gender value : Gender.values()) {
            if (value.name.equalsIgnoreCase(genderName)) return value;
        }
        return Gender.OTHER;
    }
}
