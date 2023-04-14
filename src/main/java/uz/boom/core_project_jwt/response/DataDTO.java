package uz.boom.core_project_jwt.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataDTO<T>  {
    protected T data;

    protected AppErrorDTO error;

    protected boolean success;

    private Long totalCount;

    public DataDTO(boolean success) {
        this.success = success;
    }

    public DataDTO(T data) {
        this.data = data;
        this.success = true;
    }

    public DataDTO(AppErrorDTO error) {
        this.error = error;
        this.success = false;
    }

    public DataDTO(T data, Long totalCount) {
        this.data = data;
        this.success = true;
        this.totalCount = totalCount;
    }
}