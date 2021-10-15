package com.wt.listener;

/**
 * @author wtt
 * @version 1.0
 * @description 事件对象
 * @date 2021/7/22 14:42
 */
public class Even {

    private Robot robot;

    public Even() {
        super();
    }

    public Even(Robot robot) {
        super();
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}
