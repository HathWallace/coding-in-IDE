package leetcode;

import Debug.CoreCodeDebug;

import java.lang.reflect.Method;

class SolutionTest {

    public static void main(String[] args) throws Exception {
        CoreCodeDebug codeDebug = new CoreCodeDebug();
        Method solutionMethod = codeDebug
                .getSolutionMethod(Solution.class);
        System.out.println(solutionMethod.getName());

        Solution solution = new Solution();
        while (true) {
            try {
                Object[] inputParameters = codeDebug
                        .getInputParameter(solutionMethod);
                Object result = solutionMethod
                        .invoke(solution, inputParameters);
                codeDebug.outputResult(result);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}