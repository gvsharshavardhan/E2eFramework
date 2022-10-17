package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ReportManager {

   private static ExtentReports extentReports;
   private static ExtentTest extentTest;

    public static void initReport(){
        extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/bank.html");
        extentSparkReporter.config().setDocumentTitle("XYZ Bank Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(extentSparkReporter);
    }

    public static void createTest(String testName){
        extentTest = extentReports.createTest(testName);
    }

    public static ExtentTest getExtentTest(){
        return extentTest;
    }

    public static void flushReport(){
     extentReports.flush();
    }

}