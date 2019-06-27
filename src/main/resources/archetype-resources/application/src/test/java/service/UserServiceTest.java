package ${package}.service;

import ${package}.${classPrefix}ApplicationTests;
import ${package}.service.atom.UserService;
import ${package}.service.dto.user.SearchUser;
import ${package}.service.dto.user.UserDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: baozi
 * @Date: 2019/6/27 11:29
 * @Description:
 */
public class UserServiceTest extends ${classPrefix}ApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void testSearch() {
        SearchUser searchUser = new SearchUser();
        searchUser.setAccount("test1");
        searchUser.setNickName("test2");
        List<UserDto> users = userService.getUsers(searchUser);
        Assert.assertTrue(users.size() == 2);
    }
}
