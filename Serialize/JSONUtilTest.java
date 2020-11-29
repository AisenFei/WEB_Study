

import org.example.util.JSONUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JSONUtilTest {
    @Test
    public void testSerialize() {
        //测试序列化操作：使用map模拟复杂
        Map map = new HashMap();
        map.put("name", "java40班");
        map.put("students", new int[]{1, 2});
        String json = JSONUtil.serialize(map);
        System.out.println(json);
        Assert.assertNotNull(json);
    }

    @Test
    public void testDeserialize() {
        //类加载器加载某个资源，返回输入流
        InputStream is = JSONUtilTest.class.getClassLoader()
                .getResourceAsStream("login.json");
        Map map = JSONUtil.deserialize(is, Map.class);
        System.out.println(map);
        Assert.assertNotNull(map);
    }
}
