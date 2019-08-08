package ${package}.service;

import ${package}.${classPrefix}ApplicationTests;
import ${package}.service.atom.IMintService;
import ${package}.service.dto.mint.SearchMint;
import ${package}.service.dto.mint.MintDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: baozi
 * @Date: 2019/6/27 11:29
 * @Description:
 */
public class MintServiceTest extends ${classPrefix}ApplicationTests {

    @Autowired
    IMintService mintService;

    @Test
    public void testSearch() {
        SearchMint searchMint = new SearchMint();
        searchMint.setAccount("test1");
        searchMint.setNickName("test2");
        List<MintDto> mints = mintService.getMints(searchMint);
        Assert.assertTrue(mints.size() == 2);
    }
}
