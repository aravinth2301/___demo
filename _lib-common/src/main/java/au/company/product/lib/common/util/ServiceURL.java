package au.company.product.lib.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import au.company.product.lib.common.domain.admin.Function;

public class ServiceURL {
	private ServiceURL() {
	}

    public static final String ROLE_ADD = "/role";
    public static final String ROLE_FETCH_BY_NAME = "/role/{name}";
    public static final String FUNCTION_FETCH = "/functions";

    public static final String USER_ADD = "/user";
    public static final String USER_FETCH = "/users";
    public static final String USER_FETCH_BY_NAME = "/user/{name}";
    public static final String USER_FETCH_BY_ID = "/user-by-id/{userId}";

    public static final String SCHEDULER = "/scheduler";
    public static final String SCHEDULER_DELETE = "/{jobId}";
    public static final String SCHEDULER_TRIGGER = "/{jobId}";
    public static final String SCHEDULER_LIST = "/list";

    public static final String CHANGE_PSW = "/change-password";






    private static List<Function> functions = new ArrayList<>();

    private static List<Function> activatedFunctions = new ArrayList<>();

    static {
        Field[] fields = ServiceURL.class.getDeclaredFields();
        for (int i = 0; i < fields.length ; i++) {
            Field field = fields[i];
            if("java.lang.String".equals(field.getGenericType().getTypeName()))
                functions.add(new Function(field.getName()));
        }
    }

    static {
        Field[] fields = ServiceURL.class.getDeclaredFields();
        for (int i = 0; i < fields.length ; i++) {
            Field field = fields[i];
            activatedFunctions.add(new Function(field.getName(),true));
        }
    }


    public static List<Function> getActivatedFunctions() {
        return activatedFunctions;
    }

    public static List<Function> getFunctions() {
        return functions;
    }
}
