package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.connectClasses.ConnectionPool;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ConnectionPoolTest {

    @Test
    public void sameConnection() {
        int mainThread = ConnectionPool.POOL.getConnection().hashCode();
        RunnableFuture future = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return (ConnectionPool.POOL.getConnection().hashCode());
            }
        });
        new Thread(future).start();
        int fromAnotherThread = 0;
        try {
            fromAnotherThread = (int) future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        int mainThread2 = ConnectionPool.POOL.getConnection().hashCode();
        assertEquals(mainThread, mainThread2);
        assertNotEquals(fromAnotherThread, mainThread);
    }

    @Test
    public void waitConnection() {
        for (int i = 0; i < 15; i++) {
            RunnableFuture future = new FutureTask(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    ConnectionPool.POOL.getConnection();
                    for (int i = 0; i < 15; i++) {
                        System.out.println("Thread" + i + " " + ConnectionPool.POOL.getConnection().hashCode());
                        Thread.sleep(10);
                    }
                    ConnectionPool.POOL.release();
                    return (ConnectionPool.POOL.getConnection().hashCode());
                }
            });
            new Thread(future).start();

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
