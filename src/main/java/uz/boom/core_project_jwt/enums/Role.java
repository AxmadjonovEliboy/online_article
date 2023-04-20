package uz.boom.core_project_jwt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author Jarvis on Sat 11:30. 08/04/23
 */
@Getter
@AllArgsConstructor
public enum Role {

    ADMIN("ADMIN"),
    USER("USER"),
    SUPPER_ADMIN("SUPPER_ADMIN");

    private final String name;

    public static Role getByName(String roleName) {
        if (Objects.isNull(roleName)) return Role.USER;
        for (Role value : Role.values()) {
            if (value.name.equalsIgnoreCase(roleName)) return value;
        }
        return Role.USER;
    }
}
