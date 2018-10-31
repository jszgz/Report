package mapper;

import com.mayousheng.www.mapper.LaboratoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class UserTest {
/*    @Autowired
    private UserMapper usermapper;*/

    @Autowired
    private LaboratoryMapper labMapper;

    //test want will return if the insetion was not success
    @Test
    @Transactional
    public void testInsertUser() throws Exception {
/*        User u=new User();
        u.setUserPhone("17816875157");
        u.setUserPasswordHash("123456");
        u.setUserRegistTime(new Date());
        u.setUserLastLoginTime(new Date());
        u.setNickName("nockname");
        u.setAvatar("avatar");
        u.setToken("testtoken");
        System.out.println("teststart");
        usermapper.insertSelective(u);
        System.out.println("1313123123");
        System.out.println("1313123123");*/
    }

    @Test
    @Transactional
    public void testSelectUser() throws Exception {
/*        User u=new User();
        u.setUserPhone("123456");

        System.out.println(usermapper.selectByPrimaryKey(11));
        System.out.println("1313123123");
        System.out.println("1313123123");*/
    }

    @Test
    @Transactional
    public void testdeletenotfound(){


        int rows = labMapper.deleteByPrimaryKey(100);
        System.out.println(rows);
    }

}
