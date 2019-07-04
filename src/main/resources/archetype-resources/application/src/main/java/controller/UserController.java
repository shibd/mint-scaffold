package ${package}.controller;

import ${package}.service.atom.UserService;
import ${package}.service.dto.user.SearchUser;
import ${package}.service.dto.user.UserDto;
import ${package}.transfer.UserVoTransfer;
import ${package}.vo.user.UserVo;
import com.dfocus.mint.web.rsp.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    Response<Boolean> createUser(@RequestBody UserVo userVo) {
        UserDto userDto = UserVoTransfer.voToDto(userVo);
        return Response.success(userService.createUser(userDto));
    }

    @ApiOperation("接口: 搜索用户")
    @RequestMapping(method = RequestMethod.GET, value = "/users/search")
    Response<List<UserVo>> getUsers(@RequestBody SearchUser searchUser) {
        List<UserVo> userVos = new ArrayList<>();
        List<UserDto> users = userService.getUsers(searchUser);
        users.forEach(userDto -> userVos.add(UserVoTransfer.dtoToVo(userDto)));
        return Response.success(userVos);
    }

    @ApiOperation("接口: 分页列表")
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    Response<Page<UserVo>> list(Pageable pageable) {
        Page<UserDto> users = userService.listUsers(pageable);
        return Response.success(users.map(UserVoTransfer::dtoToVo));
    }

}