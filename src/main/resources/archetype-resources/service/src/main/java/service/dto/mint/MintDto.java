package ${package}.service.dto.mint;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: baozi
 * @Date: 2019/6/25 11:27
 * @Description:
 */
@Data
@ToString
public class MintDto {
    /**
     * 账号
     */
    @NotEmpty(message = "公司名称不能为空")
    private String account;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

    /**
     * 昵称
     */
    private String nickName;
}
