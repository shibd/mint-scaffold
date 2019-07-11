package ${package}.service;

import ${package}.${classPrefix}ApplicationTests;
import ${package}.service.atom.UserService;
import ${package}.service.compose.XXXComposeService;
import ${package}.service.compose.impl.XXXComposeServiceImpl;
import ${package}.service.dto.user.SearchUser;
import ${package}.service.dto.user.UserDto;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: baozi
 * @Date: 2019/7/11 09:49
 * @Description:
 * 第一种测试,没有结合spring容器
 */
public class XXXComposeServiceMockTest1 extends ${classPrefix}ApplicationTests {


    @InjectMocks
    XXXComposeService xxxComposeService = new XXXComposeServiceImpl();

    @Mock
    UserService userService;

    // mock搜索条件
    SearchUser searchUser = new SearchUser();

    @Before
    public void befor() {
        // mock
        searchUser.setAccount("test1");
        searchUser.setNickName("test2");

        UserDto userDto = new UserDto();
        userDto.setAccount("mock1-account");
        userDto.setNickName("mock1-nickName");

        Mockito.when(userService.getUsers(searchUser)).thenReturn(Arrays.asList(userDto));
    }

    @Test
    public void testXXXMockTest() {
        List<UserDto> users = xxxComposeService.testComposeSearchUser(searchUser);
        System.out.println(JSONObject.toJSONString(users));
        Assert.assertTrue(users.size() == 1);
        Assert.assertTrue(users.get(0).getAccount().equals("mock1-account"));
    }


}
