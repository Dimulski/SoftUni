package app.domain.queryDtos;

import app.domain.dtos.UserJsonDto;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UsersProductsDto implements Serializable {

    @Expose
    private int usersCount;

    @Expose
    private Set<UserJsonDto> users;

    public UsersProductsDto() {
        super();
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public Set<UserJsonDto> getUsers() {
        if (this.users == null) {
            this.setUsers(new HashSet<>());
        }
        return users;
    }

    public void setUsers(Set<UserJsonDto> users) {
        this.users = users;
    }
}
