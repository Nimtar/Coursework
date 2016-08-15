package ru.vsu.amm.chartamliturum.serverside.reportgenerator;

import net.sf.jasperreports.engine.*;

import java.util.Map;

public class ReportGenerator {
    public byte[] generateReport (Object necessaryData) {
        String sourceFileName = "C://tools/jasperreports-5.0.1/test"
            + "/jasper_report_template.jrxml";

        byte[] generatedFile = null;
        try {
            // Jasper-файл должен быть скомпилирован один раз
            // (пока не потребуется изменить шаблон).
            // Значит, нужно jasperFileName брать как-то иначе.
            String jasperFileName =
                JasperCompileManager.compileReportToFile(sourceFileName);

            JasperPrint jasperPrint =
                JasperFillManager.fillReport(jasperFileName,
                    getParams(necessaryData), getDataSource(necessaryData));
            generatedFile = JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            e.printStackTrace();
        }

        return generatedFile;
    }

    /* TODO: 15.08.2016 мапа параметров и DataSource временные.
     * Нужны будут хранящие пришедшие от клиента данные.
     */
    private Map<String, Object> getParams (Object necessaryData) {
        return null;
    }

    private JRDataSource getDataSource (Object necessaryData) {
        return new JREmptyDataSource();
    }
}
