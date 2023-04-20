package uz.boom.core_project_jwt.controller.base;

import lombok.RequiredArgsConstructor;
import uz.boom.core_project_jwt.service.base.BaseService;


@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> implements BaseController {

    public final S service;
    protected final static String API = "/api";
    protected final static String VERSION = "/v1";
    protected final static String PATH = API + VERSION;


}
