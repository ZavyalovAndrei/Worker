package com.zavyalov;

public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;
    private int tasksQuantity = 100;
    private int errorTaskNumber = 33;

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);

    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String errorMessage);
    }

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 1; i <= tasksQuantity; i++) {
            if (i != errorTaskNumber) {
                callback.onDone("Task " + i + " is done");
            } else {
                errorCallback.onError("ERROR! Task " + i + " is`t done");
            }
        }
    }
}
