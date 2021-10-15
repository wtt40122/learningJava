package com.wt.listener;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/7/22 14:46
 */
public class TestListener {

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.registerListener(new MyRobotListener());
        robot.working();
        robot.dancing();
    }
}
