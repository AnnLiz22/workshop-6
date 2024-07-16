package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
