/*
 * Copyright (C) 2010-2011 Naranjo Manuel Francisco <manuel@aircable.net>
 * Copyright (C) 2010-2011 Robbie Matthews <rjmatthews62@gmail.com>
 * Copyright (C) 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.googlecode.python3forandroid;

import android.content.Context;

import com.googlecode.android_scripting.AsyncTaskListener;
import com.googlecode.android_scripting.InterpreterInstaller;
import com.googlecode.android_scripting.Log;
import com.googlecode.android_scripting.exception.Sl4aException;
import com.googlecode.android_scripting.interpreter.InterpreterConstants;
import com.googlecode.android_scripting.interpreter.InterpreterDescriptor;

import java.io.File;

public class Python3Installer extends InterpreterInstaller {
  public Python3Installer(InterpreterDescriptor descriptor, Context context,
      AsyncTaskListener<Boolean> listener) throws Sl4aException {
    super(descriptor, context, listener);
  }

  @Override
  protected boolean isInstalled() {
    return false;
  }

  @Override
  protected boolean setup() {
    File tmp =
        new File(InterpreterConstants.SDCARD_ROOT + getClass().getPackage().getName()
            + InterpreterConstants.INTERPRETER_EXTRAS_ROOT, mDescriptor.getName() + "/tmp");
    if (!tmp.isDirectory()) {
      try {
        tmp.mkdir();
      } catch (SecurityException e) {
        Log.e(mContext, "Setup failed.", e);
        return false;
      }
    }
    return true;
  }
}