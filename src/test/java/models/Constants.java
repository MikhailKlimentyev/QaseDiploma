package models;

public final class Constants {

    public static final String START_PAGE = "StartPage";
    public static final String LOGIN_PAGE = "LoginPage";
    public static final String PROJECTS_PAGE = "ProjectsPage";
    public static final String CREATE_PROJECT_PAGE = "CreateProjectPage";
    public static final String REPOSITORY_PROJECT_PAGE = "RepositoryProjectPage";
    public static final String CREATE_SUITE_PAGE = "CreateSuitePage";
    public static final String CREATE_TEST_CASE_PAGE = "CreateTestCasePage";
    public static final String DELETE_PROJECT_PAGE = "DeleteProjectPage";
    public static final String UPLOAD_ATTACHMENT_MODAL = "UploadAttachmentModal";
    public static final String REPOSITORY_TEST_CASE_MODAL = "RepositoryTestCaseModal";

    public static final String LOGIN_BUTTON = "Login";
    public static final String EMAIL_INPUT = "EmailInput";
    public static final String PASSWORD_INPUT = "PasswordInput";
    public static final String CREATE_NEW_PROJECT_BUTTON = "CreateNewProject";
    public static final String CREATE_NEW_SUITE_BUTTON = "CreateNewSuite";
    public static final String CREATE_NEW_CASE_BUTTON = "CreateNewCase";
    public static final String CREATE_PROJECT_BUTTON = "CreateProject";
    public static final String CREATE_SUITE_BUTTON = "Create";
    public static final String PROJECT_NAME_INPUT_LABEL = "Project name";
    public static final String SUITE_NAME_INPUT_LABEL = "Suite name";
    public static final String SUITE_DESCRIPTION_INPUT_LABEL = "Description";
    public static final String SUITE_PRECONDITIONS_INPUT_LABEL = "Preconditions";
    public static final String DESCRIPTION_TEXT_AREA_LABEL = "Description";

    public static final String CASE_TITLE_INPUT_LABEL = "Title";
    public static final String CASE_DESCRIPTION_INPUT_LABEL = "Description";
    public static final String CASE_PRE_CONDITIONS_INPUT_LABEL = "Pre-conditions";
    public static final String CASE_POST_CONDITIONS_INPUT_LABEL = "Post-conditions";
    public static final String CASE_STATUS_COMBO_BOX_LABEL = "Status";
    public static final String CASE_SUITE_COMBO_BOX_LABEL = "Suite";
    public static final String CASE_SEVERITY_COMBO_BOX_LABEL = "Severity";
    public static final String CASE_PRIORITY_COMBO_BOX_LABEL = "Priority";
    public static final String CASE_TYPE_COMBO_BOX_LABEL = "Type";
    public static final String CASE_BEHAVIOR_COMBO_BOX_LABEL = "Behavior";
    public static final String CASE_AUTOMATION_STATUS_COMBO_BOX_LABEL = "Automation status";
    public static final String CASE_ADD_STEP_BUTTON = "Add step";
    public static final String CASE_ADD_ATTACHMENT_BUTTON = "Add attachment";
    public static final String CASE_ACTION_INPUT_LABEL = "Action";
    public static final String CASE_EXPECTED_RESULT_INPUT_LABEL = "Expected result";
    public static final String CASE_INPUT_DATA_INPUT_LABEL = "Input data";
    public static final String CASE_SAVE_BUTTON = "Save";

    public static final String DELETE_PROJECT_BUTTON = "Delete project";

    public static final String QASE_EMAIL_PROPERTY = "QaseEmail";
    public static final String QASE_PASSWORD_PROPERTY = "QasePassword";
    public static final String TOKEN_PROPERTY = "Token";

    public static final String PROJECT_NAME_PREFIX = "Q";

    public static final String HTTP_CONNECTION_MANAGER_TIMEOUT = "http.connection-manager.timeout";
    public static final String HTTP_CONNECTION_TIMEOUT = "http.connection.timeout";
    public static final String HTTP_SOCKET_TIMEOUT = "http.socket.timeout";

    public static final String INVALID_CREDENTIALS_ERROR_MESSAGE = "These credentials do not match our records.";
    public static final String EMAIL_DOT_PLACE_ERROR_MESSAGE = "'.' is used at a wrong position in '.com'.";
    public static final String EMAIL_NOT_CONTAINING_SYMBOL_ERROR_MESSAGE =
            "Please include an '@' in the email address. 'email' is missing an '@'.";
    public static final String REQUIRED_FIELD_IS_NOT_FILLED_ERROR_MESSAGE = "Please fill out this field.";

    public static final String URL_PATTERN = "%s/%s";

    public static final int IMPLICITLY_WAIT_TIME_OUT = 15000;
    public static final int EXPLICITLY_WAIT_TIME_OUT = 30000;

    private Constants() {
        //private ctor
    }
}
