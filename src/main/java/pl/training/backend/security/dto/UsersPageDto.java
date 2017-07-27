package pl.training.backend.security.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(value = "Users")
@Data
public class UsersPageDto {

    private List<UserDto> users;
    private int pageNumber;
    private int totalPages;

    public UsersPageDto() {
    }

    public UsersPageDto(List<UserDto> users, int pageNumber, int totalPages) {
        this.users = users;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

}
