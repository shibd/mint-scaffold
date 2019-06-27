package ${package}.vo.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页信息
 *
 * @author yehao
 * @date 2019-04-28 17:24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 每页大小
     */
    private Integer size;

    /**
     * 总页数
     */
    private Integer totalPage;
}
