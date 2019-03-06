package springcloud.client.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcloud.client.dao.UserRedPacketMapper;
import springcloud.client.entity.UserRedPacket;

@Service
public class RedPacketService {

    @Autowired
    private UserRedPacketMapper userRedPacketMapper;

    public String addUserRedPacket(){
        UserRedPacket userRedPacket = new UserRedPacket();
        userRedPacket.setUserId(1);
        userRedPacket.setRedPacketId(1);
        userRedPacketMapper.insert(userRedPacket);
        Gson gson = new Gson();
        return gson.toJson(userRedPacket);
    }
}
