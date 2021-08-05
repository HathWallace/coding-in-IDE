package UtilLib;

import leetcode.ListNode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OutputFactory {

    public String product(Object obj) {
        if (ListNode.class.equals(obj.getClass()))
            obj = getArrayFromList((ListNode) obj);

        if (obj.getClass().isArray() || obj instanceof List) {
            JSONArray jsonArray = JSONArray.fromObject(obj);
            return jsonArray.toString();
        }

        JSONObject jsonObject = JSONObject.fromObject(obj);
        return jsonObject.toString();
    }

    private Object getArrayFromList(ListNode head) {
        List<Integer> valList = new LinkedList<>();
        ListNode pt = head;
        while (pt != null) {
            valList.add(pt.val);
            pt = pt.next;
        }
        return valList;
    }
}