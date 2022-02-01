package io.github.jeanolivsou.JSnackbar.repositories;

import io.github.jeanolivsou.JSnackbar.entities.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LacheRepository extends JpaRepository<Lanche, Integer> {
}
