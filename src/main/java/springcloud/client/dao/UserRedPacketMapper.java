package springcloud.client.dao;

import org.springframework.stereotype.Component;
import springcloud.client.entity.UserRedPacket;

/**
 * @author hezy
 */
@Component
public interface UserRedPacketMapper {
    /**
     * delete
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert
     * @param record
     * @return
     */
    int insert(UserRedPacket record);

    /**
     * insert
     * @param record
     * @return
     */
    int insertSelective(UserRedPacket record);

    /**
     * select
     * @param id
     * @return
     */
    UserRedPacket selectByPrimaryKey(Integer id);

    /**
     * update
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserRedPacket record);

    /**
     * update
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserRedPacket record);
}