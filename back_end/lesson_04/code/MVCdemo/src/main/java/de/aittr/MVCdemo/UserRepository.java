package de.aittr.MVCdemo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private static List<User> list = new ArrayList<>(
            List.of( new User("Jack","Berlin")
                    ,new User("Lena","Potsdam")
                    ,new User("John","London")
                    ,new User("Ed","Potsdam")
                    ,new User("Oleg","Berlin")
            ));

    public List<User> findAll(){
        return list;
    }
    public Optional<User> findByID(Long id){
        return list.stream()
                .filter(u->u.getId().equals(id))
                .findFirst();
    }
}
