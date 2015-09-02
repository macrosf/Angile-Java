package example.collection;

import java.util.EnumSet;

//import java.util.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.collection.EnumMapExample.NBA;

/**
 *
 * EnumSet example
 *
 * <pre>
 * 1.public abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E>
 *     implements Cloneable, java.io.Serializable
 * 2.其内部元素为枚举,另外可以看到其是一个抽象类abstract
 * 3.其在内部表示为位向量,足以用作传统上基于 int 的“位标志”的替换形式.(即类似0x1000000,按bit存储,用位运算进行相关操作)
 * 4. public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
 *         Enum[] universe = getUniverse(elementType);
 *         if (universe == null)
 *             throw new ClassCastException(elementType + " not an enum");
 *
 *         if (universe.length <= 64)
 *             return new RegularEnumSet<>(elementType, universe);
 *         else
 *             return new JumboEnumSet<>(elementType, universe);
 *     }
 *     从源码上看:即根据传入的枚举类型判断组成长度,64以内则返回RegularEnumSet,否则JumboEnumSet
 * 5.从其内部API方法看,全部是静态方法static.
 * 6.以RegularEnumSet内部方法实现:
 * public boolean add(E e) {
 *         typeCheck(e);
 *         // elements默认为0
 *         long oldElements = elements;
 *         elements |= (1L << ((Enum)e).ordinal());
 *         return elements != oldElements;
 *     }
 *  从add源码上看:1.取枚举值的ordinal,初始为0. 2.1 << ordinal 3.与elements做|运算
 *  举例:a.添加ordinal为0,则计算后elements为1
 *     b.添加ordinal为1,则计算后elements为(10 | 01) = 11
 *     c.添加ordinal为2,则计算后elements为(011 | 100) = 111
 *   ->所以从源码上看,其就是用一个long来存储枚举.你懂得(long是64位).
 *
 *   public boolean contains(Object e) {
 *         if (e == null)
 *             return false;
 *         Class eClass = e.getClass();
 *         if (eClass != elementType && eClass.getSuperclass() != elementType)
 *             return false;
 *
 *         return (elements & (1L << ((Enum)e).ordinal())) != 0;
 *     }
 *     从contains源码上看:最重要的是最好一句:(elements & (1L << ((Enum)e).ordinal())) != 0
 *         1.1L << ((Enum)e).ordinal()
 *         2.与elements做&运算
 *        举例:如果ordinal为2,则通过第一步计算值为4(100) & 111(之前已经添加过ordinal为2的元素，高位至1)
 *        ->则高位肯定为1,则表示有这个元素
 *         总结：利用一个long和位运算实现EnumSet的快速存储和判断.
 *  7.至于JumboEnumSet的内部实现:则是用一个long elements[]实现，只是对long的扩展,其实现细节差不太多，这里不详述了
 * </pre>
 *
 * @author landon
 *
 */
public class EnumSetExample {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EnumSetExample.class);

    public static void main(String[] args) {

    	// allOf:一个包含指定元素类型的所有元素的枚举 set
        EnumSet<NBA> allofEnumSet = EnumSet.allOf(NBA.class);
        // [allofEnumSet:[MAVS, LAKERS, PACERS]]
        LOGGER.debug("allofEnumSet:{}", allofEnumSet);

        // noneOf:创建一个具有指定元素类型的空枚举 set
        EnumSet<NBA> noneofEnumSet = EnumSet.noneOf(NBA.class);
        // 添加一个元素
        noneofEnumSet.add(NBA.LAKERS);
        // [noneofEnumSet:[LAKERS]]
        LOGGER.debug("noneofEnumSet:{}", noneofEnumSet);

        // complementOf:取补
        EnumSet<NBA> complementOfEnumSet = EnumSet.complementOf(noneofEnumSet);
        // [[complementOfEnumSet:[MAVS, PACERS]]
        LOGGER.debug("complementOfEnumSet:{}", complementOfEnumSet);

        // copyof:拷贝
        EnumSet<NBA> copyofEnumSet = EnumSet.copyOf(complementOfEnumSet);
        // [copyofEnumSet:[MAVS, PACERS]]
        LOGGER.debug("copyofEnumSet:{}", copyofEnumSet);

        // of(E e):最初包含指定元素的枚举 set
        EnumSet<NBA> ofEnumSet = EnumSet.of(NBA.PACERS);
        LOGGER.debug("ofEnumSet:{}", ofEnumSet);

        // of(E first,E rest)
        NBA[] nbas = new NBA[] { NBA.LAKERS, NBA.MAVS, NBA.PACERS };
        EnumSet<NBA> ofEnumSet2 = EnumSet.of(NBA.PACERS, nbas);
        // 从输出可以可以看到:是按照枚举的ordinal顺序输出的
        LOGGER.debug("ofEnumSet2:{}", ofEnumSet2);

        // range(E from, E to) [from,to]
        EnumSet<NBA> rangeEnumSet = EnumSet.range(NBA.MAVS, NBA.PACERS);
        LOGGER.debug("rangeEnumSet:{}", rangeEnumSet);

        // Exception in thread "main" java.lang.IllegalArgumentException: PACERS
        // > LAKERS
        // 抛出了异常,所以from和to的顺序不能颠倒(按照枚举的ordinal顺序)
        EnumSet<NBA> rangeEnumSet2 = EnumSet.range(NBA.PACERS, NBA.LAKERS);
        LOGGER.debug("rangeEnumSet2:{}", rangeEnumSet2);
    }

}

