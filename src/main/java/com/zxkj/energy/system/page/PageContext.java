package com.zxkj.energy.system.page;

/**
 * @author 刘万琼
 *
 * ThreadLocal 本地线程 存储分页信息
 * 主要包含 get() set() remove() 核心方法
 */
public class PageContext {

    private static ThreadLocal<Integer> pageNum = new ThreadLocal<>();
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<>();

    public static int getPageNum() {
        Integer page = pageNum.get();
        if (page == null) {
            return 1;
        }
        return page;
    }

    public static void setPageNum(Integer page) {
        pageNum.set(page);
    }

    public static void removePageNum() {
        pageNum.remove();
    }

    public static int getPageSize() {
        Integer size = pageSize.get();
        if (size == null) {
            return 15;
        }
        return size;
    }

    public static void setPageSize(Integer page) {
        pageSize.set(page);
    }

    public static void removePageSize() {
        pageSize.remove();
    }


}
