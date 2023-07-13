package de.aittr.auto;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AutoRepository {
    private static List<Auto> list = new ArrayList<>(List.of(
            new Auto(1L, "B140K823", "Opel"),
            new Auto(2L, "B140K824", "BMW"),
            new Auto(3L, "B140K825", "Audi"),
            new Auto(4L, "B140K826", "Opel")
    ));

    public List<Auto> findAll(){
        return  list;
    }


    public Auto save(Auto auto) {
        list.add(auto);
        return auto;
    }

    public Optional<Auto> findByID(Long id) {
        return list.stream()
                .filter(a->a.getId().equals(id))
                .findFirst();
    }
}

