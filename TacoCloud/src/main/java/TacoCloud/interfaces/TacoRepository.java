package TacoCloud.interfaces;

import TacoCloud.Pojo.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    Taco save(Taco design);
}
