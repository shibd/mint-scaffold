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

    public static UserVo dtoToVo(UserDto userDto) {
        UserVo  userVo  = new UserVo ();
        userVo.setAccount(userDto.getAccount());
        userVo.setPassword(userDto.getPassword());
        userVo.setNickName(userDto.getNickName());
        return userVo;
    }
}
