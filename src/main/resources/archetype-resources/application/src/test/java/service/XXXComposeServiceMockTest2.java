package ${package}.service;

import ${package}.${classPrefix}ApplicationTests;
import ${package}.service.atom.UserService;
import ${package}.service.compose.XXXComposeService;
import ${package}.service.dto.user.SearchUser;
import ${package}.service.dto.user.UserDto;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: baozi
 * @Date: 2019/7/11 09:49
 * @Description:
 * 第二种方式,结合spring容器
 */
@DirtiesContext
@EmbeddedKafka(partitions = 1, topics = "${xxx.topic}")
@TestPropertySource(properties = {"kafka.enable=true"})
public class XXXComposeServiceMockTest2 extends ${classPrefix}ApplicationTests {

    @Autowired
    XXXComposeService xxxComposeService;

    @MockBean
    UserService userService;

    // mock搜索条件
    SearchUser searchUser = new SearchUser();

    @Before
    public void befor() {
        // mock
        searchUser.setAccount("test1");
        searchUser.setNickName("test2");

        UserDto userDto = new UserDto();
        userDto.setAccount("mock2-account");
        userDto.setNickName("mock2-nickName");

        Mockito.when(userService.getUsers(searchUser)).thenReturn(Arrays.asList(userDto));
    }

    @Test
    public void testXXXMockTest() {
        List<UserDto> users = xxxComposeService.testComposeSearchUserAndSendEvent(searchUser);
        System.out.println(JSONObject.toJSONString(users));
        Assert.assertTrue(users.size() == 1);
        Assert.assertTrue(users.get(0).getAccount().equals("mock2-account"));
    }


}
