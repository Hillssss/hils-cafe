package org.hillsss.service;

import io.quarkus.narayana.jta.runtime.TransactionConfiguration;
import org.hillsss.Util.FormatUtil;
import org.hillsss.exception.ValidationException;
import org.hillsss.model.User;
import org.hillsss.model.dto.UserRequest;
import org.jose4j.jwk.Use;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Optional;

@ApplicationScoped
public class UserService {
    public Response post(UserRequest request) {
        if(!User.isEmptyByLoginName(request.loginName)) {
            throw new org.hillsss.exception.ValidationException("LOGIN_NAME_EXISTS");
        }

        if(FormatUtil.isPassword(request.password)) {
            throw new org.hillsss.exception.ValidationException("INVALID_PASSWORD");
        }

        if(FormatUtil.isEmail(request.email) || !FormatUtil.isAlphabet(request.fullName) ||
                !FormatUtil.isPhoneNumber(request.mobilePhoneNumber) || !FormatUtil.isPhoneNumber(request.workPhoneNumber)){
            throw new ValidationException("BAD_REQUEST");
        }

        persisUser(request);

        return Response.ok(new HashMap<>()).build();
    }
@Transactional
@TransactionConfiguration(timeout = 30)
        public User persisUser(UserRequest request){
    Optional<User> userOptional = User.findByLoginName(request.loginName);
    User user;
    if (userOptional.isEmpty()){
        user = new User();
    } else {
        user = userOptional.get();

    }

    user.setLoginName(request.loginName);
    user.setPassword(request.password);
    user.setFullName(request.fullName);
    user.setAddress(request.address);
    user.setEmail(request.email);
    user.setMobilePhoneNumber(request.mobilePhoneNumber);
    user.setWorkPhoneNumber(request.workPhoneNumber);
    User.persist(user);

    return user;
        }
}
