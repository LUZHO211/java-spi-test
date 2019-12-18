package com.hp.printer;

import com.pandaq.spi.PrinterService;

/**
 * @author Luz.Ho211
 * @date 2019-12-05 18:14
 */
public class HpPrinter implements PrinterService {

    @Override
    public String print(String text) {
        System.out.println("惠普打印机为您服务：" + text);
        return "惠普打印机为您服务：" + text;
    }

}
