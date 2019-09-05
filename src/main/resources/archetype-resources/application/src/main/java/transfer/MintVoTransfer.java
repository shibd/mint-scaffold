package ${package}.transfer;

import ${package}.service.dto.mint.MintDto;
import ${package}.vo.mint.MintVo;

/**
 * @Author: baozi
 * @Date: 2019/6/27 11:01
 * @Description:
 */
public abstract class MintVoTransfer {

    public static MintDto voToDto(MintVo mintVo) {
        MintDto mintDto = new MintDto();
        mintDto.setAccount(mintVo.getAccount());
        mintDto.setPassword(mintVo.getPassword());
        mintDto.setNickName(mintVo.getNickName());
        return mintDto;
    }

    public static MintVo dtoToVo(MintDto mintDto) {
        MintVo  mintVo  = new MintVo ();
        mintVo.setAccount(mintDto.getAccount());
        mintVo.setPassword(mintDto.getPassword());
        mintVo.setNickName(mintDto.getNickName());
        return mintVo;
    }
}
