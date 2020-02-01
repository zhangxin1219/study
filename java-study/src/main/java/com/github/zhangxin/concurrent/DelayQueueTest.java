package com.github.zhangxin.concurrent;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/23 20:08
 * @Description:
 */
public class DelayQueueTest {
    public static class DelayedElement implements Delayed {
        private final long delayTime;
        private final long expires;
        private String taskName;

        public DelayedElement(long delayTime, String taskName) {
            this.delayTime = delayTime;
            this.taskName = taskName;
            expires = System.currentTimeMillis() + delayTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expires - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS) > 0)
                return 1;
            else
                return -1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("DelayedElement ").append(delayTime).append(",expires ").append(expires).append(" " + taskName);
            return sb.toString();
        }

    }

    public static void main(String[] args) {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            DelayedElement temp = new DelayedElement(random.nextInt(500), "task" + i);
            delayQueue.offer(temp);
        }
        DelayedElement delayedElement = null;
        try {
            for (; ; ) {
                while ((delayedElement = delayQueue.take()) != null)
                    System.out.println(delayedElement.toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
