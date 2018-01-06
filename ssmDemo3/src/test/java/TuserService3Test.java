import com.bdqn.entity.Tuser3;
import com.bdqn.service.TuserService3;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TuserService3Test {
    @Resource
    private TuserService3 tuserService3;
    @Test
    public void login() throws Exception {
        Tuser3 tuser3 = new Tuser3();
        tuser3.setUserName("admin");
        tuser3.setPassword("abc");
        Tuser3 user = tuserService3.login(tuser3);
        System.out.println(user);
    }

    @Test
    public void queryAll() {
        PageInfo<Tuser3> pageInfo = tuserService3.queryAll(1, 2);
        List<Tuser3> list = pageInfo.getList();
        if (list != null) {
            for (Tuser3 tuser3 : list) {
                System.out.println(tuser3);
            }
        }
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("当前页：" + pageInfo.getPageNum());
    }

    @Test
    public void test() {
        String str = "Hello ACCP";
        String str1 = new String("Hello ACCP");
        System.out.println(str == str1);
    }

}