package com.kinto.springee.aop.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@InterceptorYolKesici
public class interceptorYolKesiciAsilsiz {

    @AroundInvoke public Object loglama(InvocationContext context){

        System.out.println("İlk Hali. " + context.getMethod().getName());

        boolean isLogin=false;//yol kesici
        Object isContinue = null;//kesilmezse devam edeceğim

        if(isLogin){
            System.out.println("önce giriş yap");
            return null;
        }
        else {
            try {
                isContinue = context.proceed();
                System.out.println(" sonraki " + isContinue);
            }catch (Exception e){
                e.printStackTrace();
            }
            return isContinue;

        }
    }

}


