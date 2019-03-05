package springcloud.client.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import springcloud.client.entity.RedPackets;

import java.util.HashMap;

@Mapper
public interface RedPacketsDao {
    @Select("SELECT * FROM red_packets WHERE id = #{id}")
    public RedPackets findAll(String id);
    @Insert("INSERT INTO red_packets(name, count) VALUES(#{name}, #{count})")
    public int insertRedPackets(HashMap<String, Object> map);

}
