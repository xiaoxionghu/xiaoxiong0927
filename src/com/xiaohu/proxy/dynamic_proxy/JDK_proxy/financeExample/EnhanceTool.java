package com.xiaohu.proxy.dynamic_proxy.JDK_proxy.financeExample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/5
 * Time: 14:06
 * To change this template use File | Settings | File Templates.
 */
public class EnhanceTool implements InvocationHandler {
    private FinanceSystem financeSystem;
    private List<Function> functions;

    public EnhanceTool(FinanceSystem financeSystem, List list){
        super();
        this.financeSystem=financeSystem;
        this.functions=list;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Function function:functions){

            function.function();
        }
        method.invoke(financeSystem);

        return null;
    }
}
