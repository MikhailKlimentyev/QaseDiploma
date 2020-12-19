package models;

public final class Constants {

    public static final String START_PAGE = "StartPage";
    public static final String LOGIN_PAGE = "LoginPage";
    public static final String PROJECTS_PAGE = "ProjectsPage";
    public static final String CREATE_PROJECT_PAGE = "CreateProjectPage";
    public static final String PROJECT_PAGE = "ProjectPage";
    public static final String CREATE_SUITE_PAGE = "CreateSuitePage";

    public static final String LOGIN_BUTTON = "Login";
    public static final String EMAIL_INPUT = "EmailInput";
    public static final String PASSWORD_INPUT = "PasswordInput";
    public static final String CREATE_NEW_PROJECT_BUTTON = "CreateNewProject";
    public static final String CREATE_NEW_SUITE_BUTTON = "CreateNewSuite";
    public static final String CREATE_PROJECT_BUTTON = "CreateProject";
    public static final String CREATE_SUITE_BUTTON = "CreateSuite";
    public static final String PROJECT_NAME_INPUT_LABEL = "Project name";
    public static final String SUITE_NAME_INPUT_LABEL = "Suite name";
    public static final String SUITE_DESCRIPTION_TEXT_AREA_LABEL = "Suite description";
    public static final String SUITE_PRECONDITIONS_TEXT_AREA_LABEL = "Suite preconditions";
    public static final String DESCRIPTION_TEXT_AREA_LABEL = "Description";

    public static final String QASE_EMAIL_PROPERTY = "QaseEmail";
    public static final String QASE_PASSWORD_PROPERTY = "QasePassword";
    public static final String TOKEN_PROPERTY = "Token";

    public static final String HTTP_CONNECTION_MANAGER_TIMEOUT = "http.connection-manager.timeout";
    public static final String HTTP_CONNECTION_TIMEOUT = "http.connection.timeout";
    public static final String HTTP_SOCKET_TIMEOUT = "http.socket.timeout";

    public static final String INVALID_CREDENTIALS_ERROR_MESSAGE = "These credentials do not match our records.";

    public static final String URL_PATTERN = "%s/%s";

    public static final int IMPLICITLY_WAIT_TIME_OUT = 15000;
    public static final int EXPLICITLY_TIME_OUT = 30000;

    private Constants() {
        //private ctor
    }
}
