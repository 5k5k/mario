// ITalkAidlInterface.aidl
package com.morladim.mario.sample.ipc;

import com.morladim.mario.sample.ipc.ITalkCallbackAidlInterface;

// Declare any non-default types here with import statements

interface ITalkAidlInterface {

    void tellServer(String s);

    String getMessage();

    void registerCallback(ITalkCallbackAidlInterface callback);

    void unRegisterCallback(ITalkCallbackAidlInterface callback);
}