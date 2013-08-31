
package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    private final MainActivity self = this;
    private WsParserTask<WsParser> mTask;

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
                mTask = new WsParserTask<WsParser>();
                mTask.execute(new WsParser());
            }
        });
        findViewById(R.id.dialog).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                SimpleProgressDialog dialog = new SimpleProgressDialog(self);
                dialog.show();
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
