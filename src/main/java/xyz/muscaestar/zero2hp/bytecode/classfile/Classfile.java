package xyz.muscaestar.zero2hp.bytecode.classfile;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.ClassItem;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.SimpleItem;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.field.FieldInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.classfile.ItemType;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.toU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class Classfile {
    private SimpleItem magic; // 魔数
    private SimpleItem minor_version; // 副版本号
    private SimpleItem major_version; // 主版本号
    private SimpleItem constant_pool_count; // 常量池计数器
    private CpInfo[] constant_pool; // 常量池
    private SimpleItem access_flags; // 访问标志
    private SimpleItem this_class; // 类索引
    private SimpleItem super_class; // 父类索引
    private SimpleItem interfaces_count; // 接口计数器
    private SimpleItem[] interfaces; // 接口表
    private SimpleItem fields_count; // 字段计数器
    private FieldInfo[] fields; // 字段表
    private SimpleItem methods_count; // 方法计数器
    private ClassItem[] methods; // 方法表
    private SimpleItem attributes_count; // 属性计数器
    private ClassItem[] attributes; // 属性表

    public SimpleItem getMagic() {
        return magic;
    }

    public SimpleItem getMinor_version() {
        return minor_version;
    }

    public SimpleItem getMajor_version() {
        return major_version;
    }

    public SimpleItem getConstant_pool_count() {
        return constant_pool_count;
    }

    public CpInfo[] getConstant_pool() {
        return constant_pool;
    }

    public SimpleItem getAccess_flags() {
        return access_flags;
    }

    public SimpleItem getThis_class() {
        return this_class;
    }

    public SimpleItem getSuper_class() {
        return super_class;
    }

    public SimpleItem getInterfaces_count() {
        return interfaces_count;
    }

    public SimpleItem[] getInterfaces() {
        return interfaces;
    }

    public SimpleItem getFields_count() {
        return fields_count;
    }

    public FieldInfo[] getFields() {
        return fields;
    }

    public SimpleItem getMethods_count() {
        return methods_count;
    }

    public ClassItem[] getMethods() {
        return methods;
    }

    public SimpleItem getAttributes_count() {
        return attributes_count;
    }

    public ClassItem[] getAttributes() {
        return attributes;
    }

    public void magic(byte[] val) {
        assert(val.length == 4);
        this.magic = new SimpleItem(ItemType.magic);
        this.magic.load(val);
    }

    public void minorVer(byte[] val) {
        assert(val.length == 2);
        this.minor_version = new SimpleItem(ItemType.minor_version);
        this.minor_version.load(val);
    }

    public void majorVer(byte[] val) {
        assert(val.length == 2);
        this.major_version = new SimpleItem(ItemType.major_version);
        this.major_version.load(val);
    }

    public void cpCount(short cpCount) {
        this.constant_pool_count = new SimpleItem(ItemType.constant_pool_count);
        this.constant_pool_count.load(toU2(cpCount));
        this.constant_pool = new CpInfo[toUint(cpCount)];
    }

    public void constantPoolItem(int idx, CpInfo cpInfo) {
        this.constant_pool[idx] = cpInfo;
    }

    public void accFlags(byte[] val) {
        assert(val.length == 2);
        this.access_flags = new SimpleItem(ItemType.access_flags);
        this.access_flags.load(val);
    }

    public void thisClass(byte[] val) {
        assert(val.length == 2);
        this.this_class = new SimpleItem(ItemType.this_class);
        this.this_class.load(val);
    }

    public void superClass(byte[] val) {
        assert(val.length == 2);
        this.super_class = new SimpleItem(ItemType.super_class);
        this.super_class.load(val);
    }

    public void interfCount(short interfCount) {
        this.interfaces_count = new SimpleItem(ItemType.interfaces_count);
        this.interfaces_count.load(toU2(interfCount));
        this.interfaces = new SimpleItem[toUint(interfCount)];
    }

    public void interfacesItem(int idx, short val) {
        this.interfaces[idx] = new SimpleItem(ItemType.interfaces);
        this.interfaces[idx].load(toU2(val));
    }

    public void fieldsCount(short fieldsCount) {
        this.fields_count = new SimpleItem(ItemType.fields_count);
        this.fields_count.load(toU2(fieldsCount));
        this.fields = new FieldInfo[toUint(fieldsCount)];
    }

    public void fieldsItem(int idx, byte[] val) {
        this.fields[idx] = new FieldInfo();
        this.fields[idx].load(val);
    }
}
