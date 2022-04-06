package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * 定长：8字节
 *
 * @author muscaestar
 */
public class SourceFile_attribute extends AttrInfo {
    private short sourcefile_index; // u2

    @Override
    public void load(byte[] bytes) {
        super.load(bytes);
        this.sourcefile_index = ByteUtil.fromU2(bytes[6], bytes[7]);

    }

    @Override
    public String meta() {
        return null;
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        return super.meta(cpoolFunc) + "sourcefile: " + cpoolFunc.apply(sourcefile_index);
    }
}
