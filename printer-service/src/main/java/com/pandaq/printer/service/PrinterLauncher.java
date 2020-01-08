package com.pandaq.printer.service;

import com.pandaq.spi.PrinterService;
import com.pandaq.spi.PrinterServiceV2;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.ServiceLoader;

/**
 * 启动类
 * @author Luz.Ho211
 * @date 2019-12-18 11:25
 */
public class PrinterLauncher {

    public static void main(String[] args) {
        // Java SPI机制使用
        ServiceLoader<PrinterService> serviceLoader = ServiceLoader.load(PrinterService.class);
        serviceLoader.forEach(printer -> {
            printer.print("我要打印很多钱");
        });

        // Dubbo SPI机制使用
        ExtensionLoader<PrinterServiceV2> extensionLoader = ExtensionLoader.getExtensionLoader(PrinterServiceV2.class);
        extensionLoader.getExtension("epson-v1").print("我要打印很多钱");
        extensionLoader.getExtension("epson-v2").print("我要打印很多钱");
    }

}
