package ${package}.controller;

import ${package}.service.atom.UserService;
import ${package}.service.dto.user.SearchUser;
import ${package}.service.dto.user.UserDto;
import ${package}.transfer.UserVoTransfer;
import ${package}.vo.base.Response;
import ${package}.vo.user.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: baozi
 * @Date: 2019/6/11 10:05
 * @Description:
 */
@Api("接口: 用户")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("接口: 创建用户")
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    Response createUser(@RequestBody UserVo userVo) {
        UserDto userDto = UserVoTransfer.voToDto(userVo);
        return Response.success(userService.createUser(userDto));
    }

    @ApiOperation("接口: 搜索用户")
    @RequestMapping(method = RequestMethod.GET, value = "/users/search")
    Response getUsers(@RequestBody SearchUser searchUser) {
        return Response.success(userService.getUsers(searchUser));
    }

}