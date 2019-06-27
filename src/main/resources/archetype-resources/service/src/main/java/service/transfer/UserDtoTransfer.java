package ${package}.service.transfer;

import ${package}.common.model.po.auto.User;
import ${package}.service.dto.user.UserDto;

/**
 * @Auther: baozi
 * @Date: 2019/6/25 15:33
 * @Description:
 */
public abstract class UserDtoTransfer {

    public static User dtoTransPo(UserDto userDto) {
        User user = new User();
        user.setAccount(userDto.getAccount());
        user.setPassword(userDto.getPassword());
        user.setNickName(userDto.getNickName());
        return user;
    }

    public static UserDto poTransDto(User userPo) {
        UserDto userDto = new UserDto();
        userDto.setAccount(userPo.getAccount());
        userDto.setPassword(userPo.getPassword());
        userDto.setNickName(userPo.getNickName());
        return userDto;
    }
}
