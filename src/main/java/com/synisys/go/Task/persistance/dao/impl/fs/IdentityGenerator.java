package com.synisys.go.Task.persistance.dao.impl.fs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by meruzhan.gasparyan on 10/12/2016.
 */
public class IdentityGenerator {

    private AtomicInteger identity;

    private final String tableName;

    public IdentityGenerator(String tableName) {
        this.tableName = tableName;
        init(tableName);
    }

    private void init(String tableName) {
        identity = getLastIdentityId(tableName);
    }


    private AtomicInteger getLastIdentityId(String tableName) {
        JSONObject db = readDb();
        JSONArray table = db.getJSONArray(tableName);
        int index;
        if (table.length() > 0) {
            index = table.getJSONObject(table.length() - 1).getInt("id") + 1;
        } else {
            index = 1;
        }
        return new AtomicInteger(index);
    }

    public Integer getAndIncrement() {
        return identity.getAndIncrement();
    }

    private JSONObject readDb() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\db.json"))) {
            return new JSONObject((reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
