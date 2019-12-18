package com.pandaq.printer.service;

import com.pandaq.spi.PrinterService;

import java.util.ServiceLoader;

/**
 * @author Luz.Ho211
 * @date 2019-12-18 11:25
 */
public class PrinterLauncher {

    public static void main(String[] args) {
        ServiceLoader<PrinterService> serviceLoader = ServiceLoader.load(PrinterService.class);
        serviceLoader.forEach(printer -> {
            printer.print("我要打印很多钱");
        });
    }

}
