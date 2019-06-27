package ${package}.service.dto.user;

import lombok.Data;

/**
 * @Auther: baozi
 * @Date: 2019/6/27 11:14
 * @Description:
 */
@Data
public class SearchUser {
    /**
     * 账号
     */
    private String account;

    /**
     * 昵称
     */
    private String nickName;
}
