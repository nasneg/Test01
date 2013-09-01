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

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.os.AsyncTask;
import android.util.Log;

import com.example.test.entity.Entity;

/**
 *
 */
public class WsParser<O extends WsDto, E extends Entity<?>> {
    @SuppressWarnings("unused")
    private static final String TAG = "WsParser";
    private final WsParser self = this;

    private AsyncTask<?, ?, ?> mTask;

    public E parse(O dto) {
        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
        String url = "http://tyo.to/wp-content/themes/tyo.to/test.xml";
        try {
            ResponseEntity<BookXml> responseEntity = template.exchange(url, HttpMethod.GET, null,
                    BookXml.class);
            BookXml res = responseEntity.getBody();
            Log.d("hashizume", res.toString());
        } catch (Exception e) {
            Log.d("hashizume", e.toString());
            return null;
        }
        return null;
    }

    public E execute(AsyncTask<?, ?, ?> task, O dto) {
        mTask = task;
        return parse(dto);
    }
}
