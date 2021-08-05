package leetcode;

import UtilLib.LeetCodeIO;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SolutionTest {

    public static void main(String[] args) {
        Method solutionMethod = getSolutionMethod();
        System.out.println(solutionMethod.getName());

        Class<?>[] parameterTypes = solutionMethod.getParameterTypes();
        int paramCount = parameterTypes.length;
        Solution solution = new Solution();
        LeetCodeIO io = new LeetCodeIO();

        while (true) {
            Object[] params = new Object[paramCount];
            for (int i = 0; i < paramCount; i++) {
                params[i] = io.input(parameterTypes[i]);
            }
            try {
                Object res = solutionMethod.invoke(solution, params);
                io.output(res);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

        }
    }

    private static Method getSolutionMethod() {
        try {
            Class<?> aClass = Class.forName("leetcode.Solution");
            Method[] methods = aClass.getDeclaredMethods();
            if (methods.length != 1)
                throw new Exception("必须有且仅有一个公共方法！");
            return methods[0];
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }
}