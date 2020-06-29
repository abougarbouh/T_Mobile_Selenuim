package testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListerner implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TestCases Failed and details are "+result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TestCases Skipped and details are "+result.getName());

    }

    @Override
    public void onStart(ITestContext result) {

            System.out.println("TestCases Started and details are "+result.getName());

    }
    @Override
    public void onTestSuccess(ITestResult result) {

           System.out.println("TestCases Success and details are "+result.getName());
    }
}
