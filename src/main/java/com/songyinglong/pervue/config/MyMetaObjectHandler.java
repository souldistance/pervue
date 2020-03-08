package com.songyinglong.pervue.config;

//需要将自定义填充控制器注册为组件

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义填充控制器
 * 在开发规范中 gmtCreate gmtModified两个字段通常是必要的 所以可以使用自动填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);


    /**
     * insert操作时要填充的字段
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ...");
        // 看实体类中是否有这个属性，有的话就执行。没有就不执行
        boolean hasSetter = metaObject.hasSetter("gmtCreate");
        if (hasSetter) {
            this.strictInsertFill(metaObject, "gmtCreate", LocalDateTime.class, LocalDateTime.now());
        }
        //根据属性名字设置要填充的值
        /*this.setFieldValByName("created", new Date(), metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);*/
    }

    /**
     * update操作时要填充的字段
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ...");
        // 如果预先自己设置了值，则设置不使用MP的自动填充
        Object val = getFieldValByName("gmtModified", metaObject);
        if (val == null) {
            this.strictUpdateFill(metaObject, "gmtModified", LocalDateTime.class, LocalDateTime.now());
        }
        //this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
