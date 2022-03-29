package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;
import static xyz.muscaestar.zero2hp.utils.LogUtil.Log;

/**
 * Created by muscaestar on 3/28/22
 *
 * @author muscaestar
 */
public class ConstantManager {
    private static final Map<Class<? extends CpInfo>, BiFunction<StringBuilder, CpInfo, Short>> map;

    static {
        map = new HashMap<>();
        map.put(CONSTANT_Class_info.class, (sb, info) -> {
            CONSTANT_Class_info cpInfo = (CONSTANT_Class_info) info;
            sb.append("(Class_info) -> #").append(toUint(cpInfo.getName_index()));
            return cpInfo.getName_index();
        });
        map.put(CONSTANT_Utf8_info.class, (sb, info) -> {
            CONSTANT_Utf8_info cpInfo = (CONSTANT_Utf8_info) info;
            sb.append("(Utf8_info)=").append(cpInfo.value());
            return null;
        });
        map.put(CONSTANT_Integer_info.class, (sb, info) -> {
            CONSTANT_Integer_info cpInfo = (CONSTANT_Integer_info) info;
            sb.append("(Integer_info)=").append(cpInfo.value());
            return null;
        });
        map.put(CONSTANT_Long_info.class, (sb, info) -> {
            CONSTANT_Long_info cpInfo = (CONSTANT_Long_info) info;
            sb.append("(Long_info)=").append(cpInfo.value());
            return null;
        });
        map.put(CONSTANT_Float_info.class, (sb, info) -> {
            CONSTANT_Float_info cpInfo = (CONSTANT_Float_info) info;
            sb.append("(Float_info)=").append(cpInfo.value());
            return null;
        });
        map.put(CONSTANT_Double_info.class, (sb, info) -> {
            CONSTANT_Double_info cpInfo = (CONSTANT_Double_info) info;
            sb.append("(Double_info)=").append(cpInfo.value());
            return null;
        });
    }

    private CpInfo[] cpool;

    public ConstantManager(CpInfo[] cpool) {
        this.cpool = cpool;
    }

    public String findAll(short idx) {
        return this.findAll(toUint(idx));
    }

    public String findAll(int idx) {
        final StringBuilder sb = new StringBuilder();
        sb.append("#").append(idx);
        CpInfo cpInfo = cpool[idx];
        final BiFunction<StringBuilder, CpInfo, Short> func = map.get(cpInfo.getClass());
        if (func == null) {
            Log.error("此常量尚无法向下追踪：" + cpInfo.getClass().getSimpleName());
            System.exit(9);
        }
        Short next = func.apply(sb, cpInfo);
        while (next != null) {
            cpInfo = cpool[next];
            final BiFunction<StringBuilder, CpInfo, Short> nextFunc = map.get(cpInfo.getClass());
            if (nextFunc == null) {
                Log.error("此常量尚无法向下追踪：" + cpInfo.getClass().getSimpleName());
                System.exit(9);
            }
            next = nextFunc.apply(sb, cpInfo);
        }
        return sb.toString();
    }

    public String findUtf8(int idx) {
        final CpInfo cpInfo = cpool[idx];
        assert(cpInfo instanceof CONSTANT_Utf8_info);
        return ((CONSTANT_Utf8_info) cpInfo).value();
    }
}
