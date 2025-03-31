package com.nixonex.ecommerce_automation.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;  // LogStatus import

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    // Initialize ExtentReports with a dynamic path
    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports(System.getProperty("user.dir") + "/reports/extent_report.html", true);
        }
        return extent;
    }
    
    // Start a new test
    public static void startTest(String testName) {
        test.set(extent.startTest(testName));
    }
    
    // End the current test
    public static void endTest() {
        extent.endTest(test.get());
    }
    
    // Log test results with different log status
    public static void logTestResult(String message, LogStatus status) {
        test.get().log(status, message);
    }
    
    // Generate the report after all tests are completed
    public static void generateReport() {
        extent.flush();
    }
    
    // Close the report and release resources
    public static void closeReport() {
        if (extent != null) {
            extent.close();
        }
    }
}
