package QAQ1;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.configuration.tree.ConfigurationNode;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;


public class Main {
    @Test
    public void testXML() throws Exception {
//        HierarchicalConfiguration hc = new HierarchicalConfiguration();
        XMLConfiguration cfg = new XMLConfiguration("D:\\Workspace\\ForJavaTest\\normal\\src\\main\\resources\\wzw.xml");
        // 配置文件 发生变化就重新加载
        cfg.setReloadingStrategy(new FileChangedReloadingStrategy());
        System.out.println("RootElementName:" + cfg.getRootElementName());
        List<HierarchicalConfiguration> components = cfg.configurationsAt("components");
        HierarchicalConfiguration hc = components.get(0);
        List<ConfigurationNode> children = hc.getRootNode().getChildren();
//        for (ConfigurationNode child : children) {
//            System.out.println(child.getName());
//            System.out.println(child.getValue());
//        }

        Iterator<String> keys = cfg.getKeys();

        while (keys.hasNext()) {
            String next = keys.next();
            System.out.println(next + "-->" + cfg.getList(next));

        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    public @interface Gg{
        String value();
    }
    class Xx{
        @Gg("哈哈哈")
        public Integer a;
//        protected Map<String,Double> b = null;
        private Integer c;
    }
    @Test
    public void testReflect() throws Exception {

        Xx xx = new Xx();
        Field a = xx.getClass().getDeclaredField("a");
        Gg gg = a.getAnnotation(Gg.class);
        System.out.println(gg.value());
        a.setAccessible(true);
        a.set(xx,1);
        System.out.println(xx.a);
    }
}
