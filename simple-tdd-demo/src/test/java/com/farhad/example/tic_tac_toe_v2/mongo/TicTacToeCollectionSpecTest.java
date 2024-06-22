package com.farhad.example.tic_tac_toe_v2.mongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.jongo.MongoCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TicTacToeCollectionSpecTest {

    private TicTacToeCollection collection;

    @BeforeEach
    public void setup() {
        collection = spy(new TicTacToeCollection());
    }

    @Test
    public void whenInstantiatedThenMongoHasDbNameTicTacToe() {
        assertEquals("tic-tac-toe", 
                        collection
                            .getMongoCollection()
                                .getDBCollection()
                                    .getDB()
                                        .getName());
    }

    @Test
    public void whenInstantiatedThenMongoCollectionHasNameGame() {
        assertEquals("game", 
                        collection
                            .getMongoCollection()
                                .getName());
    }

    @Test
    public void whenSaveMoveThenInvokeMongoCollectionSave() {
        TicTacToeBean bean = new TicTacToeBean(3, 2, 1, 'Y');
        MongoCollection mongoCollection = mock(MongoCollection.class);
        Mockito.doReturn(mongoCollection).when(collection).getMongoCollection();
        collection.saveMove(bean);
        verify(mongoCollection, times(1)).save(bean);
    }

    @Test
    public void whenSaveMoveThenReturnTrue() {
        TicTacToeBean bean = new TicTacToeBean(3, 2, 1, 'Y');
        MongoCollection mongoCollection = mock(MongoCollection.class);
        Mockito.doReturn(mongoCollection).when(collection).getMongoCollection();
        assertTrue(collection.saveMove(bean));
    }
}
