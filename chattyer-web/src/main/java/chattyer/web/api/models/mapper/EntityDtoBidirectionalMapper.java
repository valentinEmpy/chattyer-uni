package chattyer.web.api.models.mapper;

public interface EntityDtoBidirectionalMapper<E, D> {

    E toEntity(D dto);

    D toDTO(E entity);

}
