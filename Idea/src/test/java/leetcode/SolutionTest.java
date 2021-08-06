package leetcode;

import UtilLib.LeetCodeIO;

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
            try {
                Object[] params = new Object[paramCount];
                for (int i = 0; i < paramCount; i++) {
                    params[i] = io.input(parameterTypes[i]);
                }
                Object res = solutionMethod.invoke(solution, params);
                io.output(res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Method getSolutionMethod() {
        try {
            Class<?> aClass = Class.forName("leetcode.Solution");
            Method[] methods = aClass.getDeclaredMethods();
            Method solutionMethod = null;
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) == 1) {
                    if (solutionMethod != null)
                        throw new Exception("必须有且仅有一个公共方法！");
                    solutionMethod = method;
                }
            }
            return solutionMethod;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }
}