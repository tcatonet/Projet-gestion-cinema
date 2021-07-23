package com.under.demo.security.user;
import org.springframework.beans.factory.annotation.Value;
import com.under.demo.security.login.LoginDTO;
import com.under.demo.security.security.TokenProvider;
import com.under.demo.security.user.DTO.*;
import org.jdom.IllegalNameException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServlet;
import java.util.logging.Logger;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping()
public class UserControlleur extends HttpServlet {

    public UserControlleur(UserService userService, TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManager) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello world");
    }

    private final UserService userService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");

    SessionToken sessionTokenManageUser;
    SessionToken sessionTokenBuisnessLogic;
    SessionToken sessionEducationManager;

    private final String LOGIN_SYSTEME = "systeme";
    private final String PASSWORD_SYSTEME = "systeme";

    @Value("${url.manageuser}")
    private String BASE_URL;

    @Value("${url.marketmanager}")
    private String BASE_URL2;

    @Value("${url.educationmanager}")
    private String BASE_URL3;


    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManager;

    @Autowired
    RestTemplate restTemplate;



    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) throws JSONException {


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getName(), loginDTO.getPassword());
        Authentication authentication = authenticationManager.getObject().authenticate(authenticationToken);
        String tokenUser = tokenProvider.createToken(authentication);
        LOGGER.info(BASE_URL);

        String endpoint = "/login";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestJson = "{\"name\":\""+LOGIN_SYSTEME+"\",\"password\":\""+PASSWORD_SYSTEME+"\" }";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );

        String body = String.valueOf(message.getBody());
        JSONObject jsonObject = new JSONObject(body);
        String stringObject = String.valueOf(jsonObject.get("body"));
        jsonObject = new JSONObject(stringObject);
        stringObject = String.valueOf(jsonObject.get("token"));
        String tokenAPI = stringObject.substring(2, stringObject.length()-2);

        sessionTokenManageUser = new SessionToken();
        sessionTokenManageUser.setToken(tokenAPI);

        LOGGER.info(BASE_URL2);

        endpoint = "/login";
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        requestJson = "{\"name\":\""+LOGIN_SYSTEME+"\",\"password\":\""+PASSWORD_SYSTEME+"\" }";
        requestToSend = new HttpEntity<String>(requestJson, headers);
        message = restTemplate.postForEntity( BASE_URL2+endpoint, requestToSend , String.class );

        body = String.valueOf(message.getBody());
        jsonObject = new JSONObject(body);
        stringObject = String.valueOf(jsonObject.get("body"));
        jsonObject = new JSONObject(stringObject);
        stringObject = String.valueOf(jsonObject.get("token"));
        tokenAPI = stringObject.substring(2, stringObject.length()-2);

        sessionTokenBuisnessLogic = new SessionToken();
        sessionTokenBuisnessLogic.setToken(tokenAPI);


        LOGGER.info(BASE_URL3);
        endpoint = "/login";
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        requestJson = "{\"name\":\""+LOGIN_SYSTEME+"\",\"password\":\""+PASSWORD_SYSTEME+"\" }";
        requestToSend = new HttpEntity<String>(requestJson, headers);
        message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );

        body = String.valueOf(message.getBody());
        jsonObject = new JSONObject(body);
        stringObject = String.valueOf(jsonObject.get("body"));
        jsonObject = new JSONObject(stringObject);
        stringObject = String.valueOf(jsonObject.get("token"));
        tokenAPI = stringObject.substring(2, stringObject.length()-2);

        sessionEducationManager = new SessionToken();
        sessionEducationManager.setToken(tokenAPI);



        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION, "Bearer " + tokenUser);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();




        map.add("token", tokenUser);

        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);

        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody CreateAccountDTO request) {

        if ("none".equalsIgnoreCase(request.getName())) {
            throw new IllegalNameException("Illegal name for none");
        }
        if ("none".equalsIgnoreCase(request.getEmail())) {
            throw new IllegalNameException("Illegal name for none");
        }
        if ("none".equalsIgnoreCase(request.getPassword())) {
            throw new IllegalNameException("Illegal name for none");
        }
        String response = userService.createUser(request.getName(), request.getPassword(), request.getEmail());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);

        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @PostMapping("/user/name/get")
    public ResponseEntity getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        String endpoint = "/user/name/get";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenManageUser.getToken());

        String requestJson = "{\"name\":\""+username+"\"}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );



        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @PostMapping("/user/password/update")
    public ResponseEntity updateUserPassword(@RequestBody UpdatePasswordDTO updatePasswordDTO) {
        if ("none".equalsIgnoreCase(updatePasswordDTO.getPassword())) {
            throw new IllegalNameException("Illegal name for none");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        String endpoint = "/user/password/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenManageUser.getToken());

        String requestJson = "{\"name\":\""+username+"\",\"password\":\""+updatePasswordDTO.getPassword()+"\" }";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );


        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @PostMapping("/user/email/get")
    public ResponseEntity getUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        String endpoint = "/user/email/get";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenManageUser.getToken());

        String requestJson = "{\"name\":\""+username+"\"}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @PostMapping("/user/email/update")
    public ResponseEntity updateUserEmail(@RequestBody UpdateEmailDTO updateEmailDTO) {
        if ("none".equalsIgnoreCase(updateEmailDTO.getEmail())) {
            throw new IllegalNameException("Illegal name for none");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        String endpoint = "/user/email/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenManageUser.getToken());

        String requestJson = "{\"name\":\""+username+"\",\"email\":\""+updateEmailDTO.getEmail()+"\" }";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );


        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/admin/users/get")
    public ResponseEntity getUsers() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        String endpoint = "/admin/users/get";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenManageUser.getToken());

        String requestJson = "{\"name\":\""+username+"\"}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );


        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/admin/create")
    public ResponseEntity createAdmin(@RequestBody CreateAccountDTO createAccountDTO) {
        if ("none".equalsIgnoreCase(createAccountDTO.getName())) {
            throw new IllegalNameException("Illegal name for none");
        }
        if ("none".equalsIgnoreCase(createAccountDTO.getPassword())) {
            throw new IllegalNameException("Illegal name for none");
        }
        if ("none".equalsIgnoreCase(createAccountDTO.getEmail())) {
            throw new IllegalNameException("Illegal name for none");
        }

        String endpoint = "/admin/create";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenManageUser.getToken());

        String requestJson = "{\"name\":\""+createAccountDTO.getName()+"\",\"email\":\""+createAccountDTO.getEmail()+"\", \"password\":\""+createAccountDTO.getEmail()+"\" }";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }








    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/project/join")
    public ResponseEntity projectJoin() {
        String endpoint = "/user/project/join";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/project/left")
    public ResponseEntity projectLeft() {
        String endpoint = "/user/project/left";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/contractorMembership/apply")
    public ResponseEntity contractorMembershipApply() {
        String endpoint = "/user/contractorMembership/apply";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/paymentHistorique/get")
    public ResponseEntity paymentHistorique() {
        String endpoint = "/user/paymentHistorique/get";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

















    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/formation/subscribe")
    public ResponseEntity formationSubscribe() {
        String endpoint = "/user/formation/subscribe";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL3+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/formation/quit")
    public ResponseEntity formationQuit() {
        String endpoint = "/user/formation/quit";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL3+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/formation/find")
    public ResponseEntity formationFind() {
        String endpoint = "/user/formation/find";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL3+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("admin/formation/close")
    public ResponseEntity formationClose() {
        String endpoint = "/user/formation/close";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL3+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("admin/formation/add")
    public ResponseEntity formationAdd() {
        String endpoint = "/user/formation/add";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());
        LOGGER.info("add");
        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL3+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }





    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("admin/certification/give")
    public ResponseEntity certificationGive() {
        String endpoint = "/user/certification/give";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL3+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }























    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/project/create/request")
    public ResponseEntity projectRequestCreate() {
        String endpoint = "/market/project/create/request";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL2+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/project/close/request")
    public ResponseEntity projectRequestClose() {
        String endpoint = "/market/project/close/request";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL2+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/project/date/update")
    public ResponseEntity projectUpdateDate() {
        String endpoint = "/market/project/date/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL2+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/project/billRate/update")
    public ResponseEntity projectUpdateBillRate() {
        String endpoint = "/market/project/billRate/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL2+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/project/active")
    public ResponseEntity projectActive() {
        String endpoint = "/market/project/active";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL2+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/project/tradsmen/match")
    public ResponseEntity projectTradsmenMatch() {
        String endpoint = "/market/project/tradsmen/match";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL2+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("user/project/match")
    public ResponseEntity projectMatch() {
        String endpoint = "/market/project/match";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        LOGGER.info(BASE_URL2);
        headers.add(AUTHORIZATION, "Bearer " + sessionTokenBuisnessLogic.getToken());

        String requestJson = "{}";
        HttpEntity<String> requestToSend = new HttpEntity<String>(requestJson, headers);
        ResponseEntity<String> message = restTemplate.postForEntity( BASE_URL2+endpoint, requestToSend , String.class );

        MultiValueMap<String, ResponseEntity<String>> map = new LinkedMultiValueMap<>();
        map.add("msg", message);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, ResponseEntity<String>>> requeteHttp = new HttpEntity<MultiValueMap<String, ResponseEntity<String>>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }









}
