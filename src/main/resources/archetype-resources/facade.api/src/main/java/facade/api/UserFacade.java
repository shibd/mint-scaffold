package ${package}.facade.api;

import ${package}.facade.model.UserFaReq;
import com.dfocus.mint.web.rsp.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: baozi
 * @Date: 2019/6/11 10:05
 * @Description:
 */
@RequestMapping("/facade/user")
public interface UserFacade {
    @RequestMapping(method = RequestMethod.POST)
    Response<List<UserFaReq>> testUser(@RequestBody UserFaReq userFaReq);
}
