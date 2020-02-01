package com.github.zhangxin.concurrent;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/23 17:12
 * @Description:
 */
public class PriorityBlockingQueueTest {
    public static class Task implements Comparable<Task> {
        private int priority = 0;
        private String taskName;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }


        @Override
        public int compareTo(Task o) {
            if (this.priority >= o.priority)
                return 1;
            else
                return -1;
        }

        public void doSomething() {
            System.out.println(this.taskName + ": " + priority);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            task.setPriority(random.nextInt(10));
            task.setTaskName("task" + i);
            queue.put(task);
        }
        while (!queue.isEmpty()) {
            Task task = queue.take();
            task.doSomething();
        }
    }
}
