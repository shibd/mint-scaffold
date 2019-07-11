package ${package}.facade.transfer;

import ${package}.facade.model.MintFaReq;
import ${package}.service.dto.mint.MintDto;

/**
 * @Auther: baozi
 * @Date: 2019/6/26 18:36
 * @Description:
 */
public abstract class MintFaTransfer {


    public static MintDto faReqToDto(MintFaReq mintFaReq) {
        MintDto mintDto = new MintDto();
        mintDto.setAccount(mintFaReq.getAccount());
        mintDto.setPassword(mintFaReq.getPassword());
        mintDto.setNickName(mintFaReq.getNickName());
        return mintDto;
    }
}
