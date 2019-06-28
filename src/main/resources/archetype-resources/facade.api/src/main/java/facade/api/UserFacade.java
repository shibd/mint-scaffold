package ${package}.facade.api;

import ${package}.facade.model.UserFaReq;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: baozi
 * @Date: 2019/6/11 10:05
 * @Description:
 */
@RequestMapping("/facade/user")
public interface UserFacade {
    @RequestMapping(method = RequestMethod.POST)
    boolean createUser(@RequestBody UserFaReq userFaReq);
}
