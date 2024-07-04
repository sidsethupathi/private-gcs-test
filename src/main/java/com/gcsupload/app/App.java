package com.gcsupload.app;

import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class App {
    public static void main(String[] args) {

        HeaderProvider headerProvider = FixedHeaderProvider.create("Host", "storage.googleapis.com");

        Storage storage = StorageOptions.getDefaultInstance()
                .toBuilder()
                .setHost("https://private.googleapis.com")
                .setHeaderProvider(headerProvider)
                .build()
                .getService();


        storage.list("foo");
    }
}
