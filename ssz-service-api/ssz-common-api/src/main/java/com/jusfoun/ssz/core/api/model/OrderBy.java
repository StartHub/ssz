package com.jusfoun.ssz.core.api.model;

import com.jusfoun.ssz.core.utils.StrUtil;

import java.io.Serializable;


/**
 * 排序
 *
 * @author jsshao1986@126.com
 * @version 3.0
 */
public class OrderBy implements Serializable {

    private static final long serialVersionUID = -3078342809727773232L;

    /**
     * 方向
     */
    public enum Direction {

        /**
         * 递增
         */
        asc,

        /**
         * 递减
         */
        desc;

        /**
         * 从String中获取Direction
         *
         * @param value 值
         * @return String对应的Direction
         */
        public static Direction fromString(String value) {
            return Direction.valueOf(value.toLowerCase());
        }
    }

    /**
     * 默认方向
     */
    private static final Direction DEFAULT_DIRECTION = Direction.desc;

    /**
     * 属性
     */
    private String property;

    /**
     * 方向
     */
    private Direction direction = DEFAULT_DIRECTION;

    /**
     * 初始化一个新创建的OrderBy对象
     */
    public OrderBy() {
    }

    /**
     * @param property  属性
     * @param direction 方向
     */
    public OrderBy(String property, Direction direction) {
        this.property = property;
        this.direction = direction;
    }

    /**
     * 返回递增排序
     *
     * @param property 属性
     * @return 递增排序
     */
    public static OrderBy asc(String property) {
        return new OrderBy(property, Direction.asc);
    }

    /**
     * 返回递减排序
     *
     * @param property 属性
     * @return 递减排序
     */
    public static OrderBy desc(String property) {
        return new OrderBy(property, Direction.desc);
    }

    /**
     * 获取属性
     *
     * @return 属性
     */
    public String getProperty() {
        return property;
    }

    /**
     * 设置属性
     *
     * @param property 属性
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * 获取方向
     *
     * @return 方向
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * 设置方向
     *
     * @param direction 方向
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return StrUtil.humpToLine(property) + " " + this.direction;
    }

}