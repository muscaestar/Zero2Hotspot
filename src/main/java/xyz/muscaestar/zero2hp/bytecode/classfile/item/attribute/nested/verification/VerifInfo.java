package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification;

import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;

import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * 核查类型
 *
 * @author muscaestar
 */
public abstract class VerifInfo {
    protected byte tag; // u1

    public String meta(Function<Short, String> cpoolFunc) {
        final VerifType resolve = VerifType.resolve(tag);
        return "核查类型: " + resolve.name() + "; ";
    }
}

