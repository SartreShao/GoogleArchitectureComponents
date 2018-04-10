package com.tipchou.googlearchitecturecomponents.backend;

import com.avos.avoscloud.AVException;

import java.util.List;

/**
 * Created by 邵励治 on 2018/4/10.
 * Perfect Code
 */
public interface Callback<T> {
    public void response(List<T> list, AVException e);
}
