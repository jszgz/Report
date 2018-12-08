package mapper;

import com.chwangteng.www.mapper.*;
import com.chwangteng.www.pojo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class UserTest {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private LaboratoryMapper labMapper;

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private MotificationMapper motificationMapper;

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
//        int rows = labMapper.deleteByPrimaryKey(100);
//        System.out.println(rows);


        studentMapper.selectByPrimaryKey(1);
    }


    @Test
    @Transactional
    public  void testselectbyprimarykey(){
        Laboratory lab= labMapper.selectByPrimaryKey(2);
        System.out.println(lab==null);
    }

    @Test
    @Transactional
    public  void testceratecriteria(){
        LaboratoryExample laboratoryExample = new LaboratoryExample();
        laboratoryExample.createCriteria();
        System.out.println(labMapper.selectByExample(laboratoryExample));
    }


    @Test
    @Transactional
    public  void getreport(){
        ReportWithBLOBs reportWithBLOBs =  reportMapper.selectByPrimaryKey(1);
    }


    @Test
    @Transactional
    public  void testnoti(){
        MotificationExample motificationExample = new MotificationExample();
        motificationExample.createCriteria();

        List records = motificationMapper.selectByExample(motificationExample);
    }

;
}
