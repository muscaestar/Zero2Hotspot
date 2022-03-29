package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;

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

    }

    @Override
    public String meta() {
        return null;
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        return null;
    }
}
