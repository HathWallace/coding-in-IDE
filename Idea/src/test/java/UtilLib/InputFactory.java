package UtilLib;

import leetcode.ListNode;
import net.sf.json.JSONArray;

import java.util.Collection;

public class InputFactory {

    public Object product(Class<?> parameterType, String line) {
        if (int.class.equals(parameterType) || Integer.class.equals(parameterType)) {
            return Integer.parseInt(line);
        }
        if (int[].class.equals(parameterType)) {
            Collection<?> valCollection = getJsonCollection(line);
            int[] nums = new int[valCollection.size()];
            int index = 0;
            for (Object val : valCollection) {
                nums[index++] = (int) val;
            }
            return nums;
        }
        if (ListNode.class.equals(parameterType)) {
            Collection<?> valCollection = getJsonCollection(line);
            ListNode head = new ListNode(), pt = head;
            for (Object val : valCollection) {
                pt.next = new ListNode((int) val);
                pt = pt.next;
            }
            return head.next;
        }
        return null;
    }

    public Collection<?> getJsonCollection(String line) {
        JSONArray jsonArray = JSONArray.fromObject(line);
        return JSONArray.toCollection(jsonArray);
    }
}