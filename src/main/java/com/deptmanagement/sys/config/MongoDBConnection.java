//package com.deptmanagement.sys.config;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * Provides a singleton connection to the MongoDB database.
// */
//public class MongoDBConnection {
//    private static final String URI = "mongodb://localhost:27017";
//    private static final String DATABASE_NAME = "Dept_management";
//    private static volatile MongoDatabase database;
//    private static final Logger logger = LoggerFactory.getLogger(MongoDBConnection.class);
//
//    /**
//     * Private constructor to prevent instantiation.
//     */
//    private MongoDBConnection() {}
//
//    /**
//     * Gets the MongoDB database instance.
//     * Ensures that only one connection is created (singleton pattern).
//     *
//     * @return the MongoDatabase instance.
//     */
//    public static MongoDatabase getDatabase() {
//        if (database == null) { // First check (without lock)
//            synchronized (MongoDBConnection.class) {
//                if (database == null) {
//                    try {
//                        MongoClient client = MongoClients.create(URI);
//                        database = client.getDatabase(DATABASE_NAME);
//                        logger.info("Connected to MongoDB successfully.");
//                    } catch (Exception e) {
//                        logger.error("Failed to connect to MongoDB", e);
//                        throw new RuntimeException("Error connecting to MongoDB", e);
//                    }
//                }
//            }
//        }
//        return database;
//    }
//}
