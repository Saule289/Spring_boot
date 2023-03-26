package ru.saule289.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.saule289.demo.domain.LoginInfo;
import ru.saule289.demo.domain.UserInfo;
import ru.saule289.demo.exception.InvalidUserNameException;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class BankController {

private Map<String, UserInfo> users = Map.of(
        "Dima", UserInfo.builder().userName("Dima").build(),
        "Alexey", UserInfo.builder().userName("Alexey").build(),
        "Saule", UserInfo.builder().userName("Saule").build(),
        "Denis", UserInfo.builder().userName("Denis").build(),
        "Anna", UserInfo.builder().userName("Anna").build(),
        "Marina", UserInfo.builder().userName("Marina").build(),
        "Aliya", UserInfo.builder().userName("Aliya").build()
);
    @PostMapping("user/login")
    @ApiOperation("Авторизация")

     public UserInfo doLogin(@RequestBody LoginInfo loginInfo) {
        if (loginInfo.getUserName().equals("Saule")) {
            return UserInfo.builder()
                    .loginDate((new Date()))
                            .userName(loginInfo.getUserName())
                            .build();
        }
        else {
            throw new InvalidUserNameException();
        }
    }

    @GetMapping("user/getAll")
    @ApiOperation("Получение всех юзеров")
    public List<UserInfo> getALLUsersInfo() {
        return users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

}
