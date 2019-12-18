package com.canon.printer;

import com.pandaq.spi.PrinterService;

/**
 * @author Luz.Ho211
 * @date 2019-12-18 11:31
 */
public class V8Printer implements PrinterService {

    @Override
    public String print(String text) {
        System.out.println("佳能第八代打印机为您服务：" + text);
        return "佳能第八代打印机为您服务：：" + text;
    }

}
