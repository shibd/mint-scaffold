package ${package}.service.atom;


import ${package}.service.dto.mint.SearchMint;
import ${package}.service.dto.mint.MintDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther: baozi
 * @Date: 2019/6/25 14:57
 * @Description:
 */
public interface MintService {
    /**
     * 创建mint
     * @param mintDto
     * @return
     */
    boolean createMint(MintDto mintDto);

    /**
     * 搜索用户
     * @param searchMint
     * @return
     */
    List<MintDto> getMints(SearchMint searchMint);

    /**
     * 分页用户
     * @return
     */
    Page<MintDto> listMints(Pageable pageable);
}