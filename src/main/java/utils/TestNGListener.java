package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

    public class TestNGListener implements ITestListener {

        Logger logger = LoggerFactory.getLogger(utils.TestNGListener.class);

        @Override
        public void onTestStart(ITestResult result) {
            ITestListener.super.onTestStart(result);
            logger.info("start test -->" + result.getMethod());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            ITestListener.super.onTestSuccess(result);
            logger.info("success test -->" + result.getMethod());
        }

        @Override
        public void onTestFailure(ITestResult result) {
            ITestListener.super.onTestFailure(result);
            logger.info("failed test -->" + result.getMethod());
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            ITestListener.super.onTestSkipped(result);
            logger.info("skipped test -->" + result.getMethod());
        }

        @Override
        public void onStart(ITestContext context) {
            ITestListener.super.onStart(context);
            logger.info("start testing on date: " + context.getStartDate()+ "===============");
            // logger.info("start testing on host: " + context.getHost() + "===============");
        }

        @Override
        public void onFinish(ITestContext context) {
            ITestListener.super.onFinish(context);
            logger.info("stop testing on date: " + context.getStartDate()+ "===============");
        }
}
