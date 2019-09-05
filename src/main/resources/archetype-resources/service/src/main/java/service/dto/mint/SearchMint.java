package ${package}.service.dto.mint;

import lombok.Data;

/**
 * @Author: baozi
 * @Date: 2019/6/27 11:14
 * @Description:
 */
@Data
public class SearchMint {
    /**
     * 账号
     */
    private String account;

    /**
     * 昵称
     */
    private String nickName;
}
