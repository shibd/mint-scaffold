package ${package}.transfer;

import ${package}.service.dto.user.UserDto;
import ${package}.vo.user.UserVo;

/**
 * @Auther: baozi
 * @Date: 2019/6/27 11:01
 * @Description:
 */
public abstract class UserVoTransfer {

    public static UserDto voToDto(UserVo userVo) {
        UserDto userDto = new UserDto();
        userDto.setAccount(userVo.getAccount());
        userDto.setPassword(userVo.getPassword());
        userDto.setNickName(userVo.getNickName());
        return userDto;
    }
}
