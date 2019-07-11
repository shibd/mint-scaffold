package ${package}.service.compose;
import ${package}.service.dto.user.SearchUser;
import ${package}.service.dto.user.UserDto;

import java.util.List;

/**
 * @Auther: baozi
 * @Date: 2019/6/26 18:34
 * @Description:
 */
public interface XXXComposeService {
    /**
     * 模拟调用用户原子查询服务
     * @param searchUser
     * @return
     */
    List<UserDto> testComposeSearchUser(SearchUser searchUser);
    /**
     * 模拟调用用户原子服务和发送事件
     * @param searchUser
     * @return
     */
    List<UserDto> testComposeSearchUserAndSendEvent(SearchUser searchUser);
}
