package com.pandaq.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * SPI接口：对外发布 <br />
 * 采用Dubbo SPI必须在SPI接口上使用 {@link org.apache.dubbo.common.extension.SPI} 注解
 * @author Luz.Ho211
 * @date 2020-01-08 17:47
 */
@SPI
public interface PrinterServiceV2 {

    String print(String text);

}