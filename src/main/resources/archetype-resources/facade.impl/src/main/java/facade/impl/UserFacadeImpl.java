package ${package}.facade.impl;

import ${package}.facade.api.UserFacade;
import ${package}.facade.model.UserFaReq;
import ${package}.facade.transfer.UserFaTransfer;
import ${package}.service.atom.UserService;
import ${package}.service.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: baozi
 * @Date: 2019/6/25 11:32
 * @Description:
 */
@RestController
public class UserFacadeImpl implements UserFacade {

    @Autowired
    UserService userService;

    @Override
    public boolean createUser(@RequestBody UserFaReq userFaReq) {
        UserDto userDto = UserFaTransfer.faReqToDto(userFaReq);
        return userService.createUser(userDto);
    }
}
