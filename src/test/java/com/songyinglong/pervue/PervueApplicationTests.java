package com.songyinglong.pervue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.songyinglong.pervue.entity.Menu;
import com.songyinglong.pervue.service.IUserService;
import com.songyinglong.pervue.vo.MenuVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class PervueApplicationTests {

    @Resource
    private IUserService userService;


    @Test
    public void test(){
        System.out.println(3|5);
    }
}
