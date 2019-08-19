package com.lhy.fool.task.builder;

import java.io.Serializable;

/**
 * @name: Builder
 * @author： LHY
 * @classPath: com.lhy.fool.task.builder.Builder
 * @date: 2019-08-19 08:56
 * @Version: 1.0
 */
public interface Builder<T> extends Serializable {

    /**
     * build
     * @return T
     */
    T build();
}
