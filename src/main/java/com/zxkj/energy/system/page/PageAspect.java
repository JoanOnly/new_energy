package com.zxkj.energy.system.page;

import com.github.pagehelper.PageHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 刘万琼
 * <p>
 * 分页的切面
 */
@Aspect
@Component
public class PageAspect {

    /**
     * 方法描述：定义切点 以及其范围是注解，注解的接口是Paging
     * 创建时间：2019-06-20 18:33:20
     * 创建作者：刘万琼
     */
    @Pointcut("@annotation(com.zxkj.energy.system.page.Paging)")
    public void pagingPointcut() {
    }

    /**
     * 方法描述：进入切点之前执行的方法
     * 创建时间：2019-06-20 18:35:48
     * 创建作者：刘万琼
     * 要在进入切点之前执行分页PageHelper，
     * 因为mybatis的分页规定要先执行startPage然后再执行list数据才可以完成分页
     * 列如：PageHelper.startPage(PageContext.getPageNum(),PageContext.getPageSize());
     *      List<User> list = userMapper.list(user);
     * 如果放在@After执行，顺序就变成了以下先执行list，再startPage执行分页信息
     *      List<User> list = userMapper.list(user);
     *      PageHelper.startPage(PageContext.getPageNum(),PageContext.getPageSize());
     */
    @Before("pagingPointcut()")
    public void before() {
        PageHelper.startPage(PageContext.getPageNum(), PageContext.getPageSize());
    }

    /**
     * 方法描述：环绕方法，切点执行的方法
     * 创建时间：2019-06-20 18:50:16
     * 创建作者：刘万琼
     *
     * @param pjp the pjp
     * @return the object
     * @throws Throwable the throwable
     */
    @Around(value = "pagingPointcut()", argNames = "pjp")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }

}
