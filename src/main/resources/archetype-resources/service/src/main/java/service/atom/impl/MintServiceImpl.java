package ${package}.service.atom.impl;

import ${package}.common.dao.MintMapper;
import ${package}.common.model.po.auto.Mint;
import ${package}.common.model.po.auto.MintExample;
import ${package}.service.atom.MintService;
import ${package}.service.dto.mint.SearchMint;
import ${package}.service.dto.mint.MintDto;
import ${package}.service.transfer.MintDtoTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: baozi
 * @Date: 2019/6/25 15:27
 * @Description:
 */
@Service
public class MintServiceImpl implements MintService {

    @Autowired
    MintMapper mintDao;

    @Override
    public boolean createMint(MintDto mintDto) {
        Mint mint = MintDtoTransfer.dtoTransPo(mintDto);
        int id = mintDao.insert(mint);
        return id > 0;
    }

    @Override
    public List<MintDto> getMints(SearchMint searchMint) {
        MintExample mintExample = new MintExample();
        mintExample.createCriteria()
                .andAccountEqualTo(searchMint.getAccount())
                .andNickNameEqualTo(searchMint.getNickName());

        List<MintDto> mintDtos = new ArrayList<>();
        List<Mint> mints = mintDao.selectByExample(mintExample);
        mints.forEach(mint -> mintDtos.add(MintDtoTransfer.poTransDto(mint)));
        return mintDtos;
    }

    /**
     * todo 简单mock数据
     * 目前还没有引入分页插件
     * 待替换mybatis和选型分页插件
     * 计划：
     * 1. mybatis-plus + spring common
     * 2. mybatis + PageHelper
     */
    @Override
    public Page<MintDto> listMints(Pageable pageable) {
        List<MintDto> mintDtos = new ArrayList<>();
        List<Mint> mints = mintDao.selectByExample(null);
        mints.forEach(mint -> mintDtos.add(MintDtoTransfer.poTransDto(mint)));
        return new PageImpl<>(mintDtos);
    }
}
