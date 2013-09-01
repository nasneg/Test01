/*
 * Copyright 2013 Masaru Hashizume<hashizume.masaru@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.test;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

/**
 *
 */
public class WsCancelParser {
    @SuppressWarnings("unused")
    private static final String TAG = "WsParser";
    private final WsCancelParser self = this;

    public <T extends AsyncTask<?, ?, ?>> int execute(T task) {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            // キャンセルされたら抜ける
            if (task.isCancelled()) {
                return 0;
            }

            SystemClock.sleep(100);
            count++;
            Log.d("hashizume", "count:" + count);
        }
        return count;
    }
}
