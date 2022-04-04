package xyz.muscaestar.zero2hp.bytecode.factory;

import javafx.util.Pair;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe.*;
import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.FrameType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.FrameType.*;
import static xyz.muscaestar.zero2hp.utils.LogUtil.Log;

/**
 * Created by muscaestar on 4/3/22
 *
 * @author muscaestar
 */
public class FrameTypeFactory {
    private static final Map<FrameType, BiFunction<byte[], Integer, Pair<StackMapFrame, Integer>>> typeToFunc = new HashMap<>();

    static {
        typeToFunc.put(SAME, (bytes, offset) -> {
            final Same_frame same_frame = new Same_frame();
            final int load = same_frame.load(bytes, offset);
            return new Pair<>(same_frame, load);
        });
        typeToFunc.put(SAME_LOCALS_1_STACK_ITEM, (bytes, offset) -> {
            final Same_locals_1_stack_item_frame same_locals_1_stack_item_frame = new Same_locals_1_stack_item_frame();
            final int load = same_locals_1_stack_item_frame.load(bytes, offset);
            return new Pair<>(same_locals_1_stack_item_frame, load);
        });
        typeToFunc.put(SAME_LOCALS_1_STACK_ITEM_EXTENDED, (bytes, offset) -> {
            final Same_locals_1_stack_item_frame_extended same_locals_1_stack_item_frame_extended = new Same_locals_1_stack_item_frame_extended();
            final int load = same_locals_1_stack_item_frame_extended.load(bytes, offset);
            return new Pair<>(same_locals_1_stack_item_frame_extended, load);

        });
        typeToFunc.put(CHOP, (bytes, offset) -> {
            final Chop_frame chop_frame = new Chop_frame();
            final int load = chop_frame.load(bytes, offset);
            return new Pair<>(chop_frame, load);
        });
        typeToFunc.put(SAME_FRAME_EXTENDED, (bytes, offset) -> {
            final Same_frame_extended same_frame_extended = new Same_frame_extended();
            final int load = same_frame_extended.load(bytes, offset);
            return new Pair<>(same_frame_extended, load);
        });
        typeToFunc.put(APPEND, (bytes, offset) -> {
            final Append_frame append_frame = new Append_frame();
            final int load = append_frame.load(bytes, offset);
            return new Pair<>(append_frame, load);
        });
        typeToFunc.put(FULL_FRAME, (bytes, offset) -> {
            final Full_frame full_frame = new Full_frame();
            final int load = full_frame.load(bytes, offset);
            return new Pair<>(full_frame, load);
        });
    }

    public static int create(FrameType frameType, byte[] bytes, final int startOffset, StackMapFrame[] arr, final int idx) {
        final BiFunction<byte[], Integer, Pair<StackMapFrame, Integer>> func = typeToFunc.get(frameType);
        if (func == null) {
            Log.error("此属性尚无法解析：" + frameType.name());
            System.exit(9);
        }
        final Pair<StackMapFrame, Integer> pair = func.apply(bytes, startOffset);
        arr[idx] = pair.getKey();
        return pair.getValue();
    }

}
