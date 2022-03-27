package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct.CONSTANT_Class_info;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct.CONSTANT_Utf8_info;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 3/28/22
 *
 * @author muscaestar
 */
public class ConstantManager {
    private static final Map<Class<? extends CpInfo>, BiFunction<StringBuilder, CpInfo, Short>> map;

    static {
        map = new HashMap<>();
        map.put(CONSTANT_Class_info.class, new BiFunction<StringBuilder, CpInfo, Short>() {
            @Override
            public Short apply(StringBuilder sb, CpInfo info) {
                CONSTANT_Class_info cpInfo = (CONSTANT_Class_info) info;
                sb.append("(Class_info) -> #").append(toUint(cpInfo.getName_index()));
                return cpInfo.getName_index();
            }
        });
        map.put(CONSTANT_Utf8_info.class, new BiFunction<StringBuilder, CpInfo, Short>() {
            @Override
            public Short apply(StringBuilder sb, CpInfo info) {
                CONSTANT_Utf8_info cpInfo = (CONSTANT_Utf8_info) info;
                sb.append("(Utf8_info)=").append(cpInfo.value());
                return null;
            }
        });
    }

    private CpInfo[] cpool;

    public ConstantManager(CpInfo[] cpool) {
        this.cpool = cpool;
    }

    public String findAll(int idx) {
        final StringBuilder sb = new StringBuilder();
        sb.append("#").append(idx);
        CpInfo cpInfo = cpool[idx];
        Short next = map.get(cpInfo.getClass()).apply(sb, cpInfo);
        while (next != null) {
            cpInfo = cpool[next];
            next = map.get(cpInfo.getClass()).apply(sb, cpInfo);
        }
        return sb.toString();
    }

    public String findUtf8(int idx) {
        final CpInfo cpInfo = cpool[idx];
        assert(cpInfo instanceof CONSTANT_Utf8_info);
        return ((CONSTANT_Utf8_info) cpInfo).value();
    }
}
