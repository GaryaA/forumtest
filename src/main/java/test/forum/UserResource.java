package test.forum;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.forum.entity.UserEntity;
import test.forum.models.UserModel;
import test.forum.repo.UserRepo;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public UserModel create(@Valid @RequestBody UserModel user) {
        return convertToUserModel(userRepo.save(convertToUserEntity(user)));
    }

    @GetMapping("/{id}")
    public UserModel getById(@PathVariable UUID id) {
        return convertToUserModel(userRepo.getById(id));
    }

    //todo
    private static UserEntity convertToUserEntity(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userModel, userEntity);
        return userEntity;
    }

    //todo
    private static UserModel convertToUserModel(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userEntity, userModel);
        return userModel;
    }
}
