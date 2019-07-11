package ${package}.service.compose.impl;

import ${package}.service.atom.UserService;
import ${package}.service.compose.XXXComposeService;
import ${package}.service.dto.user.SearchUser;
import ${package}.service.dto.user.UserDto;
import ${package}.service.kafka.XXXSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: baozi
 * @Date: 2019/6/26 18:35
 * @Description:
 */
@Service
public class XXXComposeServiceImpl implements XXXComposeService {


    @Autowired
    UserService userService;

    @Autowired
    XXXSender xxxSender;

    @Override
    public List<UserDto> testComposeSearchUser(SearchUser searchUser) {
        return userService.getUsers(searchUser);
    }

    @Override
    public List<UserDto> testComposeSearchUserAndSendEvent(SearchUser searchUser) {
        xxxSender.send(searchUser.getAccount());
        return userService.getUsers(searchUser);
    }
}
