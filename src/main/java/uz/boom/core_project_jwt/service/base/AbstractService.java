package uz.boom.core_project_jwt.service.base;

import lombok.RequiredArgsConstructor;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;
import uz.boom.core_project_jwt.repository.base.BaseRepository;

@RequiredArgsConstructor
public abstract class AbstractService<R extends BaseRepository, M extends BaseMapper> implements BaseService {
    protected final R repository;
    protected final M mapper;
}
