package springcloud.client.dao;

import org.springframework.stereotype.Component;
import springcloud.client.entity.UserRedPacket;

@Component
public interface UserRedPacketMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserRedPacket record);

    int insertSelective(UserRedPacket record);

    UserRedPacket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRedPacket record);

    int updateByPrimaryKey(UserRedPacket record);
}