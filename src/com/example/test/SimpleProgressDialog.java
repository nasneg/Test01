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

import android.app.Dialog;
import android.content.Context;

/**
 *
 */
public class SimpleProgressDialog extends Dialog {
    @SuppressWarnings("unused")
    private static final String TAG = "SimpleDialog";
    private final SimpleProgressDialog self = this;

    /**
     * @param context
     */
    public SimpleProgressDialog(Context context) {
        super(context, R.style.Theme_SimpleProgressDialog);
        setContentView(R.layout.simple_progress_dilaog);
    }
}
