package com.sl.pay.lock;

public interface ILock {

    /**
     * 尝试获取锁
     *
     * @param name       锁的名称
     * @param timeoutSec 锁持有的超时时间，过期后自动释放
     * @return true表示获取锁成功，false表示获取锁失败
     */
    boolean tryLock(String name, Long timeoutSec);

    /**
     * 释放锁
     */
    void unlock(String name);
}