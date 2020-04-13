package au.company.product.admin.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AdminLambda implements RequestHandler {




    @Override
    public String handleRequest(Object o, Context context) {
        return "Test Spring lambda ";
    }
}
