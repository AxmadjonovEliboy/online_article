package uz.boom.core_project_jwt.criteria;

import lombok.Setter;

import java.util.Objects;

/**
 * @author Jarvis on Thu 16:45. 13/04/23
 */
@Setter
public abstract class GenericCriteria implements BaseCriteria{

    private Integer size;
    private Integer page;

    public Integer getPage() {
        if (Objects.isNull(page))
            page = 0;
        return page;
    }

    public Integer getSize() {
        if (Objects.isNull(size))
            size = 10;
        return size;
    }

}
