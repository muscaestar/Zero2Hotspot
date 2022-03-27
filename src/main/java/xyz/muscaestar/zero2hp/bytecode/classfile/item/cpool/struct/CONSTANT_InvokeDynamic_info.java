package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;

/**
 * 表示invokedynamic指令所用到的引导方法（bootstrap method）、引导方法所用到的
 * 动态调用名称（dynamic invocation name）、参数和返回类型，并可以给引导方法传入一系列
 * 称为静态参数（static argument）的常量
 *
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CONSTANT_InvokeDynamic_info extends CpInfo {
    /**
     * 必须是对当前class文件中引导方法表的bootstrap_methods数组的有效索引
     */
    private short bootstrap_method_attr_index; // u2

    /**
     * 常量池的有效索引，索引处项必须是CONSTANT_NameAndType_info结构
     */
    private short name_and_type_index; // u2

    public CONSTANT_InvokeDynamic_info() {
        super(CpTag.CONSTANT_InvokeDynamic);
    }

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
