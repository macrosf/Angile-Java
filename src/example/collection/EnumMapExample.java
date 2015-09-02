package example.collection;

import java.util.Collection;
import java.util.EnumMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * EnumMap example
 *
 * <pre>
 * 1.public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V>
 *     implements java.io.Serializable, Cloneable
 * 2.可见EnumMap的key是一个枚举
 * 3.枚举映射在内部表示为数组
 * 4. public V put(K key, V value) {
 *         typeCheck(key);
 *
 *         int index = key.ordinal();
 *         Object oldValue = vals[index];
 *         vals[index] = maskNull(value);
 *         if (oldValue == null)
 *             size++;
 *         return unmaskNull(oldValue);
 *     }
 *     从put的源码可以看到,是利用Enum的ordinal作为数组的索引.所以实现紧凑且高效
 * </pre>
 *
 * @author landon
 *
 */
public class EnumMapExample {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EnumMapExample.class);

    /**
     *
     * Nba球队枚举，分别是小牛,湖人,步行者
     *
     * @author landon
     *
     */
    static enum NBA {
        MAVS, LAKERS, PACERS,
    }

    public static void main(String[] args) {
        // 构造函数public EnumMap(Class<K> keyType),参数表示key类型
        // 泛型只是编译起作用
        EnumMap<NBA, String> em = new EnumMap<NBA, String>(NBA.class);

        // put顺序不是根据枚举的ordinal顺序
        em.put(NBA.LAKERS, "kobe");
        em.put(NBA.MAVS, "dirk");
        em.put(NBA.PACERS, "miller");

        // get方法会首先检查参数的class是否valid(与keyTypeClass对比)
        LOGGER.debug("mavs_player:{}", em.get(NBA.MAVS));

        // 类型检查失败则返回null
        LOGGER.debug("mavs_player:{}", em.get("mavs"));

        Collection<String> values = em.values();
        // 从输出可以看到,视图的内部顺序是枚举定义的顺序.
        // 输出em.values:[dirk, kobe, miller]
        LOGGER.debug("em.values:{}", values.toString());

        // 抛出空指针异常Exception in thread "main" java.lang.NullPointerException
        // 所以key不允许为null
        em.put(null, "tmac");
    }
}

