package ${package}.service.compose.impl;

import ${package}.service.atom.MintService;
import ${package}.service.compose.XXXComposeService;
import ${package}.service.dto.mint.SearchMint;
import ${package}.service.dto.mint.MintDto;
import ${package}.service.kafka.XXXSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: baozi
 * @Date: 2019/6/26 18:35
 * @Description:
 */
@Service
public class XXXComposeServiceImpl implements XXXComposeService {


    @Autowired
    MintService mintService;

    @Autowired
    XXXSender xxxSender;

    @Override
    public List<MintDto> testComposeSearchMint(SearchMint searchMint) {
        return mintService.getMints(searchMint);
    }

    @Override
    public List<MintDto> testComposeSearchMintAndSendEvent(SearchMint searchMint) {
        xxxSender.send(searchMint.getAccount());
        return mintService.getMints(searchMint);
    }
}
