package com.epson.printer;

import com.pandaq.spi.PrinterServiceV2;

/**
 * @author Luz.Ho211
 * @date 2020-01-08 17:30
 */
public class EpsonV2Printer implements PrinterServiceV2 {

    @Override
    public String print(String text) {
        System.out.println("爱普生第二代打印机以「10倍」速度为您服务：" + text);
        return "爱普生第二代打印机以「10倍」速度为您服务：" + text;
    }

}