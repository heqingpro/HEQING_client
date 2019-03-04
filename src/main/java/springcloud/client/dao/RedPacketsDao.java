package springcloud.client.dao;

import org.apache.ibatis.annotations.Mapper;
import springcloud.client.entity.RedPackets;

import java.util.HashMap;

@Mapper
public interface RedPacketsDao {
    public RedPackets findAll(String id);

    public int insertRedPackets(HashMap<String, Object> map);

}
