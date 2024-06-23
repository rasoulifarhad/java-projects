package com.farhad.example.tic_tac_toe_v2.mongo;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class TicTacToeCollection {

    private MongoCollection mongoCollection;

    protected  MongoCollection getMongoCollection() {
        return mongoCollection;
    }

    public TicTacToeCollection() {
        MongoClient mongoClient = new MongoClient();
        DB db = mongoClient.getDB("tic-tac-toe");
        this.mongoCollection = new Jongo(db).getCollection("game");

    }

    public boolean saveMove(TicTacToeBean bean) {
        try {
            getMongoCollection().save(bean);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean drop() {
        getMongoCollection().drop();
        return true;
    }

}
