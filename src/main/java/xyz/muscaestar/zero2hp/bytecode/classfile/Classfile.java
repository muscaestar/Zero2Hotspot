package xyz.muscaestar.zero2hp.bytecode.classfile;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.ClassItem;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.classfile.ItemType;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.toU2;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class Classfile {
    private ClassItem magic; // 魔数
    private ClassItem minor_version; // 副版本号
    private ClassItem major_version; // 主版本号
    private ClassItem constant_pool_count; // 常量池计数器
    private ClassItem[] constant_pool; // 常量池
    private ClassItem access_flags; // 访问标志
    private ClassItem this_class; // 类索引
    private ClassItem super_class; // 父类索引
    private ClassItem interfaces_count; // 接口计数器
    private ClassItem[] interfaces; // 接口表
    private ClassItem fields_count; // 字段计数器
    private ClassItem[] fields; // 字段表
    private ClassItem methods_count; // 方法计数器
    private ClassItem[] methods; // 方法表
    private ClassItem attributes_count; // 属性计数器
    private ClassItem[] attributes; // 属性表



    public ClassItem getMagic() {
        return magic;
    }

    public ClassItem getMinor_version() {
        return minor_version;
    }

    public ClassItem getMajor_version() {
        return major_version;
    }

    public ClassItem getConstant_pool_count() {
        return constant_pool_count;
    }

    public ClassItem[] getConstant_pool() {
        return constant_pool;
    }

    public ClassItem getAccess_flags() {
        return access_flags;
    }

    public ClassItem getThis_class() {
        return this_class;
    }

    public ClassItem getSuper_class() {
        return super_class;
    }

    public ClassItem getInterfaces_count() {
        return interfaces_count;
    }

    public ClassItem[] getInterfaces() {
        return interfaces;
    }

    public ClassItem getFields_count() {
        return fields_count;
    }

    public ClassItem[] getFields() {
        return fields;
    }

    public ClassItem getMethods_count() {
        return methods_count;
    }

    public ClassItem[] getMethods() {
        return methods;
    }

    public ClassItem getAttributes_count() {
        return attributes_count;
    }

    public ClassItem[] getAttributes() {
        return attributes;
    }

    public void magic(byte[] val) {
        this.magic = new ClassItem(ItemType.magic);
        this.magic.setMry(val);
    }

    public void minorVer(byte[] val) {
        this.minor_version = new ClassItem(ItemType.minor_version);
        this.minor_version.setMry(val);
    }

    public void majorVer(byte[] val) {
        this.major_version = new ClassItem(ItemType.major_version);
        this.major_version.setMry(val);
    }

    public void cpCount(short cpCount) {
        this.constant_pool_count = new ClassItem(ItemType.constant_pool_count);
        this.constant_pool_count.setMry(toU2(cpCount));
        this.constant_pool = new ClassItem[(int) cpCount];
    }

    public void constantPoolItem(int idx, CpInfo cpInfo) {
        this.constant_pool[idx] = cpInfo;
    }

    public void accFlags(short accFlags) {
        this.access_flags = new ClassItem(ItemType.access_flags);
        this.access_flags.setMry(toU2(accFlags));
    }

    public void thisClass(short thisClass) {
        this.this_class = new ClassItem(ItemType.this_class);
        this.this_class.setMry(toU2(thisClass));
    }

    public void superClass(short superClass) {
        this.this_class = new ClassItem(ItemType.super_class);
        this.this_class.setMry(toU2(superClass));
    }

    public void interfCount(short interfCount) {
        this.interfaces_count = new ClassItem(ItemType.interfaces_count);
        this.interfaces_count.setMry(toU2(interfCount));
        this.interfaces = new ClassItem[(int) interfCount];
    }

    public void interfacesItem(int idx, short val) {
        this.interfaces[idx] = new ClassItem(ItemType.interfaces);
        this.interfaces[idx].setMry(toU2(val));
    }
}
