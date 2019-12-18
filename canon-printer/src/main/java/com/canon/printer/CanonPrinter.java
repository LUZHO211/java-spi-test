package com.canon.printer;

import com.pandaq.spi.PrinterService;

/**
 * @author Luz.Ho211
 * @date 2019-12-05 18:07
 */
public class CanonPrinter implements PrinterService {

    @Override
    public String print(String text) {
        System.out.println("佳能打印机为您服务：" + text);
        return "佳能打印机为您服务：" + text;
    }

}
