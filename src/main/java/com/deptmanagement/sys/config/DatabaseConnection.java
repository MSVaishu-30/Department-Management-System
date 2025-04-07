package com.deptmanagement.sys.config;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// * DatabaseConnection class provides a method to establish a connection
// * with the PostgreSQL database.
// */
//public class DatabaseConnection {
//    // Database URL - Ensure PostgreSQL is running and the database exists
//    private static final String URL = "jdbc:postgresql://localhost:5432/department_management"; // Update DB name
//    private static final String USER = "postgres"; // Database username
//    private static final String PASSWORD = "123456"; // Database password
//
//    /**
//     * Establishes and returns a connection to the PostgreSQL database.
//     * @return Connection object if successful.
//     * @throws RuntimeException if connection fails.
//     */
//    public static Connection getConnection() {
//        try {
//            return DriverManager.getConnection(URL, USER, PASSWORD); // Establish connection
//        } catch (SQLException e) {
//            e.printStackTrace(); // Print error details
//            throw new RuntimeException("Error connecting to PostgreSQL"); // Handle connection failure
//        }
//    }
//}




//package com.deptmanagement.sys.config;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DatabaseConnection {
//    private static final String URL = "jdbc:postgresql://localhost:5432/department_management";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "123456";
//
//    private static Connection connection = null;
//
//    // Private constructor to prevent instantiation
//    private DatabaseConnection() { }
//
//    public static Connection getConnection() {
//        try {
//            // If connection is null or closed, create a new one
//            if (connection == null || connection.isClosed()) {
//                connection = DriverManager.getConnection(URL, USER, PASSWORD);
//                System.out.println("Database connected successfully.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Error reconnecting to the database");
//        }
//        return connection;
//    }
//
//    public static void closeConnection() {
//        if (connection != null) {
//            try {
//                connection.close();
//                connection = null; // Reset connection for next use
//                System.out.println("Database connection closed.");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}


//multithreading with synchronized method
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class DatabaseConnection {
//    private static final String URL = "jdbc:postgresql://localhost:5432/Dept_management";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "123456";
//
//    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
//    private static Connection connection = null;
//
//    private DatabaseConnection() { }
//
//    public static synchronized Connection getConnection() {
//        try {
//            if (connection == null || connection.isClosed()) {
//                connection = DriverManager.getConnection(URL, USER, PASSWORD);
//                logger.info("Database connected successfully.");
//            }
//        } catch (SQLException e) {
//            logger.error("Error connecting to the database", e);
//            throw new RuntimeException("Error connecting to the database", e);
//        }
//        return connection;
//    }
//
//    public static synchronized void closeConnection() {
//        if (connection != null) {
//            try {
//                connection.close();
//                connection = null;
//                logger.info("Database connection closed.");
//            } catch (SQLException e) {
//                logger.error("Error closing the database connection", e);
//            }
//        }
//    }
//}




//multithreading with volatile keyword
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DatabaseConnection {
//    private static final String URL = "jdbc:postgresql://localhost:5432/department_management";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "123456";
//
//    private static volatile Connection connection = null;
//
//    private DatabaseConnection() { }
//
//    public static Connection getConnection() {
//        try {
//            // Ensure connection is valid before returning
//            if (connection == null || connection.isClosed()) {
//                synchronized (DatabaseConnection.class) {
//                    if (connection == null || connection.isClosed()) {
//                        connection = DriverManager.getConnection(URL, USER, PASSWORD);
//                        System.out.println("Database connected successfully.");
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Error connecting to the database", e);
//        }
//        return connection;
//    }
//
//    public static void closeConnection() {
//        if (connection != null) {
//            synchronized (DatabaseConnection.class) {
//                try {
//                    connection.close();
//                    connection = null;
//                    System.out.println("Database connection closed.");
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}

//multithreading with thread lock
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class DatabaseConnection {
//    private static final String URL = "jdbc:postgresql://localhost:5432/department_management";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "123456";
//
//    private static Connection connection = null;
//    private static final Lock lock = new ReentrantLock(); // Using Lock interface
//
//    private DatabaseConnection() { }
//
//    public static Connection getConnection() {
//        if (connection == null || isConnectionClosed()) {
//            lock.lock(); // Acquire the lock
//            try {
//                if (connection == null || isConnectionClosed()) { // Double-check
//                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
//                    System.out.println("Database connected successfully.");
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException("Error connecting to the database", e);
//            } finally {
//                lock.unlock(); // Always release the lock
//            }
//        }
//        return connection;
//    }
//
//    private static boolean isConnectionClosed() {
//        try {
//            return connection == null || connection.isClosed();
//        } catch (SQLException e) {
//            return true;
//        }
//    }
//
//    public static void closeConnection() {
//        lock.lock();
//        try {
//            if (connection != null) {
//                connection.close();
//                connection = null; // Reset connection for next use
//                System.out.println("Database connection closed.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock(); // Release the lock
//        }
//    }
//}






