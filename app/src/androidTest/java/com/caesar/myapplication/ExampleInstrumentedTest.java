package com.caesar.myapplication;

import android.app.Instrumentation;
import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private Instrumentation instrumentation;
    private UiDevice uiDevice;

    @Before
    public void init() {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        uiDevice = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void useAppContext() {
        try {
            goApp();
            while (true) {
                SystemClock.sleep(1000);
                uiDevice.click(500, 500);
                long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < 1000 * 40) {
                    uiDevice.drag(500, 1500, 500, 1480, 10);
                    SystemClock.sleep(1500);
                    uiDevice.drag(500, 1480, 500, 1500, 10);
                    SystemClock.sleep(1500);
                }
                uiDevice.pressBack();
                uiDevice.drag(500, 1500, 500, 1000, 10);
            }

            /*goApp();
            while (true)
            {
                SystemClock.sleep(1000);
                startDrag();
                uiDevice.drag(500, 1505, 500, 1000, 40);
                SystemClock.sleep(1000);
                newsDetail();
            }*/
            //uiDevice.findObject(By.text("趣头条")).click();
            /*uiDevice.findObject(By.res("com.yang.xxx")).click();
            uiDevice.findObject(By.text("hahah")).longClick();
            uiDevice.findObject(By.desc("加法")).click();
            uiDevice.findObject(By.res("faafaf").checkable(true)).click();
            uiDevice.findObject(By.res("faafaf").focused(true)).setText("adada");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 进入详情。
     */
    private void newsDetail() {
        uiDevice.click(500, 300);
    }

    /**
     * 开始在新闻详情页滑动，停留100秒。
     */
    private void startDrag() {

        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < 1000 * 40) {
            uiDevice.drag(500, 1500, 500, 1480, 10);
            SystemClock.sleep(1500);
            uiDevice.drag(500, 1480, 500, 1500, 10);
            SystemClock.sleep(1500);
        }
        uiDevice.pressBack();

    }

    private void goApp() {
        SystemClock.sleep(1000);
        try {
            uiDevice.pressRecentApps();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        SystemClock.sleep(1000);
        uiDevice.click(1000, 1500);
    }

}
