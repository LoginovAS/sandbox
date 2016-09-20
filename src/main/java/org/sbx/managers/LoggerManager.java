package org.sbx.managers;

/**
 * Created by aloginov on 20.09.16.
 */
public class LoggerManager {

    public static final String STARTING_MESSAGE = "Application has been successfully started";

    public static final String FINISHING_MESSAGE = "Application has finished work";

    public static final String FILE_OPENED = "File {} has been opened in {} mode.";

    public static final String FILE_CREATED = "File {} has been created.";

    public static final String CANNOT_OPEN_FILE = "File {} cannot be opened in {} mode.";

    public static final String CANNOT_CREATE_FILE = "File {} cannot be created.";

    public static final String FILE_EXISTS = "File {} exists.";

    public static final String FILE_NOT_EXISTS = "File {} doesn't exist. {}";

    public static final String WILL_CREATE_FILE = "File will be created";

    public static final String FLAG_VALUE = "Flag '{}' set as {}";

    public static final String LIST_LOADED = "List has been loaded from file.";

    public static final String LIST_NOT_LOADED = "List has not been loaded";

    public static final String LIST_WROTE = "List has been wrote to file";

    public static final String LIST_INSERTED = "List has been inserted to the {}.";

    public static final String PROPERTIES_LOADED = "Properties successfully loaded from {} configuration file";

    public static final String PROPERTIES_NOT_LOADED = "Cannot load property file {}.";

    public static final String SCENARIO = "Scenario #{} {}";

    public static final String INSERT_TIME_BY_ELEMENT = "Insert time by element for {}: {} ns.";

    public static final String INSERT_TIME_ADDALL = "Insert time using addAll() method for {}: {} ns.";

    public static final String INSERT_TIME_TO_END = "Insert time for the end for {}: {} ns.";

    public static final String TOTAL_CHARS = "Total numbers of chars for {}: {} ";

    public static final String GET_RESULT_TIME = "Result got for {} ns";
}
