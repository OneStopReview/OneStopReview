/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.internal;

/**
 * @deprecated Please use {@link com.parse.twitter.AsyncCallback} instead.
 */
@Deprecated
public interface AsyncCallback extends com.parse.twitter.AsyncCallback {
  void onSuccess(Object result);

  void onCancel();

  void onFailure(Throwable error);
}
