package ${package}.facade.transfer;

import ${package}.facade.model.UserFaReq;
import ${package}.service.dto.user.UserDto;

/**
 * @Auther: baozi
 * @Date: 2019/6/26 18:36
 * @Description:
 */
public abstract class UserFaTransfer {


    public static UserDto faReqToDto(UserFaReq userFaReq) {
        UserDto userDto = new UserDto();
        userDto.setAccount(userFaReq.getAccount());
        userDto.setPassword(userFaReq.getPassword());
        userDto.setNickName(userFaReq.getNickName());
        return userDto;
    }
}
