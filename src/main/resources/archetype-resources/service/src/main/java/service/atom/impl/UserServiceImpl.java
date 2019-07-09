package ${package}.service.atom.impl;

import ${package}.common.dao.UserMapper;
import ${package}.common.model.po.auto.User;
import ${package}.common.model.po.auto.UserExample;
import ${package}.service.atom.UserService;
import ${package}.service.dto.user.SearchUser;
import ${package}.service.dto.user.UserDto;
import ${package}.service.transfer.UserDtoTransfer;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userDao;

    @Override
    public boolean createUser(UserDto userDto) {
        User user = UserDtoTransfer.dtoTransPo(userDto);
        int id = userDao.insert(user);
        return id > 0;
    }

    @Override
    public List<UserDto> getUsers(SearchUser searchUser) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountEqualTo(searchUser.getAccount())
                .andNickNameEqualTo(searchUser.getNickName());

        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userDao.selectByExample(userExample);
        users.forEach(user -> userDtos.add(UserDtoTransfer.poTransDto(user)));
        return userDtos;
    }

    @Override
    public Page<UserDto> listUsers(Pageable pageable) {
        return null;
    }
}
