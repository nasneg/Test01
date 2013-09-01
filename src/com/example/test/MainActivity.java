
package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.test.entity.Entity;
import com.example.test.entity.TestResult;

public class MainActivity extends Activity {

    private final MainActivity self = this;
    private WsCancelParserTask<WsCancelParser> mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.stop).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mTask.cancel(false);
                mTask = null;
            }
        });
        findViewById(R.id.run).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mTask = new WsCancelParserTask<WsCancelParser>();
                mTask.execute(new WsCancelParser());
            }
        });
        findViewById(R.id.dialog).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                SimpleProgressDialog dialog = new SimpleProgressDialog(self);
                dialog.show();
            }
        });
        findViewById(R.id.xml).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                new WsParserTask<WsDto, Entity<TestResult>>(
                        new WsParser<WsDto, Entity<TestResult>>()).execute(new WsDto());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
