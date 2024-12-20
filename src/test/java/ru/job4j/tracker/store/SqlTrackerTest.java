package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void checkReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.replace(item.getId(), new Item("item1"))).isTrue();
    }

    @Test
    public void checkDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item2 = new Item("item2");
        tracker.add(item);
        tracker.add(item2);
        tracker.deleteAll();
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    public void checkFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> list = new ArrayList<>();
        Item itemOne = new Item("item");
        Item itemTwo = tracker.add(itemOne);
        list.add(itemTwo);
        assertThat(tracker.findByName(itemOne.getName())).isEqualTo(list);
    }

    @Test
    public void checkDeleteAndFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> list = new ArrayList<>();
        Item itemOne = new Item("item1");
        Item itemTwo = new Item("item2");
        Item itemThree = new Item("item3");
        Item testOne = tracker.add(itemOne);
        tracker.add(itemTwo);
        Item testThree = tracker.add(itemThree);
        list.add(testOne);
        list.add(testThree);
        tracker.delete(itemTwo.getId());
        System.out.println(tracker.findAll());
        assertThat(tracker.findAll()).isEqualTo(list);
    }
}
