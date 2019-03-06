package springcloud.client.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springcloud.client.dao.RedPacketMapper;
import springcloud.client.dao.UserRedPacketMapper;
import springcloud.client.entity.RedPacket;
import springcloud.client.entity.UserRedPacket;
import springcloud.client.model.BaseDataModel.ResponseDataModel;

import java.math.BigDecimal;

@Service
public class RedPacketService {

    @Autowired
    private RedPacketMapper redPacketMapper;

    @Autowired
    private UserRedPacketMapper userRedPacketMapper;

    @Transactional
    public String addUserRedPacket(){
        UserRedPacket userRedPacket = new UserRedPacket();
        userRedPacket.setUserId(1);
        userRedPacket.setRedPacketId(1);
        userRedPacketMapper.insert(userRedPacket);
        Gson gson = new Gson();
        return gson.toJson(userRedPacket);
    }

    @Transactional
    public ResponseDataModel grepRedPacket(Integer userId){
        RedPacket redPacket = redPacketMapper.selectByPrimaryKey(1);
        int stock = redPacket.getStock();
        if(stock>0) {//红包个数减一
            redPacket.setStock(stock-1);
            redPacketMapper.updateByPrimaryKey(redPacket);
        }
        UserRedPacket userRedPacket = new UserRedPacket();
        BigDecimal bigDecimal = new BigDecimal(10);
        userRedPacket.setRedPacketId(stock);
        userRedPacket.setAmount(bigDecimal);
        userRedPacket.setUserId(userId);
        userRedPacketMapper.insert(userRedPacket);
        return new ResponseDataModel(true,"抢红包成功");
    }
}
