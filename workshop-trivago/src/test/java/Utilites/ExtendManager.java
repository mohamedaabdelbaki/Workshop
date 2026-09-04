package Utilites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/productReport.html");
            extent = new ExtentReports();
            extent.attachReporter(new ExtentObserver[]{spark});
        }

        return extent;
    }
}
