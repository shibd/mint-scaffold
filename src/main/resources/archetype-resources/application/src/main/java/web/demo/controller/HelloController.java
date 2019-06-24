package ${package}.web.demo.controller;

import com.dfocus.jm.sync.service.SysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: baozi
 * @Date: 2019/6/11 10:05
 * @Description:
 */
@Api("接口: 测试")
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @Autowired
    SysConfigService sysConfigService;

    @ApiOperation("接口: 测试接口")
    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "hello world";
    }
}
