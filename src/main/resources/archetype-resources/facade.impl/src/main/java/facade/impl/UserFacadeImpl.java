package ${package}.facade.impl;

import ${package}.facade.api.UserFacade;
import ${package}.facade.model.UserFaReq;
import ${package}.facade.transfer.UserFaTransfer;
import ${package}.service.atom.UserService;
import ${package}.service.dto.user.UserDto;
import com.dfocus.mint.web.rsp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    public Response<List<UserFaReq>> testUser(@RequestBody UserFaReq userFaReq) {
        UserFaReq userFaReq1 = new UserFaReq();
        userFaReq1.setAccount("lulu1");
        userFaReq1.setNickName("lulunickname1");

        UserFaReq userFaReq2 = new UserFaReq();
        userFaReq2.setAccount("lulu2");
        userFaReq2.setNickName("lulunickname2");

        List<UserFaReq> userFaReqs = new ArrayList<>();
        userFaReqs.add(userFaReq);
        userFaReqs.add(userFaReq1);
        userFaReqs.add(userFaReq2);
        return Response.success(userFaReqs);
    }
}
