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

import com.example.test.entity.Entity;

/**
 *
 */
public class WsParserTask<O extends WsDto, E extends Entity<?>> extends AsyncTask<O, Void, E> {
    @SuppressWarnings("unused")
    private static final String TAG = "WsParserTask";
    private final WsParserTask self = this;

    private WsParser<O, E> mParser;

    public <P extends WsParser<O, E>> WsParserTask(P parser) {
        mParser = parser;
    }

    @Override
    protected E doInBackground(O... params) {
        return mParser.execute(this, params[0]);
    }
}
