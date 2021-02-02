package com.wyq.common.servlet;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 通用serviceImpl
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements BaseService<T> {
}
